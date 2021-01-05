package mx.com.prosa.poc.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActore;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.UbicacionesService;
import mx.com.prosa.poc.to.UbicacionTO;
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
		entity.setDtCreation(toTimestamp(ubicacion.getDtCreation()));
		entity.setDtModified(toTimestamp(ubicacion.getDtModified()));
		
		TblActore actor = actoresRepository.findById(ubicacion.getFkIdResponsable())
				.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
		
		entity.setFkIdResponsable(actor);
		ubicacionesRepository.save(entity);
	}
	
	/**
	 * To timestamp.
	 *
	 * @param dateString the date string
	 * @return the timestamp
	 */
	private Timestamp toTimestamp(String dateString) {
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat(
                "MM-dd-yyyy HH:mm:ss");
		Date date = null;
		try {
			date = datetimeFormatter.parse(dateString);
			logger.info(date.toString());
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			logger.error("Error al parsear la fecha: "+dateString);
			return null;
		}
	}
	
}
