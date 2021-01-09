package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.model.TblAppXBaseDatos;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.persistence.TblAplicacionesRepository;
import mx.com.prosa.poc.persistence.TblAppXBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.service.AppXBaseDatosService;
import mx.com.prosa.poc.to.AppXBaseDatosTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

public class AppXBaseDatosServiceImpl implements AppXBaseDatosService {

	@Autowired
	private TblAppXBaseDatosRepository tblAppXBaseDatosRepository;
	
	@Autowired
	private TblBaseDatosRepository tblBaseDatosRepository;
	
	@Autowired
	private TblAplicacionesRepository tblAplicacionesRepository;
	
	@Override
	public void save(AppXBaseDatosTO appDataBase) {
		TblAppXBaseDatos entity = new TblAppXBaseDatos();
		TblBaseDatos dataBase = tblBaseDatosRepository.findById(appDataBase.getFkIdBase())
				.orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND);
		entity.setFkIdBase(dataBase.getPkIdBase());
		entity.setTblBaseDatos(dataBase);
		TblAplicaciones app = tblAplicacionesRepository.findById(appDataBase.getFkIdAplicacion())
				.orElseThrow(SupplierBusinessException.APP_NOT_FOUND);
		entity.setFkIdAplicacion(app.getPkIdAplicacion());
		entity.setTblAplicaciones(app);
		
		tblAppXBaseDatosRepository.save(entity);
	}

}
