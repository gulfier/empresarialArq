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

@Service
public class TblIpXServidoresServiceImpl implements TblIpXServidoresService {

	@Autowired
	private TblIpXServidoresRepository tblIpXServidoresRepository;
	
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	@Autowired
	private TblIpRepository tblIpRepository;
	
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
	
	@Override
	public Boolean delete(TblIpXServidoresTO object) {
		tblIpXServidoresRepository.delete(tblIpXServidoresRepository.
				findTable(object.getFkIdIp(),object.getFkIdServidor()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND));
		return true;
	}
	
	@Override
	public Boolean edit(IpXServidoresEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblIpXServidores entity = this.tblIpXServidoresRepository.
				findTable(object.getTable().getFkIdIp(),object.getTable().getFkIdServidor()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
	    
		Optional<TblIpXServidores> entityUpdated = this.tblIpXServidoresRepository.
				findTable(object.getUpdate().getFkIdIp(),object.getUpdate().getFkIdServidor());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdIp(object.getUpdate().getFkIdIp());
			entity.setFkIdServidor(object.getUpdate().getFkIdServidor());
			this.tblIpXServidoresRepository.save( entity );
		    this.tblIpXServidoresRepository.flush();
		}
		return true;
	}

}
