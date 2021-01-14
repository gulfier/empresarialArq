package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblIp;
import mx.com.prosa.poc.model.TblIpXServidores;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblIpRepository;
import mx.com.prosa.poc.persistence.TblIpXServidoresRepository;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.service.TblIpXServidoresService;
import mx.com.prosa.poc.to.TblIpXServidoresTO;
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

}
