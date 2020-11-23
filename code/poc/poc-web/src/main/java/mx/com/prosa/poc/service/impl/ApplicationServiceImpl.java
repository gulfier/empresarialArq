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

import mx.com.prosa.poc.model.ApplicationDO;
import mx.com.prosa.poc.model.ITServiceDO;
import mx.com.prosa.poc.model.ServerDO;
import mx.com.prosa.poc.model.SiteDO;
import mx.com.prosa.poc.persistence.ApplicationRepository;
import mx.com.prosa.poc.persistence.ITServiceRepository;
import mx.com.prosa.poc.persistence.ServerRepository;
import mx.com.prosa.poc.persistence.SiteRepository;
import mx.com.prosa.poc.service.ApplicationService;
import mx.com.prosa.poc.to.ApplicationTO;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface {@link mx.com.prosa.poc.service.ApplicationService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class ApplicationServiceImpl implements ApplicationService
{

  @Autowired
  private ApplicationRepository applicationRepository;

  @Autowired
  private ServerRepository serverRepository;

  @Autowired
  private SiteRepository siteRepository;

  @Autowired
  private ITServiceRepository itServiceRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public void save( ApplicationTO application )
  {
    BaseTOValidationUtil.validateSave( application );
    validateApplicationSave( application, false );
    validateExistence( application );

    ApplicationDO entity = new ApplicationDO();
    entity.setCode( application.getCode().trim() );
    entity.setName( application.getName().trim() );
    entity.setComment( application.getComment() );
    entity.setCreation( Calendar.getInstance().getTime() );
    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserCreation( application.getUser() );
    entity.setUserModified( application.getUser() );

    ITServiceDO itService = this.itServiceRepository.findById( application.getItService().getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );
    entity.setItService( itService );

    SiteDO site = this.siteRepository.findById( application.getSite().getId() )
        .orElseThrow( SupplierBusinessException.SITE_NOT_FOUND );
    entity.setSite( site );

    List<ServerDO> servers = new ArrayList<>();
    serversLazyInit( application );
    application.getServers().stream().forEach( s -> {
      ServerDO server = this.serverRepository.findById( s.getId() )
          .orElseThrow( SupplierBusinessException.SERVER_NOT_FOUND );
      if( !servers.contains( server ) )
      {
        servers.add( server );
      }
    } );

    entity.setServers( servers );

    applicationRepository.save( entity );

    // Se guarda la relacion bidireccional
    applicationsLazyInit( itService );
    itService.getApplications().add( entity );
    this.itServiceRepository.save( itService );

    // Se guarda la relacion bidireccional
    applicationsLazyInit( site );
    site.getApplications().add( entity );
    this.siteRepository.save( site );

    // Se guarda la relacion bidireccional
    servers.stream().forEach( server -> {
      server.getApplications().add( entity );
      this.serverRepository.save( server );
    } );
    application.setId( entity.getId() );

  }

  private void applicationsLazyInit( SiteDO site )
  {
    if( site.getApplications() == null )
    {
      site.setApplications( new ArrayList<>() );
    }
  }

  private void applicationsLazyInit( ITServiceDO itService )
  {
    if( itService.getApplications() == null )
    {
      itService.setApplications( new ArrayList<>() );
    }
  }

  private void serversLazyInit( ApplicationTO application )
  {
    if( application.getServers() == null )
    {
      application.setServers( new ArrayList<>() );
    }
  }

  private void validateExistence( ApplicationTO application )
  {
    Optional<ApplicationDO> exists = applicationRepository.findByCode( application.getCode().trim() );
    if( exists.isPresent() )
    {
      BusinessException e = new BusinessException( "Ya existe la aplicacion" );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( "Ya existe la aplicacion" );
      throw e;
    }
  }

  private void validateApplicationSave( ApplicationTO application, boolean patch )
  {

    if( !patch && (application.getSite() == null || application.getSite().getId() == null) )
    {
      BusinessException e = new BusinessException( "Datos incorrectos" );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( "Datos incorrectos: site" );
      throw e;
    }

    if( !patch && (application.getItService() == null || application.getItService().getId() == null) )
    {
      BusinessException e = new BusinessException( "Datos incorrectos" );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( "Datos incorrectos: itService" );
      throw e;
    }

    if( !patch && (CollectionUtils.isEmpty( application.getServers() )) )
    {
      BusinessException e = new BusinessException( "Datos incorrectos" );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( "Datos incorrectos: servers" );
      throw e;
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ApplicationTO> findAll( PagingRequestTO<ApplicationTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    Page<ApplicationDO> paged = this.applicationRepository.findAll( pg );

    PagingResponseTO<ApplicationTO> response = new PagingResponseTO<>();

    List<ApplicationTO> data = new ArrayList<>();

    paged.get().forEach( a -> {
      ApplicationTO applicationTO = transform2TO( a );
      data.add( applicationTO );
    } );

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( paged.getTotalElements() );
    response.setPages( paged.getTotalPages() );

    return response;
  }

  private ApplicationTO transform2TO( ApplicationDO a )
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setId( a.getId() );
    applicationTO.setCode( a.getCode() );
    applicationTO.setName( a.getName() );
    applicationTO.setComment( a.getComment() );

    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( a.getSite().getId() );
    applicationTO.getSite().setCode( a.getSite().getCode() );
    applicationTO.getSite().setName( a.getSite().getName() );

    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( a.getItService().getId() );
    applicationTO.getItService().setCode( a.getItService().getCode() );
    applicationTO.getItService().setName( a.getItService().getName() );

    applicationTO.setServers( new ArrayList<>() );
    for( ServerDO s : a.getServers() )
    {
      BaseTO serverTO = new BaseTO();
      serverTO.setId( s.getId() );
      serverTO.setCode( s.getCode() );
      serverTO.setName( s.getName() );
      applicationTO.getServers().add( serverTO );
    }

    return applicationTO;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<ApplicationTO> findByExample( PagingRequestTO<ApplicationTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

    ApplicationDO app = new ApplicationDO();

    if( request != null && request.getSearch() != null )
    {
      if( StringUtils.isNotBlank( request.getSearch().getName() ) )
      {
        app.setName( request.getSearch().getName().trim() );
      }
      if( StringUtils.isNotBlank( request.getSearch().getCode() ) )
      {
        app.setCode( request.getSearch().getCode() );
      }
      if( request.getSearch().getSite() != null && request.getSearch().getSite().getId() != null )
      {
        SiteDO site = new SiteDO();
        site.setId( request.getSearch().getSite().getId() );
        app.setSite( site );
      }
      if( request.getSearch().getItService() != null && request.getSearch().getItService().getId() != null )
      {
        ITServiceDO itService = new ITServiceDO();
        itService.setId( request.getSearch().getItService().getId() );
        app.setItService( itService );
      }

    }

    ExampleMatcher matcher = ExampleMatcher.matchingAll()
        .withMatcher( "name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase() )
        .withMatcher( "code", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase() );

    Example<ApplicationDO> example = Example.of( app, matcher );

    Page<ApplicationDO> paged = this.applicationRepository.findAll( example, pg );

    PagingResponseTO<ApplicationTO> response = new PagingResponseTO<>();

    List<ApplicationTO> data = new ArrayList<>();

    paged.get().forEach( a -> {
      ApplicationTO applicationTO = transform2TO( a );
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
  public ApplicationTO findById( Long id )
  {
    ApplicationTO to = null;
    Optional<ApplicationDO> op = this.applicationRepository.findById( id );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.APPLICATION_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ApplicationTO findByCode( String code )
  {
    ApplicationTO to = null;
    Optional<ApplicationDO> op = this.applicationRepository.findByCode( code );
    if( op.isPresent() )
    {
      to = transform2TO( op.get() );
    }
    else
    {
      throw SupplierBusinessException.APPLICATION_NOT_FOUND.get();
    }
    return to;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( ApplicationTO application, boolean patch )
  {
    validateEdit( application, patch );
    ApplicationDO entity = this.applicationRepository.findById( application.getId() )
        .orElseThrow( SupplierBusinessException.APPLICATION_NOT_FOUND );

    editApplicationCode( application, patch, entity );
    editApplicationName( application, patch, entity );
    editApplicationComment( application, patch, entity );

    entity.setModified( Calendar.getInstance().getTime() );
    entity.setUserModified( application.getUser() );

    editItService( application, entity, patch );
    editSite( application, entity, patch );

    List<Long> idServers = new ArrayList<>();
    entity.getServers().stream().forEach( s -> {
      idServers.add( s.getId() );
    } );

    editApplicationServers( application, entity, idServers, patch );

    this.applicationRepository.save( entity );
    this.applicationRepository.flush();
  }

  private void editApplicationCode( ApplicationTO application, boolean patch, ApplicationDO entity )
  {
    if( ((patch && application.getCode() != null) || !patch)
        && !entity.getCode().equals( application.getCode().trim() ) )
    {
      validateExistence( application );
      entity.setCode( application.getCode().trim() );
    }
  }

  private void editApplicationName( ApplicationTO application, boolean patch, ApplicationDO entity )
  {
    if( (patch && application.getName() != null) || !patch )
    {
      entity.setName( application.getName() );
    }
  }

  private void editApplicationComment( ApplicationTO application, boolean patch, ApplicationDO entity )
  {
    if( (patch && application.getComment() != null) || !patch )
    {
      entity.setComment( application.getComment() );
    }
  }

  private void editSite( ApplicationTO application, ApplicationDO entity, boolean patch )
  {
    boolean edit;
    if( patch )
    {
      edit = application.getSite() != null && application.getSite().getId() != null
          && !entity.getSite().getId().equals( application.getSite().getId() );
    }
    else
    {
      edit = !entity.getSite().getId().equals( application.getSite().getId() );
    }

    if( edit )
    {
      entity.getSite().getApplications().remove( entity );
      this.siteRepository.save( entity.getSite() );

      SiteDO site = this.siteRepository.findById( application.getSite().getId() )
          .orElseThrow( SupplierBusinessException.SITE_NOT_FOUND );
      entity.setSite( site );

      // Se guarda la relacion bidireccional
      applicationsLazyInit( site );
      site.getApplications().add( entity );
      this.siteRepository.save( site );

    }
  }

  private void editItService( ApplicationTO application, ApplicationDO entity, boolean patch )
  {

    boolean edit;
    if( patch )
    {
      edit = application.getItService() != null && application.getItService().getId() != null
          && !entity.getItService().getId().equals( application.getItService().getId() );
    }
    else
    {
      edit = !entity.getItService().getId().equals( application.getItService().getId() );
    }

    if( edit )
    {
      entity.getItService().getApplications().remove( entity );
      this.itServiceRepository.save( entity.getItService() );

      ITServiceDO itService = this.itServiceRepository.findById( application.getItService().getId() )
          .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );
      entity.setItService( itService );

      // Se guarda la relacion bidireccional
      applicationsLazyInit( itService );
      itService.getApplications().add( entity );
      this.itServiceRepository.save( itService );
    }
  }

  private void editApplicationServers( ApplicationTO application, ApplicationDO entity, List<Long> idServers,
      boolean patch )
  {
    boolean edit = !patch || (patch && CollectionUtils.isNotEmpty( idServers ));

    if( edit )
    {
      List<Long> idServersApp = new ArrayList<>();
      serversLazyInit( application );
      application.getServers().stream().forEach( s -> {
        idServersApp.add( s.getId() );
      } );

      List<Long> removeServers = new ArrayList<>( CollectionUtils.removeAll( idServers, idServersApp ) );
      List<Long> addServers = new ArrayList<>( CollectionUtils.removeAll( idServersApp, idServers ) );

      removeServers.stream().forEach( serverId -> {
        ServerDO server = this.serverRepository.findById( serverId )
            .orElseThrow( SupplierBusinessException.SERVER_NOT_FOUND );
        entity.getServers().remove( server );

        server.getApplications().remove( entity );
        this.serverRepository.save( server );
      } );

      addServers.stream().forEach( serverId -> {
        ServerDO server = this.serverRepository.findById( serverId )
            .orElseThrow( SupplierBusinessException.SERVER_NOT_FOUND );
        server.getApplications().add( entity );
        this.serverRepository.save( server );

        entity.getServers().add( server );
      } );
    }

  }

  private void validateEdit( ApplicationTO application, boolean patch )
  {
    if( patch )
    {
      BaseTOValidationUtil.validateIdNotNull( application );
    }
    else
    {
      BaseTOValidationUtil.validateEdit( application );
    }

    validateApplicationSave( application, patch );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( ApplicationTO application )
  {
    // Agregar validaciones de borrado
    BaseTOValidationUtil.validateDelete( application );
    ApplicationDO entity = this.applicationRepository.findById( application.getId() )
        .orElseThrow( SupplierBusinessException.APPLICATION_NOT_FOUND );

    SiteDO site = this.siteRepository.findById( entity.getSite().getId() )
        .orElseThrow( SupplierBusinessException.SITE_NOT_FOUND );
    site.getApplications().remove( entity );
    this.siteRepository.save( site );

    ITServiceDO itService = this.itServiceRepository.findById( entity.getItService().getId() )
        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );
    itService.getApplications().remove( entity );
    this.itServiceRepository.save( itService );

    entity.getServers().stream().forEach( s -> {
      ServerDO server = this.serverRepository.findById( s.getId() )
          .orElseThrow( SupplierBusinessException.SERVER_NOT_FOUND );
      server.getApplications().remove( entity );
      this.serverRepository.save( server );
    } );
    entity.getServers().clear();
    this.applicationRepository.save( entity );

    this.applicationRepository.delete( entity );
  }

}
