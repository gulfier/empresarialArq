package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ActoresTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class ActoresServiceTest
{


  @Autowired
  private ActoresService actoresService;

  @Test
  public void testFindAll_empty()
  {
	  
	  ActoresTO entity = new ActoresTO();
		entity.setPkIdActor(1);
		entity.setDsCode("1");
		entity.setDsDescripcion("1");
		entity.setDsName("JUAN");
		entity.setDsNombre("JUAN");
		entity.setDsPci("1");
		entity.setDsUserCreation("JUan");
		entity.setDsUserModification("JUan");
		entity.setDtCreation("2020-05-20 19:01:46.593");
		entity.setDtModified("2020-05-20 19:01:46.593");
	  
	  
	
		
	actoresService.save(entity);
    Assert.assertNotNull( entity );
    
    /**
     * 		TblActores entity = new TblActores();
		entity.setPkIdActor(actor.getPkIdActor());
		entity.setDsCode(actor.getDsCode());
		entity.setDsDescripcion(actor.getDsDescripcion());
		entity.setDsName(actor.getDsName());
		entity.setDsNombre(actor.getDsNombre());
		entity.setDsPci(actor.getDsPci());
		entity.setDsUserCreation(actor.getDsUserCreation());
		entity.setDsUserModification(actor.getDsUserModification());
		entity.setDtCreation(CommonsUtil.toTimestamp(actor.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(actor.getDtModified()));
     * */

  }


}
