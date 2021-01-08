/**
 * 
 */
package mx.com.prosa.poc.service.impl;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblAplicaciones;
import mx.com.prosa.poc.persistence.TblAplicacionesRepository;
import mx.com.prosa.poc.service.AplicacionesService;
import mx.com.prosa.poc.to.AplicacionTO;

/**
 * @author gllopezv 
 * clase de para las entidades de las aplicaciones
 *
 */
@Service
public class AplicacionesServiceImpl implements AplicacionesService {
	
	@Autowired
	TblAplicacionesRepository tblAplicacionesRepository;

	
	/**
	 * Metodo que almacena las aplicaciones
	 * */
	@Override
	public void save(AplicacionTO aplicacion) {
		// TODO Auto-generated method stub

		tblAplicacionesRepository.save(transformTO(aplicacion));
		
	}

	
	  private TblAplicaciones transformTO( AplicacionTO aplicacion )
	  {
		  TblAplicaciones app = new TblAplicaciones();
          app.setPkIdAplicacion(aplicacion.getPkIdAplicacion());
          app.setDsClasificacion(aplicacion.getDsClasificacion());
          app.setDsCode(aplicacion.getDsCode());
          app.setDsComment(aplicacion.getDsComment());
          app.setDsDescripcion(aplicacion.getDsDescripcion() );
          app.setDsEstatus(aplicacion.getDsEstatus()) ;
          app.setDsName(aplicacion.getDsName());
          app.setDsNombre(aplicacion.getDsNombre()) ;
          app.setDsNombreCorto(aplicacion.getDsNombreCorto());
          app.setDsNombreLargo(aplicacion.getDsNombreLargo());
          app.setDsPci(aplicacion.getDsPci());
          app.setDsUserCreation(aplicacion.getDsUserCreation());
          app.setDsUserModification(aplicacion.getDsUserModification());
          app.setDtCreation(getDate(aplicacion.getDtCreation()));
          app.setDtModified(getDate(aplicacion.getDtModified()));
          
	    return app;
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
