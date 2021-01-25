package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.UbicacionTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class UbicacionesServiceTest {

	@Autowired
	private UbicacionesService ubicacionesService;

	@Test
	public void testSave() {

		UbicacionTO entity = new UbicacionTO();

		entity.setPkIdUbicacion(1L);
		entity.setDsCiudad("Mexico");
		entity.setDsCode("1");
		entity.setDsDescripcion("Santa Fe");
		entity.setDsDireccion("Santa Fe");
		entity.setDsEstado("CD mexico");
		entity.setDsName("Santa Fe");
		entity.setDsNombre("Santa Fe");
		entity.setDsPais("Mexico");
		entity.setDsPci("1");
		entity.setDsTipo("1");
		entity.setDsUserCreation("Juan");
		entity.setDsUserModification("Juan");
		entity.setDtCreation("2020-05-20 19:01:46.593");
		entity.setDtModified("2020-05-20 19:01:46.593");
		entity.setFkIdResponsable(1L);

		ubicacionesService.save(entity);
		Assert.assertNotNull(entity);

	}
	
	@Test
	public void testUpdate() {

		UbicacionTO entity = new UbicacionTO();

		entity.setPkIdUbicacion(1L);
		entity.setDsCiudad("Mexico");
		entity.setDsCode("1");
		entity.setDsDescripcion("Santa Fe");
		entity.setDsDireccion("Santa Fe");
		entity.setDsEstado("CD mexico");
		entity.setDsName("Santa Fe");
		entity.setDsNombre("Santa Fe");
		entity.setDsPais("Mexico");
		entity.setDsPci("1");
		entity.setDsTipo("1");
		entity.setDsUserCreation("Juan");
		entity.setDsUserModification("Juan");
		entity.setDtCreation("2020-05-20 19:01:46.593");
		entity.setDtModified("2020-05-20 19:01:46.593");
		entity.setFkIdResponsable(1L);
		entity.setId(1L);

		Boolean success = ubicacionesService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		Boolean success = ubicacionesService.delete(1L);
		Assert.assertTrue(success);
	}
	
}
