package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AplicacionesXServidorTO;

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


}
