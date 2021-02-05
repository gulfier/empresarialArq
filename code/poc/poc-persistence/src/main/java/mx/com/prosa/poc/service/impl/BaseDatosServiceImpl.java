/**
 * 
 */
package mx.com.prosa.poc.service.impl;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.service.BaseDatosService;
import mx.com.prosa.poc.to.BaseDatosTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * @author gllopezv 
 * clase de para las entidades de base de datos
 *
 */
@Service
public class BaseDatosServiceImpl implements BaseDatosService {
	
	@Autowired
	TblBaseDatosRepository tblBaseDatosRepository;

	
	/**
	 * Metodo que almacena las bases de datos existentes
	 * */
	@Override
	public void save( BaseDatosTO base) {
		// TODO Auto-generated method stub
		tblBaseDatosRepository.save(transformTO(base));
	}

	
	  private TblBaseDatos transformTO( BaseDatosTO base )
	  {
		  
     		TblBaseDatos baseDatos = new TblBaseDatos();
			baseDatos.setDsAlgoritmo(base.getDsAlgoritmo());
			baseDatos.setDsCode(base.getDsCode());
			baseDatos.setDsEncripcion(base.getDsEncripcion());
			baseDatos.setDsName(base.getDsName());
			baseDatos.setDsNombre(base.getDsNombre()) ;
			baseDatos.setDsPci(base.getDsPci());
			baseDatos.setDsUserCreation(base.getDsUserCreation());
			baseDatos.setDsUserModification(base.getDsUserModification());
			
			TblActores tblActores = new TblActores();
			tblActores.setPkIdActor(base.getFkIdResponsable());
			baseDatos.setFkIdResponsable(tblActores);
			
			
			baseDatos.setDtCreation(getDate(base.getDtCreation()));
			baseDatos.setDtModified(getDate(base.getDtModified()));
			
		
	    return baseDatos;
	  }
	  
		/**
		 * Delete.
		 *
		 * @param id the id
		 * @return the boolean
		 */
		@Override
		public Boolean delete(Long id) {
			tblBaseDatosRepository.delete(tblBaseDatosRepository.
					findById(id).orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND));
			return true;
		}
		
		
		/**
		 * Edits the.
		 *
		 * @param actores the table
		 * @return the boolean
		 */
		@Override
		public Boolean edit(BaseDatosTO base) {
			BaseTOValidationUtil.validateIdNotNull( base );
			TblBaseDatos entity = this.tblBaseDatosRepository.findById( base.getPkIdBase() )
		        .orElseThrow( SupplierBusinessException.DATA_BASE_NOT_FOUND );
			entity.setDsAlgoritmo(base.getDsAlgoritmo());
			entity.setDsCode(base.getDsCode());
			entity.setDsEncripcion(base.getDsEncripcion());
			entity.setDsName(base.getDsName());
			entity.setDsNombre(base.getDsNombre()) ;
			entity.setDsPci(base.getDsPci());
			entity.setDsUserCreation(base.getDsUserCreation());
			entity.setDsUserModification(base.getDsUserModification());
			
			TblActores tblActores = new TblActores();
			tblActores.setPkIdActor(base.getFkIdResponsable());
			entity.setFkIdResponsable(tblActores);
			
			
			entity.setDtCreation(getDate(base.getDtCreation()));
			entity.setDtModified(getDate(base.getDtModified()));
		    
		    this.tblBaseDatosRepository.save( entity );
		    this.tblBaseDatosRepository.flush();
			return true;
		}
	  
	  private Timestamp getDate(String fecha) {
		  
		  Timestamp timestamp = null;
		  try {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = dateFormat.parse(fecha);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		    return timestamp;
	  }



	  

}
