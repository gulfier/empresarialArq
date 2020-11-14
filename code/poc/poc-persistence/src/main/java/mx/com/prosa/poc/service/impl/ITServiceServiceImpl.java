
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

import mx.com.prosa.poc.model.ITServiceDO;
import mx.com.prosa.poc.persistence.ApplicationRepository;
import mx.com.prosa.poc.persistence.ITServiceRepository;
import mx.com.prosa.poc.service.ITServiceService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface {@link ITServiceService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class ITServiceServiceImpl implements ITServiceService
{

  private static final String VALIDATION_ERROR_IT_SERVICE_CODE_EXISTS = "Ya existe el servicio de TI";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER = "Hay %s aplicaciones asociadas al servicio de IT";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED = "Hay aplicaciones asociadas al servicio de IT";

  @Autowired
  private ITServiceRepository itServiceRepository;

  @Autowired
  private ApplicationRepository applicationRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public void save( ITServiceTO itService )
  {
    BaseTOValidationUtil.validateSave( itService );
    validateExistence( itService );

    ITServiceDO entity = new ITServiceDO();
    entity.setCode( itService.getCode().trim() );
    entity.setName( itService.getName().trim() );
    entity.setCreation( Calendar.getInstance().getTime() );
    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserCreation( itService.getUser() );
    entity.setUserModified( itService.getUser() );
    this.itServiceRepository.save( entity );
    this.itServiceRepository.flush();
    itService.setId( entity.getId() );
  }

  private void validateExistence( ITServiceTO itService )
  {
    Optional<ITServiceDO> exists = this.itServiceRepository.findByCode( itService.getCode().trim() );
    if( exists.isPresent() )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR_IT_SERVICE_CODE_EXISTS );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( VALIDATION_ERROR_IT_SERVICE_CODE_EXISTS );
      throw e;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ITServiceTO> findAll( PagingRequestTO<ITServiceTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    Page<ITServiceDO> paged = this.itServiceRepository.findAll( pg );

    PagingResponseTO<ITServiceTO> response = new PagingResponseTO<>();

    List<ITServiceTO> data = new ArrayList<>();

    paged.get().forEach( a -> {
      ITServiceTO applicationTO = transform2TO( a );
      data.add( applicationTO );
    } );

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( paged.getTotalElements() );
    response.setPages( paged.getTotalPages() );

    return response;
  }

  private ITServiceTO transform2TO( ITServiceDO entity )
  {
    ITServiceTO itServiceTO = new ITServiceTO();
    itServiceTO.setId( entity.getId() );
    itServiceTO.setCode( entity.getCode() );
    itServiceTO.setName( entity.getName() );
    itServiceTO.setApplications( new ArrayList<>() );
    if( CollectionUtils.isNotEmpty( entity.getApplications() ) )
    {
      entity.getApplications().stream().forEach( app -> {
        BaseTO applicationTO = new BaseTO();
        applicationTO.setId( app.getId() );
        applicationTO.setCode( app.getCode() );
        applicationTO.setName( app.getName() );
        itServiceTO.getApplications().add( applicationTO );
      } );
    }

    return itServiceTO;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ITServiceTO> findByExample( PagingRequestTO<ITServiceTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    ITServiceDO itService = new ITServiceDO();

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

    Example<ITServiceDO> example = Example.of( itService, matcher );

    Page<ITServiceDO> paged = this.itServiceRepository.findAll( example, pg );

    PagingResponseTO<ITServiceTO> response = new PagingResponseTO<>();

    List<ITServiceTO> data = new ArrayList<>();

    paged.get().forEach( a -> {
      ITServiceTO applicationTO = transform2TO( a );
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
  public ITServiceTO findById( Long id )
  {
    ITServiceTO to = null;
    Optional<ITServiceDO> op = this.itServiceRepository.findById( id );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.IT_SERVICE_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ITServiceTO findByCode( String code )
  {
    ITServiceTO to = null;
    Optional<ITServiceDO> op = this.itServiceRepository.findByCode( code );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.IT_SERVICE_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( ITServiceTO itService, boolean patch )
  {
    if( patch )
    {
      BaseTOValidationUtil.validateIdNotNull( itService );
    }
    else
    {
      BaseTOValidationUtil.validateEdit( itService );
    }
    ITServiceDO entity = this.itServiceRepository.findById( itService.getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );

    if( ((patch && itService.getCode() != null) || !patch) && !entity.getCode().equals( itService.getCode().trim() ) )
    {
      validateExistence( itService );
      entity.setCode( itService.getCode().trim() );
    }

    if( (patch && itService.getName() != null) || !patch )
    {
      entity.setName( itService.getName() );
    }

    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserModified( itService.getUser() );

    this.itServiceRepository.save( entity );
    this.itServiceRepository.flush();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( ITServiceTO itService )
  {
    BaseTOValidationUtil.validateDelete( itService );
    ITServiceDO entity = this.itServiceRepository.findById( itService.getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );

    long count = this.applicationRepository.countByITServiceId( itService.getId() );
    if( count > 0L )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR_APPLICATION_ASSOCIATED );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( String.format( VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER, count ) );
      throw e;
    }

    this.itServiceRepository.delete( entity );
  }

}
