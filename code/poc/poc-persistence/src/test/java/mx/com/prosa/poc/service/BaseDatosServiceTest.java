package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.BaseDatosTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class BaseDatosServiceTest
{

  //private static final Logger LOG = LoggerFactory.getLogger( ApplicationServiceTest.class );

  @Autowired
  private BaseDatosService  baseDatosService; 

  @Test
  public void testSave()
  {
	  

	  BaseDatosTO baseDatos = new BaseDatosTO();
	    baseDatos.setPkIdBase(1L);
		baseDatos.setDsAlgoritmo("CF14");
		baseDatos.setDsCode("1");
		baseDatos.setDsEncripcion("SSH");
		baseDatos.setDsName("JUAN");
		baseDatos.setDsNombre("JUAN") ;
		baseDatos.setDsPci("1");
		baseDatos.setDsUserCreation("JUAN");
		baseDatos.setDsUserModification("JUAN");
		baseDatos.setFkIdResponsable(2L);
		baseDatos.setDtCreation("2020-05-20 19:01:46.593");
		baseDatos.setDtModified("2020-05-20 19:01:46.593");
	
	baseDatosService.save(baseDatos);
    Assert.assertNotNull( baseDatos );

  }


}
