package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ActoresXAplicacionTO;

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


}
