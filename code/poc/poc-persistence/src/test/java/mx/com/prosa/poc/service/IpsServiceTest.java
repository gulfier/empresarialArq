package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.IpTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class IpsServiceTest
{


  @Autowired
  private IpsService IpsService; 

  @Test
  public void testSave()
  {
	  

	  IpTO tblIp = new IpTO();

	  tblIp.setPkIdIp(2L);
	  tblIp.setDsIp("10.0.3.4");
	  tblIp.setDsTipo("Prod");
	  
	  tblIp.setFkIdSegmento(1L);
	  
		IpsService.save(tblIp);
    Assert.assertNotNull( tblIp );

  }


}
