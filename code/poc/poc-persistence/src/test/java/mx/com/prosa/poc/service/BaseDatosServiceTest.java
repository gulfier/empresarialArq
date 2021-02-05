package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AppXBaseDatosEdithTO;
import mx.com.prosa.poc.to.AppXBaseDatosTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class BaseDatosServiceTest
{


  @Autowired
  private AppXBaseDatosService appXBaseDatosService;

  @Test
  public void testSave()
  {
	  
		
	  AppXBaseDatosTO baseDatos = new AppXBaseDatosTO();
	  baseDatos.setFkIdAplicacion(2L);
	  baseDatos.setFkIdBase(3L);
	
		appXBaseDatosService.save(baseDatos);
    Assert.assertNotNull( baseDatos );

  }
  
  
	@Test
	public void testUpdate() {

		AppXBaseDatosEdithTO entity = new AppXBaseDatosEdithTO();
		AppXBaseDatosTO table = new AppXBaseDatosTO();
		AppXBaseDatosTO update = new AppXBaseDatosTO();
		table.setFkIdAplicacion(8L);
		table.setFkIdBase(8L);
		update.setFkIdAplicacion(8L);
		update.setFkIdBase(8L);
		
		entity.setTable(table);
		entity.setUpdate(update);
		entity.setId(7L);

		Boolean success = appXBaseDatosService.edit(entity);
		Assert.assertTrue(success);

	}
	
	
	@Test
	public void testDelete() {
		AppXBaseDatosTO entity = new AppXBaseDatosTO();
		entity.setFkIdAplicacion(8L);
		entity.setFkIdBase(8L);
		Boolean success = appXBaseDatosService.delete(entity);
		Assert.assertTrue(success);
	}


}
