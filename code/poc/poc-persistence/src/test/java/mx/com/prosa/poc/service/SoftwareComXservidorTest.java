package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.SoftwarescomXServidorTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class SoftwareComXservidorTest
{


  @Autowired
  private SoftwarescomXServidorService softwarescomXServidorService;

  @Test
  public void testSave()
  {
	   
	  SoftwarescomXServidorTO entity = new SoftwarescomXServidorTO();
	  entity.setFkIdServer(3L);
	  entity.setFkIdSoftware(3L);
	  
 
		softwarescomXServidorService.save(entity);
    Assert.assertNotNull( entity );

  }


}
