package mx.com.prosa.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.to.SegmentosTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class SegmentosServiceTest {

	@Autowired
	private SegmentosService segmentosService;

	@Test
	public void testSave() {

		SegmentosTO entity = new SegmentosTO();

		entity.setPkIdSegmento(1L);
		entity.setDsDescrpcion("Santa Fe");
		entity.setDsNombre("Santa Fe");
		entity.setDsPci("1");
		entity.setDsRangoIpInicia("10");
		entity.setDsRangoIpTermina("20");
		entity.setDsTipo("santa fe");
		entity.setFkIdUbicacion(1L);

		segmentosService.save(entity);
		Assert.assertNotNull(entity);

	}

	@Test
	public void testUpdate() {

		SegmentosTO entity = new SegmentosTO();

		entity.setPkIdSegmento(1L);
		entity.setDsDescrpcion("Santa Fe");
		entity.setDsNombre("SF");
		entity.setDsPci("1");
		entity.setDsRangoIpInicia("10");
		entity.setDsRangoIpTermina("20");
		entity.setDsTipo("santa fe");
		entity.setFkIdUbicacion(1L);
		entity.setId(1L);

		Boolean success = segmentosService.edit(entity);
		Assert.assertTrue(success);

	}

	@Test
	public void testDelete() {
		Boolean success = segmentosService.delete(1L);
		Assert.assertTrue(success);
	}

}
