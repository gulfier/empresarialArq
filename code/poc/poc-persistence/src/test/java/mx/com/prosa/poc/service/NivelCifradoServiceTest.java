package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.NivelCifradoTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class NivelCifradoServiceTest
{


  @Autowired
  private NivelCifradoService  nivelCifradoService; 

  @Test
  public void testSave()
  {
	  
	  
	  NivelCifradoTO nivelCifradoTO = new NivelCifradoTO();
	  nivelCifradoTO.setPkIdCifrado(1);
	  nivelCifradoTO.setDsNombre("HTTP");
	  

	  
	  nivelCifradoService.save(nivelCifradoTO);
    Assert.assertNotNull( nivelCifradoTO );

  }


}
