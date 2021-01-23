package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblSegmentos;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblSegmentosRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.SegmentosService;
import mx.com.prosa.poc.to.SegmentosTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
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

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblSegmentosRepository.delete(tblSegmentosRepository.
				findById(id).orElseThrow(SupplierBusinessException.RED_PART_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean edit(SegmentosTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblSegmentos entity = this.tblSegmentosRepository.findById( object.getId() )
	        .orElseThrow( SupplierBusinessException.RED_PART_NOT_FOUND );
	    entity.setDsDescrpcion(object.getDsDescrpcion());
		entity.setDsNombre(object.getDsNombre());
		entity.setDsPci(object.getDsPci());
		entity.setDsRangoIpInicia(object.getDsRangoIpInicia());
		entity.setDsRangoIpTermina(object.getDsRangoIpTermina());
		entity.setDsTipo(object.getDsTipo());
		if(object.getFkIdUbicacion()!=null) {
			TblUbicaciones ubicacion = ubicacionesRepository.findById(object.getFkIdUbicacion())
					.orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND);
			entity.setFkIdUbicacion(ubicacion);
		}
	    this.tblSegmentosRepository.save( entity );
	    this.tblSegmentosRepository.flush();
		return true;
	}
	
}
