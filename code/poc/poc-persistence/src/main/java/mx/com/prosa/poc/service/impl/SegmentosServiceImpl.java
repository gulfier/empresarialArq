package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblSegmentos;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblSegmentosRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.SegmentosService;
import mx.com.prosa.poc.to.SegmentosTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class SegmentosServiceImpl.
 */
@Service
public class SegmentosServiceImpl implements SegmentosService {

	/** The tbl segmentos repository. */
	@Autowired
	private TblSegmentosRepository tblSegmentosRepository;
	
	/** The ubicaciones repository. */
	@Autowired
	private TblUbicacionesRepository ubicacionesRepository;
	
	/**
	 * Save.
	 *
	 * @param segmento the segmento
	 */
	@Override
	public void save(SegmentosTO segmento) {
		TblSegmentos entity = new TblSegmentos();
		entity.setPkIdSegmento(segmento.getPkIdSegmento());
		entity.setDsDescrpcion(segmento.getDsDescrpcion());
		entity.setDsNombre(segmento.getDsNombre());
		entity.setDsPci(segmento.getDsPci());
		entity.setDsRangoIpInicia(segmento.getDsRangoIpInicia());
		entity.setDsRangoIpTermina(segmento.getDsRangoIpTermina());
		entity.setDsTipo(segmento.getDsTipo());
		TblUbicaciones ubicacion = ubicacionesRepository.findById(segmento.getFkIdUbicacion())
				.orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND);
		entity.setFkIdUbicacion(ubicacion);
		tblSegmentosRepository.save(entity);
	}

}
