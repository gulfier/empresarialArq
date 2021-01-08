package mx.com.prosa.poc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.model.TblAplicacionesXServidor;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.persistence.TblAplicacionesXServidorRepository;
import mx.com.prosa.poc.service.AplicacionesXServidorService;
import mx.com.prosa.poc.to.AplicacionesXServidorTO;

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
	
	
}
