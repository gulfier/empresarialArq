package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ComponentesRedTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class ComponenteRedServiceTest
{

  //private static final Logger LOG = LoggerFactory.getLogger( ApplicationServiceTest.class );

  @Autowired
  private ComponentesRedService  componentesRedService;

  @Test
  public void testSave()
  {
	  

	  ComponentesRedTO tblComponentesRed = new ComponentesRedTO();

		tblComponentesRed.setDsDescripcion("tpLink");
		tblComponentesRed.setDsNombre("tpLink");
		tblComponentesRed.setDsServicio("link");
		tblComponentesRed.setFkIdIp(1L);

		tblComponentesRed.setPkIdComponente(1L);
	
		componentesRedService.save(tblComponentesRed);
    Assert.assertNotNull( tblComponentesRed );

  }
  
	@Test
	public void testUpdate() {
		
		  ComponentesRedTO entity = new ComponentesRedTO();

			entity.setDsDescripcion("tpLink");
			entity.setDsNombre("tpLink");
			entity.setDsServicio("link");
			entity.setFkIdIp(1L);

			entity.setPkIdComponente(5L);
		
		entity.setId(5L);
		
		
		Boolean success =  componentesRedService.edit(entity);
		Assert.assertTrue(success);
	}
	
	
	@Test
	public void testDelete() {
		Boolean success = componentesRedService.delete(5L);
		Assert.assertTrue(success);
	}


}
