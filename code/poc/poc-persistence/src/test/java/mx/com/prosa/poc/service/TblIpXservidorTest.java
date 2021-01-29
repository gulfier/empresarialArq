package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.IpXServidoresEdithTO;
import mx.com.prosa.poc.to.TblIpXServidoresTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class TblIpXservidorTest {

	@Autowired
	private TblIpXServidoresService tblIpXServidoresService;

	@Test
	public void testSave() {

		TblIpXServidoresTO entity = new TblIpXServidoresTO();
		entity.setFkIdIp(1L);
		entity.setFkIdServidor(3L);

		tblIpXServidoresService.save(entity);
		Assert.assertNotNull(entity);

	}

	@Test
	public void testUpdate() {

		IpXServidoresEdithTO entity = new IpXServidoresEdithTO();
		TblIpXServidoresTO table = new TblIpXServidoresTO();
		TblIpXServidoresTO update = new TblIpXServidoresTO();
		table.setFkIdIp(1L);
		table.setFkIdServidor(3L);
		update.setFkIdIp(1L);
		update.setFkIdServidor(4L);
		
		entity.setTable(table);
		entity.setUpdate(update);
		entity.setId(2L);

		Boolean success = tblIpXServidoresService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		TblIpXServidoresTO entity = new TblIpXServidoresTO();
		entity.setFkIdIp(1L);
		entity.setFkIdServidor(3L);
		Boolean success = tblIpXServidoresService.delete(entity);
		Assert.assertTrue(success);
	}

}
