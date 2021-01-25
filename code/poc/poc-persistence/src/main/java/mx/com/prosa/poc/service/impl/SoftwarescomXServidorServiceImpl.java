package mx.com.prosa.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.model.TblSoftwareComercial;
import mx.com.prosa.poc.model.TblSoftwarescomXServidor;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.persistence.TblSoftwareComercialRepository;
import mx.com.prosa.poc.persistence.TblSoftwarescpmXServidorRepository;
import mx.com.prosa.poc.service.SoftwarescomXServidorService;
import mx.com.prosa.poc.to.SoftwarescomXServidorEdithTO;
import mx.com.prosa.poc.to.SoftwarescomXServidorTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class SoftwarescomXServidorServiceImpl.
 */
@Service
public class SoftwarescomXServidorServiceImpl implements SoftwarescomXServidorService {
	
	/** The softwarescpm X servidor repository. */
	@Autowired
	private TblSoftwarescpmXServidorRepository softwarescpmXServidorRepository;
	
	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	/** The tbl software comercial. */
	@Autowired
	private TblSoftwareComercialRepository tblSoftwareComercial;

	/**
	 * Save.
	 *
	 * @param object the object
	 */
	@Override
	public void save(SoftwarescomXServidorTO object) {
		TblSoftwarescomXServidor entity = new TblSoftwarescomXServidor();
		TblServidores server = tblServidoresRepository.findById(object.getFkIdServer())
				.orElseThrow(SupplierBusinessException.SERVER_NOT_FOUND);
		entity.setTblServidores(server);
		entity.setFkIdServer(server.getPkIdServidor());
		TblSoftwareComercial software = tblSoftwareComercial.findById(object.getFkIdSoftware())
				.orElseThrow(SupplierBusinessException.SOFTWARE_NOT_FOUND);
		entity.setTblSoftwareComercial(software);
		entity.setFkIdSoftware(software.getPkIdSoftware());
		softwarescpmXServidorRepository.save(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean delete(SoftwarescomXServidorTO object) {
		softwarescpmXServidorRepository.delete(softwarescpmXServidorRepository.
				findTable(object.getFkIdSoftware(),object.getFkIdServer()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean edit(SoftwarescomXServidorEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblSoftwarescomXServidor entity = this.softwarescpmXServidorRepository.
				findTable(object.getTable().getFkIdSoftware(),object.getTable().getFkIdServer()).orElseThrow(SupplierBusinessException
																												.TABLE_NOT_FOUND);
	    
		Optional<TblSoftwarescomXServidor> entityUpdated = this.softwarescpmXServidorRepository.
				findTable(object.getUpdate().getFkIdSoftware(),object.getUpdate().getFkIdServer());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdSoftware(object.getUpdate().getFkIdSoftware());
			entity.setFkIdServer(object.getUpdate().getFkIdServer());
			this.softwarescpmXServidorRepository.save( entity );
		    this.softwarescpmXServidorRepository.flush();
		}
		return true;
	}
	
}
