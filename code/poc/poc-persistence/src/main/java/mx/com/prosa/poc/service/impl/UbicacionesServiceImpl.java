package mx.com.prosa.poc.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.UbicacionesService;
import mx.com.prosa.poc.to.UbicacionTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.CommonsUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * The Class UbicacionesServiceImpl.
 */
@Service
public class UbicacionesServiceImpl implements UbicacionesService {

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
	public void save(UbicacionTO location) {
		TblUbicaciones entity = new TblUbicaciones();
		entity.setPkIdUbicacion(location.getPkIdUbicacion());
		entity.setDsCiudad(location.getDsCiudad());
		entity.setDsCode(location.getDsCode());
		entity.setDsDescripcion(location.getDsDescripcion());
		entity.setDsDireccion(location.getDsDireccion());
		entity.setDsEstado(location.getDsEstado());
		entity.setDsName(location.getDsName());
		entity.setDsNombre(location.getDsNombre());
		entity.setDsPais(location.getDsPais());
		entity.setDsPci(location.getDsPci());
		entity.setDsTipo(location.getDsTipo());
		entity.setDsUserCreation(location.getDsUserCreation());
		entity.setDsUserModification(location.getDsUserModification());
		entity.setDtCreation(CommonsUtil.toTimestamp(location.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(location.getDtModified()));
		TblActores actor = actoresRepository.findById(location.getFkIdResponsable())
				.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
		
		entity.setFkIdResponsable(actor);
		ubicacionesRepository.save(entity);
	}

	/**
	 * Delete.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		ubicacionesRepository.delete(ubicacionesRepository.
				findById(id).orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	@Override
	public Boolean edit(UbicacionTO location) {
		BaseTOValidationUtil.validateIdNotNull( location );
	    TblUbicaciones entity = this.ubicacionesRepository.findById( location.getPkIdUbicacion() )
	        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );
	    entity.setDsCiudad(location.getDsCiudad());
		entity.setDsCode(location.getDsCode());
		entity.setDsDescripcion(location.getDsDescripcion());
		entity.setDsDireccion(location.getDsDireccion());
		entity.setDsEstado(location.getDsEstado());
		entity.setDsName(location.getDsName());
		entity.setDsNombre(location.getDsNombre());
		entity.setDsPais(location.getDsPais());
		entity.setDsPci(location.getDsPci());
		entity.setDsTipo(location.getDsTipo());
		entity.setDsUserModification(location.getDsUserModification());
	    entity.setDtModified( Timestamp.valueOf(LocalDateTime.now()) );

	    this.ubicacionesRepository.save( entity );
	    this.ubicacionesRepository.flush();
		return true;
	}
	
	
	
}
