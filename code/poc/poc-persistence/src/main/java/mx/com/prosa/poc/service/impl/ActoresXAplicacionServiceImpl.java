package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblActoresXAplicacion;
import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.persistence.TblActoresXAplicacionRepository;
import mx.com.prosa.poc.persistence.TblAplicacionesRepository;
import mx.com.prosa.poc.service.ActoresXAplicacionService;
import mx.com.prosa.poc.to.ActoresXAplicacionTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class ActoresXAplicacionServiceImpl.
 */
@Service
public class ActoresXAplicacionServiceImpl implements ActoresXAplicacionService {

	/** The tbl aplicaciones repository. */
	@Autowired
	TblAplicacionesRepository tblAplicacionesRepository;
	
	/** The tbl actor repository. */
	@Autowired
	private TblActorRepository tblActorRepository;
	
	/** The tbl actores X aplicacion repository. */
	@Autowired
	private TblActoresXAplicacionRepository tblActoresXAplicacionRepository;
	
	/**
	 * Save.
	 *
	 * @param actorApp the actor app
	 */
	@Override
	public void save(ActoresXAplicacionTO actorApp) {
		TblActoresXAplicacion entity = new TblActoresXAplicacion();
		TblActores actor = tblActorRepository.findById(actorApp.getFkIdActor())
				.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
		entity.setFkIdActor(actor.getPkIdActor());
		entity.setTblActores(actor);
		TblAplicaciones app = tblAplicacionesRepository.findById(actorApp.getFkIdAplicacion())
				.orElseThrow(SupplierBusinessException.APPLICATION_NOT_FOUND);
		entity.setFkIdAplicacion(app.getPkIdAplicacion());
		entity.setTblAplicaciones(app);
		tblActoresXAplicacionRepository.save(entity);
	}
	
}
