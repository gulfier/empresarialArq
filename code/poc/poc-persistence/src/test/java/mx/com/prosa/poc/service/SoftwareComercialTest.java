package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.SoftwareComercialTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class SoftwareComercialTest
{


  @Autowired
  private SoftwareComercialService  softwareComercialService;

  @Test
  public void testSave()
  {
	   
	  SoftwareComercialTO  entity = new SoftwareComercialTO();
		entity.setPkIdSoftware(1L);
		entity.setDsNombre("office");
		entity.setDsTipo("ofice");
		entity.setDsVersion("V1");
		
		
		entity.setFkIdMarca(2L);


	  
		softwareComercialService.save(entity);
    Assert.assertNotNull( entity );

  }


}
