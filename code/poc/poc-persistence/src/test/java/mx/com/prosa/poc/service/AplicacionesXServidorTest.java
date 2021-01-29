package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AplicacionesXServidorTO;
import mx.com.prosa.poc.to.AplicacionesXservidorEdithTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class AplicacionesXServidorTest
{


  @Autowired
  private AplicacionesXServidorService aplicacionesXServidorService;

  @Test
  public void testFindAll_empty()
  {
	  
	  AplicacionesXServidorTO aplicacionesXServidorTO = new AplicacionesXServidorTO();
	  aplicacionesXServidorTO.setFkIdServidor(1L);
	  aplicacionesXServidorTO.setFkIdAplicacion(1L);
		
	aplicacionesXServidorService.save(aplicacionesXServidorTO);
    Assert.assertNotNull( aplicacionesXServidorTO );
    
  }
  
  
  
	@Test
	public void testUpdate() {

		AplicacionesXservidorEdithTO entity = new AplicacionesXservidorEdithTO();
		AplicacionesXServidorTO table = new AplicacionesXServidorTO();
		AplicacionesXServidorTO update = new AplicacionesXServidorTO();
		table.setFkIdAplicacion(5L);
		table.setFkIdServidor(3L);
		update.setFkIdAplicacion(5L);
		update.setFkIdServidor(3L);
		
		entity.setTable(table);
		entity.setUpdate(update);
		entity.setId(1L);

		Boolean success = aplicacionesXServidorService.edit(entity);
		Assert.assertTrue(success);

	}

	
	@Test
	public void testDelete() {
		AplicacionesXServidorTO entity = new AplicacionesXServidorTO();
		entity.setFkIdAplicacion(5L);
		entity.setFkIdServidor(3L);
		Boolean success = aplicacionesXServidorService.delete(entity);
		Assert.assertTrue(success);
	}

}
