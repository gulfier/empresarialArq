package mx.com.prosa.poc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.UbicacionesService;
import mx.com.prosa.poc.to.UbicacionTO;
import mx.com.prosa.poc.util.CommonsUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class UbicacionesServiceImpl.
 */
@Service
public class UbicacionesServiceImpl implements UbicacionesService {
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The ubicaciones repository. */
	@Autowired
	private TblUbicacionesRepository ubicacionesRepository;
	
	/** The actores repository. */
	@Autowired
	private TblActorRepository actoresRepository;
	
	/**
	 * Save.
	 *
	 * @param ubicacion the ubicacion
	 */
	@Override
	public void save(UbicacionTO ubicacion) {
		TblUbicaciones entity = new TblUbicaciones();
		entity.setPkIdUbicacion(ubicacion.getPkIdUbicacion());
		entity.setDsCiudad(ubicacion.getDsCiudad());
		entity.setDsCode(ubicacion.getDsCode());
		entity.setDsDescripcion(ubicacion.getDsDescripcion());
		entity.setDsDireccion(ubicacion.getDsDireccion());
		entity.setDsEstado(ubicacion.getDsEstado());
		entity.setDsName(ubicacion.getDsName());
		entity.setDsNombre(ubicacion.getDsNombre());
		entity.setDsPais(ubicacion.getDsPais());
		entity.setDsPci(ubicacion.getDsPci());
		entity.setDsTipo(ubicacion.getDsTipo());
		entity.setDsUserCreation(ubicacion.getDsUserCreation());
		entity.setDsUserModification(ubicacion.getDsUserModification());
		entity.setDtCreation(CommonsUtil.toTimestamp(ubicacion.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(ubicacion.getDtModified()));
		TblActores actor = actoresRepository.findById(ubicacion.getFkIdResponsable())
				.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
		
		entity.setFkIdResponsable(actor);
		ubicacionesRepository.save(entity);
	}
	
	
	
}
