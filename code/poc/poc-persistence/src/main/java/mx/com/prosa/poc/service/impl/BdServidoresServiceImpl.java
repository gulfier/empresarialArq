package mx.com.prosa.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActoresXAplicacion;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.model.TblBdServidores;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblBdServidoresRepository;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.service.BdServidoresService;
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;
import mx.com.prosa.poc.to.AppXBaseDatosTO;
import mx.com.prosa.poc.to.BdServidoresEditTO;
import mx.com.prosa.poc.to.BdServidoresTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class BdServidoresServiceImpl.
 */
@Service
public class BdServidoresServiceImpl implements BdServidoresService {
	
	/** The tbl bd servidores repository. */
	@Autowired
	private TblBdServidoresRepository tblBdServidoresRepository;
	
	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	/** The tbl base datos repository. */
	@Autowired
	private TblBaseDatosRepository tblBaseDatosRepository;

	/**
	 * Save.
	 *
	 * @param bdServer the bd server
	 */
	@Override
	public void save(BdServidoresTO bdServer) {
		TblBdServidores entity = new TblBdServidores();
		TblServidores server = tblServidoresRepository.findById(bdServer.getFkIdServidor())
				.orElseThrow(SupplierBusinessException.SERVER_NOT_FOUND);
		entity.setTblServidores(server);
		entity.setFkIdServidor(server.getPkIdServidor());
		TblBaseDatos dataBase = tblBaseDatosRepository.findById(bdServer.getFkIdBaseDatos())
				.orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND);
		entity.setFkIdBaseDatos(dataBase.getPkIdBase());
		entity.setTblBaseDatos(dataBase);
		tblBdServidoresRepository.save(entity);
	}
	
	
	/**
	 * delete
	 * Metodo para eliminar un registo.
	 * @param AppXBaseDatosTO
	 * */
	@Override
	public Boolean delete(BdServidoresTO request) {
		// TODO Auto-generated method stub
		tblBdServidoresRepository.delete(tblBdServidoresRepository.
				findTable(request.getFkIdServidor(),request.getFkIdBaseDatos()).orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND));
		return true;
	}
	
	
	@Override
	public Boolean edit(BdServidoresEditTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblBdServidores entity = this.tblBdServidoresRepository.
				findTable(object.getTable().getFkIdServidor(),object.getTable().getFkIdBaseDatos()).orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND);
	    
		Optional<TblBdServidores> entityUpdated = this.tblBdServidoresRepository.
				findTable(object.getUpdate().getFkIdServidor(),object.getUpdate().getFkIdBaseDatos());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdServidor(object.getUpdate().getFkIdServidor());
			entity.setFkIdBaseDatos(object.getUpdate().getFkIdBaseDatos());
			this.tblBdServidoresRepository.save( entity );
		    this.tblBdServidoresRepository.flush();
		}
		return true;
	}
	
}
