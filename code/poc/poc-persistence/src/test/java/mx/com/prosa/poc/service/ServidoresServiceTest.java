package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.ServidoresTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class ServidoresServiceTest {
	@Autowired
	private ServidoresService servidoresService;

	@Test
	public void testSave() {

		ServidoresTO entity = new ServidoresTO();
		entity.setPkIdServidor(3L);
		entity.setDsAmbiente("2");
		entity.setDsCode("Linux");
		entity.setDsDescripcion("Servidor produccion");
		entity.setDsHostName("www.prosa.com");
		entity.setDsMarcaModelo("IBM");
		entity.setDsName("PROSA");
		entity.setDsPci("1");
		entity.setDsProposito("QA");
		entity.setDsTipo("QA");
		entity.setDsUserCreation("Juan");
		entity.setDsUserModification("Juan");
		entity.setDsVirtualizacion("Linux");
		entity.setDtCreation("01-12-2021 12:20:13");
		entity.setDtModified("01-12-2021 12:20:13");
		entity.setFkIdResponsable(2L);
		entity.setFkIdUbicacion(1L);

		servidoresService.save(entity);
		Assert.assertNotNull(entity);

	}

	@Test
	public void testUpdate() {

		ServidoresTO entity = new ServidoresTO();
		entity.setPkIdServidor(3L);
		entity.setDsAmbiente("2");
		entity.setDsCode("Linux");
		entity.setDsDescripcion("Servidor produccion");
		entity.setDsHostName("www.prosa.com.mx");
		entity.setDsMarcaModelo("Oracle");
		entity.setDsName("PROSA MX");
		entity.setDsPci("1");
		entity.setDsProposito("QA");
		entity.setDsTipo("QA");
		entity.setDsUserCreation("Juan");
		entity.setDsUserModification("Juan");
		entity.setDsVirtualizacion("Linux");
		entity.setDtCreation("01-12-2021 12:20:13");
		entity.setDtModified("01-12-2021 12:20:13");
		entity.setFkIdResponsable(2L);
		entity.setFkIdUbicacion(1L);
		entity.setId(1L);

		Boolean success = servidoresService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		Boolean success = servidoresService.delete(3L);
		Assert.assertTrue(success);
	}
}
