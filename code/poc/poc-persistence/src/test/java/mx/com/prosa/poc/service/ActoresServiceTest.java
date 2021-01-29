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
    
  }
  
	@Test
	public void testUpdate() {
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
		
		entity.setId(1L);
		
		
		Boolean success =  actoresService.edit(entity);
		Assert.assertTrue(success);
	}
	
	@Test
	public void testDelete() {
		Boolean success = actoresService.delete(1L);
		Assert.assertTrue(success);
	}

}
