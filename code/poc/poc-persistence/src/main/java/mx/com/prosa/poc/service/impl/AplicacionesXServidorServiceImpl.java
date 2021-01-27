package mx.com.prosa.poc.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.model.TblAplicacionesXServidor;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblAplicacionesXServidorRepository;
import mx.com.prosa.poc.service.AplicacionesXServidorService;
import mx.com.prosa.poc.to.AplicacionesXServidorTO;
import mx.com.prosa.poc.to.AplicacionesXservidorEdithTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

@Service
public class AplicacionesXServidorServiceImpl implements AplicacionesXServidorService {

	/** The tbl servidores repository. */
	@Autowired
	private TblAplicacionesXServidorRepository  tblAplicacionesXServidorRepository;
	


	@Override
	public void save(AplicacionesXServidorTO object) {
		TblAplicacionesXServidor entity = new TblAplicacionesXServidor();

		TblAplicaciones tblAplicaciones= new TblAplicaciones();
		tblAplicaciones.setPkIdAplicacion(object.getFkIdAplicacion());
		
		TblServidores tblServidores = new TblServidores();
		tblServidores.setPkIdServidor(object.getFkIdServidor());
		
		entity.setFkIdAplicacion(object.getFkIdAplicacion());
		entity.setFkIdServidor(object.getFkIdServidor());
		entity.setTblAplicaciones(tblAplicaciones);
	    entity.setTblServidores(tblServidores);
		tblAplicacionesXServidorRepository.save(entity);
	}
	
	@Override
	public Boolean delete(AplicacionesXServidorTO request) {
		// TODO Auto-generated method stub
		tblAplicacionesXServidorRepository.delete(tblAplicacionesXServidorRepository.
				findTable(request.getFkIdAplicacion(),request.getFkIdServidor()).orElseThrow(SupplierBusinessException.APP_NOT_FOUND));
		return true;
	}
	
	@Override
	public Boolean edit(AplicacionesXservidorEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblAplicacionesXServidor entity = this.tblAplicacionesXServidorRepository.
				findTable(object.getTable().getFkIdAplicacion(),object.getTable().getFkIdServidor()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
	    
		Optional<TblAplicacionesXServidor> entityUpdated = this.tblAplicacionesXServidorRepository.
				findTable(object.getUpdate().getFkIdAplicacion(),object.getUpdate().getFkIdServidor());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdAplicacion(object.getUpdate().getFkIdAplicacion());
			entity.setFkIdServidor(object.getUpdate().getFkIdServidor());
			this.tblAplicacionesXServidorRepository.save( entity );
		    this.tblAplicacionesXServidorRepository.flush();
		}
		return true;
	}
	
}
