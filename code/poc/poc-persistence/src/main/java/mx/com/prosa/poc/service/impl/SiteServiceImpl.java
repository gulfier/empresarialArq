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

import mx.com.prosa.poc.model.SiteDO;
import mx.com.prosa.poc.persistence.ApplicationRepository;
import mx.com.prosa.poc.persistence.SiteRepository;
import mx.com.prosa.poc.service.SiteService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.SiteTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface {@link mx.com.prosa.poc.service.SiteService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class SiteServiceImpl implements SiteService
{

  private static final String VALIDATION_ERROR = "Error de validaci\u00F3n";
  private static final String VALIDATION_ERROR_SITE_CODE_EXISTS = "Ya existe el sitio";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER = "Hay %s aplicaciones asociadas al sitio";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED = "Hay aplicaciones asociadas al sitio";

  @Autowired
  private SiteRepository siteRepository;

  @Autowired
  private ApplicationRepository applicationRepository;
  /**
   * {@inheritDoc}
   */
  @Override
  public void save( SiteTO site )
  {
    BaseTOValidationUtil.validateSave( site );
    validateExistence( site );

    SiteDO entity = new SiteDO();
    entity.setCode( site.getCode().trim() );
    entity.setName( site.getName().trim() );
    entity.setCreation( Calendar.getInstance().getTime() );
    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserCreation( site.getUser() );
    entity.setUserModified( site.getUser() );
    this.siteRepository.save( entity );
    this.siteRepository.flush();
    site.setId( entity.getId() );

  }

  private void validateExistence( SiteTO site )
  {
    Optional<SiteDO> exists = this.siteRepository.findByCode( site.getCode().trim() );
    if( exists.isPresent() )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( VALIDATION_ERROR_SITE_CODE_EXISTS );
      throw e;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<SiteTO> findAll( PagingRequestTO<SiteTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    Page<SiteDO> paged = this.siteRepository.findAll( pg );

    PagingResponseTO<SiteTO> response = new PagingResponseTO<>();

    List<SiteTO> data = new ArrayList<>();

    paged.get().forEach( entity -> {
      SiteTO site = transform2TO( entity );
      data.add( site );
    } );

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( paged.getTotalElements() );
    response.setPages( paged.getTotalPages() );

    return response;
  }

  private SiteTO transform2TO( SiteDO entity )
  {
    SiteTO siteTO = new SiteTO();
    siteTO.setId( entity.getId() );
    siteTO.setCode( entity.getCode() );
    siteTO.setName( entity.getName() );

    siteTO.setApplications( new ArrayList<>() );
    if( CollectionUtils.isNotEmpty( entity.getApplications() ) )
    {
      entity.getApplications().stream().forEach( app -> {
        BaseTO applicationTO = new BaseTO();
        applicationTO.setId( app.getId() );
        applicationTO.setCode( app.getCode() );
        applicationTO.setName( app.getName() );
        siteTO.getApplications().add( applicationTO );
      } );
    }
    return siteTO;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<SiteTO> findByExample( PagingRequestTO<SiteTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    SiteDO itService = new SiteDO();

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

    Example<SiteDO> example = Example.of( itService, matcher );

    Page<SiteDO> paged = this.siteRepository.findAll( example, pg );

    PagingResponseTO<SiteTO> response = new PagingResponseTO<>();

    List<SiteTO> data = new ArrayList<>();

    paged.get().forEach( entity -> {
      SiteTO siteTO = transform2TO( entity );
      data.add( siteTO );
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
  public SiteTO findById( Long id )
  {
    SiteTO to = null;
    Optional<SiteDO> op = this.siteRepository.findById( id );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.SITE_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SiteTO findByCode( String code )
  {
    SiteTO to = null;
    Optional<SiteDO> op = this.siteRepository.findByCode( code );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.SITE_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( SiteTO site, boolean patch )
  {
    if( patch )
    {
      BaseTOValidationUtil.validateIdNotNull( site );
    }
    else
    {
      BaseTOValidationUtil.validateEdit( site );
    }
    SiteDO entity = this.siteRepository.findById( site.getId() )
        .orElseThrow( SupplierBusinessException.SITE_NOT_FOUND );

    if( ((patch && site.getCode() != null) || !patch) && !entity.getCode().equals( site.getCode().trim() ) )
    {
      validateExistence( site );
      entity.setCode( site.getCode().trim() );
    }

    if( (patch && site.getName() != null) || !patch )
    {
      entity.setName( site.getName() );
    }
    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserModified( site.getUser() );

    this.siteRepository.save( entity );
    this.siteRepository.flush();

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( SiteTO site )
  {
    BaseTOValidationUtil.validateDelete( site );
    SiteDO entity = this.siteRepository.findById( site.getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );

    long count = this.applicationRepository.countBySiteId( site.getId() );
    if( count > 0L )
    {
      BusinessException e = new BusinessException( VALIDATION_ERROR_APPLICATION_ASSOCIATED );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( String.format( VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER, count ) );
      throw e;
    }

    this.siteRepository.delete( entity );
  }

}
