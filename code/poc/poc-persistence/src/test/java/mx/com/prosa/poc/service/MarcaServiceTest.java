package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.MarcasTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class MarcaServiceTest
{


  @Autowired
  private MarcasService marcasService;

  @Test
  public void testSave()
  {
	  

	  MarcasTO  marcasTO =new  MarcasTO();
	  marcasTO.setPkIdMarca(1);
	  marcasTO.setDsNombre("Microsoft");
	  marcasTO.setDsDescripcion("Microsoft");
	  

	  
	  marcasService.save(marcasTO);
    Assert.assertNotNull( marcasTO );

  }


}
