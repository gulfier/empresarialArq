package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ProtocoloTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class ProtocoloServiceTest {

	@Autowired
	private ProtocolosService protocolosService;

	@Test
	public void testSave() {

		ProtocoloTO protocoloTO = new ProtocoloTO();

		protocoloTO.setPkIdProtocolo(1);
		protocoloTO.setDsNombre("HTPS");
		protocoloTO.setDsVersion("V1");
		protocoloTO.setFkIdCifrado(2L);

		protocolosService.save(protocoloTO);
		Assert.assertNotNull(protocoloTO);

	}
	
	@Test
	public void testUpdate() {

		ProtocoloTO protocoloTO = new ProtocoloTO();

		protocoloTO.setPkIdProtocolo(3L);
		protocoloTO.setDsNombre("HTPS");
		protocoloTO.setDsVersion("V1");
		protocoloTO.setFkIdCifrado(2L);
		protocoloTO.setId(1L);

		Boolean success = protocolosService.edit(protocoloTO);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		Boolean success = protocolosService.delete(3L);
		Assert.assertTrue(success);
	}
}
