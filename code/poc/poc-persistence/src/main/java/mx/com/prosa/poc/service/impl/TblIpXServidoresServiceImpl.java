package mx.com.prosa.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblIp;
import mx.com.prosa.poc.model.TblIpXServidores;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblIpRepository;
import mx.com.prosa.poc.persistence.TblIpXServidoresRepository;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.service.TblIpXServidoresService;
import mx.com.prosa.poc.to.IpXServidoresEdithTO;
import mx.com.prosa.poc.to.TblIpXServidoresTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class TblIpXServidoresServiceImpl.
 */
@Service
public class TblIpXServidoresServiceImpl implements TblIpXServidoresService {

	/** The tbl ip X servidores repository. */
	@Autowired
	private TblIpXServidoresRepository tblIpXServidoresRepository;
	
	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	/** The tbl ip repository. */
	@Autowired
	private TblIpRepository tblIpRepository;
	
	/**
	 * Save.
	 *
	 * @param object the object
	 */
	@Override
	public void save(TblIpXServidoresTO object) {
		TblIpXServidores entity = new TblIpXServidores();
		TblServidores server = tblServidoresRepository.findById(object.getFkIdServidor())
				.orElseThrow(SupplierBusinessException.SERVER_NOT_FOUND);
		entity.setTblServidores(server);
		entity.setFkIdServidor(server.getPkIdServidor());
		TblIp ip = tblIpRepository.findById(object.getFkIdIp())
				.orElseThrow(SupplierBusinessException.IP_NOT_FOUND);
		entity.setTblIp(ip);
		entity.setFkIdIp(ip.getPkIdIp());
		tblIpXServidoresRepository.save(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean delete(TblIpXServidoresTO object) {
		tblIpXServidoresRepository.delete(tblIpXServidoresRepository.
				findTable(object.getFkIdIp(),object.getFkIdServidor()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param object the object
	 * @return the boolean
	 */
	@Override
	public Boolean edit(IpXServidoresEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblIpXServidores entity = this.tblIpXServidoresRepository.
				findTable(object.getTable().getFkIdIp(),object.getTable().getFkIdServidor()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
	    
		Optional<TblIpXServidores> entityUpdated = this.tblIpXServidoresRepository.
				findTable(object.getUpdate().getFkIdIp(),object.getUpdate().getFkIdServidor());
		
		if(!entityUpdated.isPresent()) {
			TblIpXServidoresTO table = new TblIpXServidoresTO();
			table.setFkIdIp(entity.getFkIdIp());
			table.setFkIdServidor(entity.getFkIdServidor());
			this.delete(table);
			TblIpXServidores tableUpdated = new TblIpXServidores();
			tableUpdated.setFkIdIp(object.getUpdate().getFkIdIp());
			tableUpdated.setFkIdServidor(object.getUpdate().getFkIdServidor());
			this.tblIpXServidoresRepository.save( tableUpdated );
			this.tblIpXServidoresRepository.flush();
		}
		return true;
	}

}
