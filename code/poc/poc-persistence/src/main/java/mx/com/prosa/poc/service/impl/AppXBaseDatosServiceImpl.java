package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.model.TblAppXBaseDatos;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.persistence.TblAplicacionesRepository;
import mx.com.prosa.poc.persistence.TblAppXBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.service.AppXBaseDatosService;
import mx.com.prosa.poc.to.AppXBaseDatosTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class AppXBaseDatosServiceImpl.
 */
@Service
public class AppXBaseDatosServiceImpl implements AppXBaseDatosService {

	/** The tbl app X base datos repository. */
	@Autowired
	private TblAppXBaseDatosRepository tblAppXBaseDatosRepository;
	
	/** The tbl base datos repository. */
	@Autowired
	private TblBaseDatosRepository tblBaseDatosRepository;
	
	/** The tbl aplicaciones repository. */
	@Autowired
	private TblAplicacionesRepository tblAplicacionesRepository;
	
	/**
	 * Save.
	 *
	 * @param appDataBase the app data base
	 */
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
