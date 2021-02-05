package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ActoresXAplicacionTO;
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class ActoresXaplicacionesTest
{


  @Autowired
  private ActoresXAplicacionService actoresXAplicacionService ;

  @Test
  public void testSave()
  {
	  
	   
	  ActoresXAplicacionTO entity = new ActoresXAplicacionTO();
	  entity.setFkIdActor(1L);
	  entity.setFkIdAplicacion(2L);
	  
 
	  actoresXAplicacionService.save(entity);
    Assert.assertNotNull( entity );

  }
  
	@Test
	public void testUpdate() {

		ActoresXaplicacionEdithTO entity = new ActoresXaplicacionEdithTO();
		ActoresXAplicacionTO table = new ActoresXAplicacionTO();
		ActoresXAplicacionTO update = new ActoresXAplicacionTO();
		table.setFkIdActor(1L);
		table.setFkIdAplicacion(2L);
		update.setFkIdActor(1L);
		update.setFkIdAplicacion(2L);
		
		entity.setTable(table);
		entity.setUpdate(update);
		entity.setId(1L);

		Boolean success = actoresXAplicacionService.edit(entity);
		Assert.assertTrue(success);

	}
	
	@Test
	public void testDelete() {
		ActoresXAplicacionTO entity = new ActoresXAplicacionTO();
		entity.setFkIdActor(1L);
		entity.setFkIdAplicacion(2L);
		Boolean success = actoresXAplicacionService.delete(entity);
		Assert.assertTrue(success);
	}


}
