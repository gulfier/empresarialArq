package mx.com.prosa.poc.service.impl;

import java.util.Optional;

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
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
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

	@Override
	public Boolean delete(ActoresXAplicacionTO request) {
		// TODO Auto-generated method stub
		tblActoresXAplicacionRepository.delete(tblActoresXAplicacionRepository.
				findTable(request.getFkIdActor(),request.getFkIdAplicacion()).orElseThrow(SupplierBusinessException.ACTORES_NOT_FOUND));
		return true;
	}
	
	@Override
	public Boolean edit(ActoresXaplicacionEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblActoresXAplicacion entity = this.tblActoresXAplicacionRepository.
				findTable(object.getTable().getFkIdActor(),object.getTable().getFkIdAplicacion()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
	    
		Optional<TblActoresXAplicacion> entityUpdated = this.tblActoresXAplicacionRepository.
				findTable(object.getUpdate().getFkIdActor(),object.getUpdate().getFkIdAplicacion());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdActor(object.getUpdate().getFkIdActor());
			entity.setFkIdAplicacion(object.getUpdate().getFkIdAplicacion());
			this.tblActoresXAplicacionRepository.save( entity );
		    this.tblActoresXAplicacionRepository.flush();
		}
		return true;
	}
	
}
