package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.AppXBaseDatosTO;
import mx.com.prosa.poc.to.BaseDatosTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class BaseDatosServiceTest
{

  //private static final Logger LOG = LoggerFactory.getLogger( ApplicationServiceTest.class );

  @Autowired
  private AppXBaseDatosService appXBaseDatosService;

  @Test
  public void testSave()
  {
	  
		
	  AppXBaseDatosTO baseDatos = new AppXBaseDatosTO();
	  baseDatos.setFkIdAplicacion(2L);
	  baseDatos.setFkIdBase(3L);
	
		appXBaseDatosService.save(baseDatos);
    Assert.assertNotNull( baseDatos );

  }


}
