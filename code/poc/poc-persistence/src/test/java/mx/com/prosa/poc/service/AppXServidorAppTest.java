package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AppsXServAppTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class AppXServidorAppTest
{


  @Autowired
  private AppsXServAppService  appsXServAppService;

  @Test
  public void testSave()
  {
	  
	  
	  AppsXServAppTO entity = new AppsXServAppTO();
	  entity.setFkIdAplicacion(2L);
	  entity.setFkIdServicio(2L);
	  
 
	  appsXServAppService.save(entity);
    Assert.assertNotNull( entity );

  }


}
