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
import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class ITServiceServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( ITServiceServiceTest.class );

  @Autowired
  private ITServiceService itServiceService;

  @Test
  public void testSave()
  {
    String code = UUID.randomUUID().toString();
    ITServiceTO to = new ITServiceTO();
    to.setUser( "user@example.com" );
    to.setName( "qwerty" );
    to.setCode( code );

    itServiceService.save( to );

    ITServiceTO response = itServiceService.findById( to.getId() );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_empty()
  {
    PagingResponseTO<ITServiceTO> response = itServiceService.findAll( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_page()
  {
    PagingRequestTO<ITServiceTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );

    PagingResponseTO<ITServiceTO> response = itServiceService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindAll_pageSort()
  {
    PagingRequestTO<ITServiceTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    request.setSortBy( "name" );
    request.setDirection( PagingRequestTO.Direction.ASC );

    PagingResponseTO<ITServiceTO> response = itServiceService.findAll( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_empty()
  {

    PagingResponseTO<ITServiceTO> response = itServiceService.findByExample( null );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_name()
  {

    PagingRequestTO<ITServiceTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    ITServiceTO search = new ITServiceTO();
    search.setName( "Sitio B" );
    request.setSearch( search );

    PagingResponseTO<ITServiceTO> response = itServiceService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByExample_nameAndCode()
  {

    PagingRequestTO<ITServiceTO> request = new PagingRequestTO<>();
    request.setPage( 0 );
    request.setSize( 5 );
    ITServiceTO search = new ITServiceTO();
    search.setName( "Sitio B" );
    search.setCode( "002" );
    request.setSearch( search );

    PagingResponseTO<ITServiceTO> response = itServiceService.findByExample( request );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindById()
  {
    ITServiceTO response = itServiceService.findById( 1L );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testFindByCode()
  {
    ITServiceTO response = itServiceService.findByCode( "ITS001" );
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testEdit()
  {
    String code = UUID.randomUUID().toString();
    ITServiceTO siteTO = new ITServiceTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );
    
    itServiceService.save( siteTO );
    
    code = UUID.randomUUID().toString();
    ITServiceTO response = itServiceService.findById(siteTO.getId() );
    Assert.assertNotNull( response );
    response.setUser( "user2@example.com" );
    response.setName( "qwerty2" );
    response.setCode( code );
    
    itServiceService.edit( response );
    
    response = itServiceService.findById(siteTO.getId() );
    
    Assert.assertNotNull( response );

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    LOG.info( gson.toJson( response ) );
  }

  @Test
  public void testDelete()
  {
    String code = UUID.randomUUID().toString();
    ITServiceTO siteTO = new ITServiceTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setName( "qwerty" );
    siteTO.setCode( code );
    
    itServiceService.save( siteTO );
    
    Long id = siteTO.getId();
    itServiceService.delete( siteTO );
    
    ITServiceTO response = itServiceService.findById(id );
    Assert.assertNull( response );
  }
  
  
  @Test(expected =  BusinessException.class)
  public void testDelete_withApplications()
  {
    ITServiceTO siteTO = new ITServiceTO();
    siteTO.setUser( "user@example.com" );
    siteTO.setId( 1L );
    
    itServiceService.delete( siteTO ); 
  }

}
