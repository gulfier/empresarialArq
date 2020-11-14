package mx.com.prosa.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.prosa.poc.to.ApplicationTO;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class ApplicationServiceTest
{

  private static final Logger LOG = LoggerFactory.getLogger( ApplicationServiceTest.class );

  @Autowired
  private ApplicationService applicationService;

  @Test
  public void testFindAll_empty()
  {
    PagingResponseTO<ApplicationTO> response = applicationService.findAll( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindAll_page()
  {
    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );

    PagingResponseTO<ApplicationTO> response = applicationService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindAll_pageSort()
  {
    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    request.setDirection( PagingRequestTO.Direction.ASC );
    request.setSortBy( "id" );

    PagingResponseTO<ApplicationTO> response = applicationService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindByExample_empty()
  {

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindByExample_name()
  {

    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    ApplicationTO search = new ApplicationTO();
    search.setName( "aplica" );
    request.setSearch( search );

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindByExample_nameAndCode()
  {

    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    ApplicationTO search = new ApplicationTO();
    search.setName( "aplica" );
    search.setCode( "003" );
    request.setSearch( search );

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindByExample_siteId()
  {

    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    ApplicationTO search = new ApplicationTO();

    search.setSite( new BaseTO() );
    search.getSite().setId( 1L );
    request.setSearch( search );

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }
  
  
  @Test
  public void testFindByExample_itServiceId()
  {

    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    ApplicationTO search = new ApplicationTO();

    search.setItService(  new BaseTO() );
    search.getItService().setId( 1L );
    request.setSearch( search );

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindByExample_nameAndSiteId()
  {

    PagingRequestTO<ApplicationTO> request = new PagingRequestTO<>();
    ApplicationTO search = new ApplicationTO();
    search.setName( "B" );
    search.setSite( new BaseTO() );
    search.getSite().setId( 1L );
    request.setSearch( search );

    PagingResponseTO<ApplicationTO> response = applicationService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindById()
  {
    ApplicationTO response = this.applicationService.findById( 1L );

    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindById_notExists()
  {
    ApplicationTO response = this.applicationService.findById( 9999L );

    Assert.assertNull( response );
  }

  @Test
  public void testFindByCode()
  {
    ApplicationTO response = this.applicationService.findByCode( "APP001" );

    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByCode_notExists()
  {
    ApplicationTO response = this.applicationService.findByCode( "qwertyuiop" );

    Assert.assertNull( response );
  }

  @Test
  public void testSave()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }

  @Test(expected = BusinessException.class)
  public void testSave_null()
  {
    this.applicationService.save( null );
  }

  @Test(expected = BusinessException.class)
  public void testSave_codeMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();

    this.applicationService.save( applicationTO );

  }

  @Test(expected = BusinessException.class)
  public void testSave_nameMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );

    this.applicationService.save( applicationTO );

  }

  @Test(expected = BusinessException.class)
  public void testSave_siteMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    this.applicationService.save( applicationTO );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }

  @Test(expected = BusinessException.class)
  public void testSave_siteIdMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    this.applicationService.save( applicationTO );

  }

  @Test(expected = BusinessException.class)
  public void testSave_itServiceMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    this.applicationService.save( applicationTO );

  }

  @Test(expected = BusinessException.class)
  public void testSave_itServiceIdMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    this.applicationService.save( applicationTO );

  }

  @Test(expected = BusinessException.class)
  public void testSave_serversMissing()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( UUID.randomUUID().toString() );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );

    this.applicationService.save( applicationTO );
  }

  @Test(expected = BusinessException.class)
  public void testSave_existingCode()
  {
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( "APP001" );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }

  @Test
  public void testEdit()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    applicationTO.setUser( "user@test.com" );
    code = UUID.randomUUID().toString();

    applicationTO.setCode( code );
    applicationTO.setComment( "qwerty" );
    applicationTO.setName( "Other name" );
    applicationTO.getSite().setId( 2L );
    applicationTO.getItService().setId( 2L );
    servers = new ArrayList<>();
    s1 = new BaseTO();
    s1.setId( 2L );
    servers.add( s1 );
    s2 = new BaseTO();
    s2.setId( 3L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.edit( applicationTO, false );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patch()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    applicationTO.setUser( "user@test.com" );
    code = UUID.randomUUID().toString();

    applicationTO.setCode( code );
    applicationTO.setComment( "qwerty" );
    applicationTO.setName( "Other name" );
    applicationTO.getSite().setId( 2L );
    applicationTO.getItService().setId( 2L );
    servers = new ArrayList<>();
    s1 = new BaseTO();
    s1.setId( 2L );
    servers.add( s1 );
    s2 = new BaseTO();
    s2.setId( 3L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.edit( applicationTO, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  
  @Test
  public void testEdit_patchName()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setName( "new name" );
    app.setUser( "user@test.com" );
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patchCode()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    code = UUID.randomUUID().toString();
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setCode( code );
    app.setUser( "user@test.com" );
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patchComment()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setComment( "Nuevo comentario" );
    app.setUser( "user@test.com" );
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patchSite()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setUser( "user@test.com" );
    app.setSite( new BaseTO() );
    app.getSite().setId( 2L );
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patchITService()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setUser( "user@test.com" );
    app.setItService( new BaseTO() );
    app.getItService().setId( 2L );
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }
  
  
  @Test
  public void testEdit_patchServer()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    
    ApplicationTO app = new ApplicationTO();
    app.setId( applicationTO.getId() ); 
    app.setUser( "user@test.com" );
    app.setServers( new ArrayList<>() );
    s1 = new BaseTO();
    s1.setId( 1L );
    app.getServers().add( s1 );
    
    this.applicationService.edit( app, true );

    applicationTO = this.applicationService.findByCode( code );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( applicationTO ) );
  }

  @Test(expected = BusinessException.class)
  public void testEdit_applicationIdMissing()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setId( null );

    applicationTO.setComment( "qwerty" );
    applicationTO.setName( "Other name" );
    applicationTO.getSite().setId( 2L );
    applicationTO.getItService().setId( 2L );
    servers = new ArrayList<>();
    s1 = new BaseTO();
    s1.setId( 2L );
    servers.add( s1 );
    s2 = new BaseTO();
    s2.setId( 3L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.edit( applicationTO, false );

  }

  @Test
  public void testDelete()
  {
    String code = UUID.randomUUID().toString();
    ApplicationTO applicationTO = new ApplicationTO();
    applicationTO.setCode( code );
    applicationTO.setName( "Application Name" );
    applicationTO.setComment( "Lorem ipsum dolor sit amet" );
    applicationTO.setUser( "user@test.com" );
    applicationTO.setSite( new BaseTO() );
    applicationTO.getSite().setId( 1L );
    applicationTO.setItService( new BaseTO() );
    applicationTO.getItService().setId( 1L );
    List<BaseTO> servers = new ArrayList<>();
    BaseTO s1 = new BaseTO();
    s1.setId( 1L );
    servers.add( s1 );
    BaseTO s2 = new BaseTO();
    s2.setId( 2L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.save( applicationTO );

    applicationTO = this.applicationService.findByCode( code );
    applicationTO.setUser( "user@test.com" );

    applicationTO.setComment( "qwerty" );
    applicationTO.setName( "Other name" );
    applicationTO.getSite().setId( 2L );
    applicationTO.getItService().setId( 2L );
    servers = new ArrayList<>();
    s1 = new BaseTO();
    s1.setId( 2L );
    servers.add( s1 );
    s2 = new BaseTO();
    s2.setId( 3L );
    servers.add( s2 );
    applicationTO.setServers( servers );
    this.applicationService.delete( applicationTO );

    applicationTO = this.applicationService.findByCode( code );

    Assert.assertNull( applicationTO );
  }

  @Test(expected = BusinessException.class)
  public void testDelete_empty()
  {

    this.applicationService.delete( null );

  }

  @Test(expected = BusinessException.class)
  public void testDelete_applicationIdMissing()
  {

    this.applicationService.delete( new ApplicationTO() );

  }
}
