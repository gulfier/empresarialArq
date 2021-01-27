package mx.com.prosa.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActoresXAplicacion;
import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.model.TblAppXBaseDatos;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.persistence.TblAplicacionesRepository;
import mx.com.prosa.poc.persistence.TblAppXBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.service.AppXBaseDatosService;
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;
import mx.com.prosa.poc.to.AppXBaseDatosEdithTO;
import mx.com.prosa.poc.to.AppXBaseDatosTO;
import mx.com.prosa.poc.to.AppsXServAppTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
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
	
	
	/**
	 * delete
	 * Metodo para eliminar un registo.
	 * @param AppXBaseDatosTO
	 * */
	@Override
	public Boolean delete(AppXBaseDatosTO request) {
		// TODO Auto-generated method stub
		tblAppXBaseDatosRepository.delete(tblAppXBaseDatosRepository.
				findTable(request.getFkIdAplicacion(),request.getFkIdBase()).orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND));
		return true;
	}
	
	
	
	@Override
	public Boolean edit(AppXBaseDatosEdithTO object) {
		BaseTOValidationUtil.validateIdNotNull( object );
		TblAppXBaseDatos entity = this.tblAppXBaseDatosRepository.
				findTable(object.getTable().getFkIdAplicacion(),object.getTable().getFkIdBase()).orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
	    
		Optional<TblAppXBaseDatos> entityUpdated = this.tblAppXBaseDatosRepository.
				findTable(object.getUpdate().getFkIdAplicacion(),object.getUpdate().getFkIdBase());
		
		if(!entityUpdated.isPresent()) {
			entity.setFkIdAplicacion(object.getUpdate().getFkIdAplicacion());
			entity.setFkIdBase(object.getUpdate().getFkIdBase());
			this.tblAppXBaseDatosRepository.save( entity );
		    this.tblAppXBaseDatosRepository.flush();
		}
		return true;
	}

}
