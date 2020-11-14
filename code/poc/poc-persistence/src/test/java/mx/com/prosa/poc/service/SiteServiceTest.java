package mx.com.prosa.poc.service;

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

import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.SiteTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class SiteServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( SiteServiceTest.class );

  @Autowired
  private SiteService siteService;

  @Test
  public void testSave()
  {
    String code = UUID.randomUUID().toString();
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    SiteTO response = siteService.findById( siteTO.getId() );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindAll_empty()
  {
    PagingResponseTO<SiteTO> response = siteService.findAll( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_page()
  {
    PagingRequestTO<SiteTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );

    PagingResponseTO<SiteTO> response = siteService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_pageSort()
  {
    PagingRequestTO<SiteTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    request.setSortBy( "name" );
    request.setDirection( PagingRequestTO.Direction.ASC );

    PagingResponseTO<SiteTO> response = siteService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_empty()
  {

    PagingResponseTO<SiteTO> response = siteService.findByExample( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_name()
  {

    PagingRequestTO<SiteTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    SiteTO search = new SiteTO();
    search.setName( "Sitio B" );
    request.setSearch( search );

    PagingResponseTO<SiteTO> response = siteService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_nameAndCode()
  {

    PagingRequestTO<SiteTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    SiteTO search = new SiteTO();
    search.setName( "Sitio B" );
    search.setCode( "002" );
    request.setSearch( search );

    PagingResponseTO<SiteTO> response = siteService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindById()
  {
    SiteTO response = siteService.findById( 1L );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByCode()
  {
    SiteTO response = siteService.findByCode( "SITE001" );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testEdit()
  {
    String code = UUID.randomUUID().toString();
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    SiteTO response = siteService.findById( siteTO.getId() );
    Assert.assertNotNull( response );
    response.setUser( "user2@example.com" );
    response.setName( "qwerty2" );
    response.setCode( code );

    siteService.edit( response, false );

    response = siteService.findById( siteTO.getId() );

    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testEdit_patchCode()
  {
    String code = UUID.randomUUID().toString();
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    SiteTO response = siteService.findById( siteTO.getId() );
    Assert.assertNotNull( response );
    response.setUser( "user2@example.com" );
    response.setCode( code );

    siteService.edit( response, true );

    response = siteService.findById( siteTO.getId() );

    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testEdit_patchName()
  {
    String code = UUID.randomUUID().toString();
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    SiteTO response = siteService.findById( siteTO.getId() );
    Assert.assertNotNull( response );
    response.setUser( "user2@example.com" );
    response.setName( "qwerty2" );

    siteService.edit( response, true );

    response = siteService.findById( siteTO.getId() );

    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testDelete()
  {
    String code = UUID.randomUUID().toString();
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    siteService.delete( siteTO );

  }

  @Test(expected = BusinessException.class)
  public void testDelete_withApplications()
  {
    SiteTO siteTO = new SiteTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setId( 1L );

    siteService.delete( siteTO );
  }

}
