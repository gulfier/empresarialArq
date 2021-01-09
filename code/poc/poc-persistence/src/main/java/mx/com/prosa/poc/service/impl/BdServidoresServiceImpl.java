package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.model.TblBdServidores;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblBdServidoresRepository;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.service.BdServidoresService;
import mx.com.prosa.poc.to.BdServidoresTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

@Service
public class BdServidoresServiceImpl implements BdServidoresService {
	
	@Autowired
	private TblBdServidoresRepository tblBdServidoresRepository;
	
	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	@Autowired
	private TblBaseDatosRepository tblBaseDatosRepository;

	@Override
	public void save(BdServidoresTO bdServer) {
		TblBdServidores entity = new TblBdServidores();
		TblServidores server = tblServidoresRepository.findById(bdServer.getFkIdServidor())
				.orElseThrow(SupplierBusinessException.SERVER_NOT_FOUND);
		entity.setTblServidores(server);
		entity.setFkIdServidor(server.getPkIdServidor());
		TblBaseDatos dataBase = tblBaseDatosRepository.findById(bdServer.getFkIdServidor())
				.orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND);
		entity.setFkIdBaseDatos(dataBase.getPkIdBase());
		entity.setTblBaseDatos(dataBase);
		tblBdServidoresRepository.save(entity);
	}
	
}
