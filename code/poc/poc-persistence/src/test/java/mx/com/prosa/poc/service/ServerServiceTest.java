package mx.com.prosa.poc.service;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
@Ignore
public class ServerServiceTest
{
//  private static final Logger LOG = LoggerFactory.getLogger( ServerServiceTest.class );
//
//  @Autowired
//  private ServerService serverService;
//
//  @Test
//  public void testSave()
//  {
//    String code = UUID.randomUUID().toString();
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setName( "qwerty" );
//    serverTO.setCode( code );
//
//    serverService.save( serverTO );
//
//    ServerTO response = serverService.findById( serverTO.getId() );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//
//  }
//
//  @Test
//  public void testFindAll_empty()
//  {
//    PagingResponseTO<ServerTO> response = serverService.findAll( null );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindAll_page()
//  {
//    PagingRequestTO<ServerTO> request = new PagingRequestTO<>();
//    request.setPage( 0 );
//    request.setSize( 5 );
//
//    PagingResponseTO<ServerTO> response = serverService.findAll( request );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindAll_pageSort()
//  {
//    PagingRequestTO<ServerTO> request = new PagingRequestTO<>();
//    request.setPage( 0 );
//    request.setSize( 5 );
//    request.setSortBy( "name" );
//    request.setDirection( PagingRequestTO.Direction.ASC );
//
//    PagingResponseTO<ServerTO> response = serverService.findAll( request );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindByExample_empty()
//  {
//
//    PagingResponseTO<ServerTO> response = serverService.findByExample( null );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindByExample_name()
//  {
//
//    PagingRequestTO<ServerTO> request = new PagingRequestTO<>();
//    request.setPage( 0 );
//    request.setSize( 5 );
//    ServerTO search = new ServerTO();
//    search.setName( "Sitio B" );
//    request.setSearch( search );
//
//    PagingResponseTO<ServerTO> response = serverService.findByExample( request );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindByExample_nameAndCode()
//  {
//
//    PagingRequestTO<ServerTO> request = new PagingRequestTO<>();
//    request.setPage( 0 );
//    request.setSize( 5 );
//    ServerTO search = new ServerTO();
//    search.setName( "Sitio B" );
//    search.setCode( "002" );
//    request.setSearch( search );
//
//    PagingResponseTO<ServerTO> response = serverService.findByExample( request );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindById()
//  {
//    ServerTO response = serverService.findById( 1L );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testFindByCode()
//  {
//    ServerTO response = serverService.findByCode( "SERV001" );
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testEdit()
//  {
//    String code = UUID.randomUUID().toString();
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setName( "qwerty" );
//    serverTO.setCode( code );
//
//    serverService.save( serverTO );
//
//    code = UUID.randomUUID().toString();
//    ServerTO response = serverService.findById( serverTO.getId() );
//    Assert.assertNotNull( response );
//    response.setUser( "user2@example.com" );
//    response.setName( "qwerty2" );
//    response.setCode( code );
//
//    serverService.edit( response, false );
//
//    response = serverService.findById( serverTO.getId() );
//
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testEdit_patchCode()
//  {
//    String code = UUID.randomUUID().toString();
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setName( "qwerty" );
//    serverTO.setCode( code );
//
//    serverService.save( serverTO );
//
//    code = UUID.randomUUID().toString();
//    ServerTO response = serverService.findById( serverTO.getId() );
//    Assert.assertNotNull( response );
//    response.setUser( "user2@example.com" );
//    response.setCode( code );
//
//    serverService.edit( response, true );
//
//    response = serverService.findById( serverTO.getId() );
//
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testEdit_patchName()
//  {
//    String code = UUID.randomUUID().toString();
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setName( "qwerty" );
//    serverTO.setCode( code );
//
//    serverService.save( serverTO );
//
//    code = UUID.randomUUID().toString();
//    ServerTO response = serverService.findById( serverTO.getId() );
//    Assert.assertNotNull( response );
//    response.setUser( "user2@example.com" );
//    response.setName( "qwerty2" );
//
//    serverService.edit( response, true );
//
//    response = serverService.findById( serverTO.getId() );
//
//    Assert.assertNotNull( response );
//
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    LOG.info( gson.toJson( response ) );
//  }
//
//  @Test
//  public void testDelete()
//  {
//    String code = UUID.randomUUID().toString();
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setName( "qwerty" );
//    serverTO.setCode( code );
//
//    serverService.save( serverTO );
//
//    serverService.delete( serverTO );
//
//  }
//
//  @Test(expected = BusinessException.class)
//  public void testDelete_withApplications()
//  {
//    ServerTO serverTO = new ServerTO();
//    serverTO.setUser( "user@example.com" );
//    serverTO.setId( 1L );
//
//    serverService.delete( serverTO );
//  }

}
