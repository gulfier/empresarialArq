package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AplicacionTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class ApplicationServiceTest
{

  //private static final Logger LOG = LoggerFactory.getLogger( ApplicationServiceTest.class );

  @Autowired
  private AplicacionesService  AplicacionesService; 

  @Test
  public void testFindAll_empty()
  {
	  
	AplicacionTO aplicacionTO = new AplicacionTO();
	aplicacionTO.setPkIdAplicacion(1L);
	aplicacionTO.setDsClasificacion("medio");
	aplicacionTO.setDsCode("1");
	aplicacionTO.setDsComment("windows");
	aplicacionTO.setDsDescripcion("paqueeria");
	aplicacionTO.setDsName("windows");
	aplicacionTO.setDsNombre("windows");
	aplicacionTO.setDsNombreCorto("windows");
	aplicacionTO.setDsNombreLargo("microsft office");
	aplicacionTO.setDsPci("1");
	aplicacionTO.setDsUserCreation("Juan");
	aplicacionTO.setDsUserModification("JAN");
	aplicacionTO.setDtCreation("2020-05-20 19:01:46.593");
	aplicacionTO.setDtModified("2020-05-20 19:01:46.593");
	
	
    AplicacionesService.save(aplicacionTO);
    Assert.assertNotNull( aplicacionTO );

  }

	@Test
	public void testUpdate() {
		
		AplicacionTO entity = new AplicacionTO();
		entity.setPkIdAplicacion(6L);
		entity.setDsClasificacion("medio");
		entity.setDsCode("1");
		entity.setDsComment("windows");
		entity.setDsDescripcion("paqueeria");
		entity.setDsName("windows");
		entity.setDsNombre("windows");
		entity.setDsNombreCorto("windows");
		entity.setDsNombreLargo("microsft office");
		entity.setDsPci("1");
		entity.setDsUserCreation("Juan");
		entity.setDsUserModification("JAN");
		entity.setDtCreation("2020-05-20 19:01:46.593");
		entity.setDtModified("2020-05-20 19:01:46.593");
		
		entity.setId(6L);
		
		
		Boolean success =  AplicacionesService.edit(entity);
		Assert.assertTrue(success);
	}
	
	@Test
	public void testDelete() {
		Boolean success = AplicacionesService.delete(6L);
		Assert.assertTrue(success);
	}

}
