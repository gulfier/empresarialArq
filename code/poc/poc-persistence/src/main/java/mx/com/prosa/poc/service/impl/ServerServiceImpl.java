package mx.com.prosa.poc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.ServerDO;
import mx.com.prosa.poc.persistence.ServerRepository;
import mx.com.prosa.poc.service.ServerService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.ServerTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface {@link mx.com.prosa.poc.service.ServerService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class ServerServiceImpl implements ServerService
{

  private static final String VALIDATION_ERROR_SERVER_CODE_EXISTS = "Ya existe el servidor";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER = "Hay %s aplicaciones asociadas al servidor";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED = "Hay aplicaciones asociadas al servidor";

  @Autowired
  private ServerRepository serverRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public void save( ServerTO server )
  {
    BaseTOValidationUtil.validateSave( server );
    validateExistence( server );

    ServerDO entity = new ServerDO();
    entity.setCode( server.getCode().trim() );
    entity.setName( server.getName().trim() );
    entity.setCreation( Calendar.getInstance().getTime() );
    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserCreation( server.getUser() );
    entity.setUserModified( server.getUser() );
    this.serverRepository.save( entity );
    this.serverRepository.flush();
    server.setId( entity.getId() );

  }

  private void validateExistence( ServerTO server )
  {
    Optional<ServerDO> exists = this.serverRepository.findByCode( server.getCode().trim() );
    if( exists.isPresent() )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR_SERVER_CODE_EXISTS );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( VALIDATION_ERROR_SERVER_CODE_EXISTS );
      throw e;
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ServerTO> findAll( PagingRequestTO<ServerTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    Page<ServerDO> paged = this.serverRepository.findAll( pg );

    PagingResponseTO<ServerTO> response = new PagingResponseTO<>();

    List<ServerTO> data = new ArrayList<>();

    paged.get().forEach( entity -> {
      ServerTO serverTO = transform2TO( entity );
      data.add( serverTO );
    } );

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( paged.getTotalElements() );
    response.setPages( paged.getTotalPages() );

    return response;
  }

  private ServerTO transform2TO( ServerDO entity )
  {
    ServerTO serverTO = new ServerTO();
    serverTO.setId( entity.getId() );
    serverTO.setCode( entity.getCode() );
    serverTO.setName( entity.getName() );
    serverTO.setApplications( new ArrayList<>() );
    if( CollectionUtils.isNotEmpty( entity.getApplications() ) )
    {
      entity.getApplications().stream().forEach( app -> {
        BaseTO applicationTO = new BaseTO();
        applicationTO.setId( app.getId() );
        applicationTO.setCode( app.getCode() );
        applicationTO.setName( app.getName() );
        serverTO.getApplications().add( applicationTO );
      } );
    }

    return serverTO;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ServerTO> findByExample( PagingRequestTO<ServerTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    ServerDO itService = new ServerDO();

    if( request != null && request.getSearch() != null )
    {
      if( StringUtils.isNotBlank( request.getSearch().getName() ) )
      {
        itService.setName( request.getSearch().getName().trim() );
      }
      if( StringUtils.isNotBlank( request.getSearch().getCode() ) )
      {
        itService.setCode( request.getSearch().getCode() );
      }
    }

    ExampleMatcher matcher = ExampleMatcher.matchingAll()
        .withMatcher( "name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase() )
        .withMatcher( "code", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase() );

    Example<ServerDO> example = Example.of( itService, matcher );

    Page<ServerDO> paged = this.serverRepository.findAll( example, pg );

    PagingResponseTO<ServerTO> response = new PagingResponseTO<>();

    List<ServerTO> data = new ArrayList<>();

    paged.get().forEach( entity -> {
      ServerTO applicationTO = transform2TO( entity );
      data.add( applicationTO );
    } );

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( paged.getTotalElements() );
    response.setPages( paged.getTotalPages() );

    return response;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ServerTO findById( Long id )
  {
    ServerTO to = null;
    Optional<ServerDO> op = this.serverRepository.findById( id );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.SERVER_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ServerTO findByCode( String code )
  {
    ServerTO to = null;
    Optional<ServerDO> op = this.serverRepository.findByCode( code );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.SERVER_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( ServerTO server, boolean patch )
  {
    if( patch )
    {
      BaseTOValidationUtil.validateIdNotNull( server );
    }
    else
    {
      BaseTOValidationUtil.validateEdit( server );
    }
    ServerDO entity = this.serverRepository.findById( server.getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );

    if( ((patch && server.getCode() != null) || !patch) && !entity.getCode().equals( server.getCode().trim() ) )
    {
      validateExistence( server );
      entity.setCode( server.getCode().trim() );
    }

    if( (patch && server.getName() != null) || !patch )
    {
      entity.setName( server.getName() );
    }

    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserModified( server.getUser() );

    this.serverRepository.save( entity );
    this.serverRepository.flush();

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( ServerTO server )
  {
    BaseTOValidationUtil.validateDelete( server );
    ServerDO entity = this.serverRepository.findById( server.getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );

    long count = this.serverRepository.countApplicationAssociatedByServerId( server.getId() );
    if( count > 0L )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR_APPLICATION_ASSOCIATED );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( String.format( VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER, count ) );
      throw e;
    }

    this.serverRepository.delete( entity );

  }

}
