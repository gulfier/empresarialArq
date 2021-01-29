package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.SoftwarescomXServidorEdithTO;
import mx.com.prosa.poc.to.SoftwarescomXServidorTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class SoftwareComXservidorTest {

	@Autowired
	private SoftwarescomXServidorService softwarescomXServidorService;

	@Test
	public void testSave() {

		SoftwarescomXServidorTO entity = new SoftwarescomXServidorTO();
		entity.setFkIdServer(3L);
		entity.setFkIdSoftware(3L);

		softwarescomXServidorService.save(entity);
		Assert.assertNotNull(entity);

	}
	
	@Test
	public void testUpdate() {

		SoftwarescomXServidorEdithTO entity = new SoftwarescomXServidorEdithTO();
		SoftwarescomXServidorTO table = new SoftwarescomXServidorTO();
		SoftwarescomXServidorTO update = new SoftwarescomXServidorTO();
		table.setFkIdServer(3L);
		table.setFkIdSoftware(3L);
		update.setFkIdServer(4L);
		update.setFkIdSoftware(3L);
		
		entity.setTable(table);
		entity.setUpdate(update);
		entity.setId(2L);

		Boolean success = softwarescomXServidorService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		SoftwarescomXServidorTO entity = new SoftwarescomXServidorTO();
		entity.setFkIdServer(3L);
		entity.setFkIdSoftware(3L);
		Boolean success = softwarescomXServidorService.delete(entity);
		Assert.assertTrue(success);
	}

}
