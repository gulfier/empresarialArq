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
import mx.com.prosa.poc.to.BitacoraCambiosTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class BitacoraCambiosServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( BitacoraCambiosServiceTest.class );

  @Autowired
  private BitacoraCambiosService siteService;

  @Test
  public void testSave()
  {
    String code = UUID.randomUUID().toString();
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    BitacoraCambiosTO response = siteService.findById( siteTO.getId() );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );

  }

  @Test
  public void testFindAll_empty()
  {
    PagingResponseTO<BitacoraCambiosTO> response = siteService.findAll( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_page()
  {
    PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );

    PagingResponseTO<BitacoraCambiosTO> response = siteService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_pageSort()
  {
    PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    request.setSortBy( "name" );
    request.setDirection( PagingRequestTO.Direction.ASC );

    PagingResponseTO<BitacoraCambiosTO> response = siteService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_empty()
  {

    PagingResponseTO<BitacoraCambiosTO> response = siteService.findByExample( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_name()
  {

    PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    BitacoraCambiosTO search = new BitacoraCambiosTO();
    search.setName( "Sitio B" );
    request.setSearch( search );

    PagingResponseTO<BitacoraCambiosTO> response = siteService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_nameAndCode()
  {

    PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    BitacoraCambiosTO search = new BitacoraCambiosTO();
    search.setName( "Sitio B" );
    search.setCode( "002" );
    request.setSearch( search );

    PagingResponseTO<BitacoraCambiosTO> response = siteService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindById()
  {
    BitacoraCambiosTO response = siteService.findById( 1L );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByCode()
  {
    BitacoraCambiosTO response = siteService.findByCode( "SITE001" );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testEdit()
  {
    String code = UUID.randomUUID().toString();
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    BitacoraCambiosTO response = siteService.findById( siteTO.getId() );
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
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    BitacoraCambiosTO response = siteService.findById( siteTO.getId() );
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
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    code = UUID.randomUUID().toString();
    BitacoraCambiosTO response = siteService.findById( siteTO.getId() );
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
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );

    siteService.save( siteTO );

    siteService.delete( siteTO );

  }

  @Test(expected = BusinessException.class)
  public void testDelete_withApplications()
  {
    BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setId( 1L );

    siteService.delete( siteTO );
  }

}
