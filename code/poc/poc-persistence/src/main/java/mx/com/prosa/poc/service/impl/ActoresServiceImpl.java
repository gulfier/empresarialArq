package mx.com.prosa.poc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.service.ActoresService;
import mx.com.prosa.poc.to.ActoresTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.CommonsUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class ActoresServiceImpl.
 */
@Service
public class ActoresServiceImpl implements ActoresService {
	
	/** The tbl actor repository. */
	@Autowired
	private TblActorRepository tblActorRepository;

	/**
	 * Save.
	 *
	 * @param actor the actor
	 */
	@Override
	public void save(ActoresTO actor) {
		TblActores entity = new TblActores();
		entity.setPkIdActor(actor.getPkIdActor());
		entity.setDsCode(actor.getDsCode());
		entity.setDsDescripcion(actor.getDsDescripcion());
		entity.setDsName(actor.getDsName());
		entity.setDsNombre(actor.getDsNombre());
		entity.setDsPci(actor.getDsPci());
		entity.setDsUserCreation(actor.getDsUserCreation());
		entity.setDsUserModification(actor.getDsUserModification());
		entity.setDtCreation(CommonsUtil.toTimestamp(actor.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(actor.getDtModified()));
		
		tblActorRepository.save(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblActorRepository.delete(tblActorRepository.
				findById(id).orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND));
		return true;
	}
	
	
	/**
	 * Edits the.
	 *
	 * @param actores the table
	 * @return the boolean
	 */
	@Override
	public Boolean edit(ActoresTO actor) {
		BaseTOValidationUtil.validateIdNotNull( actor );
		TblActores entity = this.tblActorRepository.findById( actor.getPkIdActor() )
	        .orElseThrow( SupplierBusinessException.ACTORES_NOT_FOUND );
		entity.setDsCode(actor.getDsCode());
		entity.setDsDescripcion(actor.getDsDescripcion());
		entity.setDsName(actor.getDsName());
		entity.setDsNombre(actor.getDsNombre());
		entity.setDsPci(actor.getDsPci());
		entity.setDsUserCreation(actor.getDsUserCreation());
		entity.setDsUserModification(actor.getDsUserModification());
		entity.setDtCreation(CommonsUtil.toTimestamp(actor.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(actor.getDtModified()));
	    
	    this.tblActorRepository.save( entity );
	    this.tblActorRepository.flush();
		return true;
	}
	

}
