package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.TablasTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class TablasServiceTest
{


  @Autowired
  private TablasService tablasService;

  @Test
  public void testSave()
  {
	  TablasTO entity = new TablasTO();
		entity.setDsTabla("Auditoria");
		entity.setFkIdBase(3L);
		entity.setPkIdTabla(1L);
	  
 
	  tablasService.save(entity);
    Assert.assertNotNull( entity );

  }

  @Test
	public void testUpdate() {

	  TablasTO entity = new TablasTO();
		entity.setDsTabla("Auditoria 3");
		entity.setFkIdBase(3L);
		entity.setPkIdTabla(2L);
		entity.setId(2L);

		Boolean success = tablasService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		Boolean success = tablasService.delete(2L);
		Assert.assertTrue(success);
	}

}
