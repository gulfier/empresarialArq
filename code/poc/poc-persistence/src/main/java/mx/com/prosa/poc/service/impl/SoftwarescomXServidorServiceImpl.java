package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.model.TblSoftwareComercial;
import mx.com.prosa.poc.model.TblSoftwarescomXServidor;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.persistence.TblSoftwareComercialRepository;
import mx.com.prosa.poc.persistence.TblSoftwarescpmXServidorRepository;
import mx.com.prosa.poc.service.SoftwarescomXServidorService;
import mx.com.prosa.poc.to.SoftwarescomXServidorTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

@Service
public class SoftwarescomXServidorServiceImpl implements SoftwarescomXServidorService {
	@Autowired
	private TblSoftwarescpmXServidorRepository softwarescpmXServidorRepository;
	
	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	/** The tbl software comercial. */
	@Autowired
	private TblSoftwareComercialRepository tblSoftwareComercial;

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
	
	
}
