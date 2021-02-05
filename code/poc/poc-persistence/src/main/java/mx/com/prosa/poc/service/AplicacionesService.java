package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.AplicacionTO;

public interface  AplicacionesService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( AplicacionTO aplicacion );
	  
	  
	  /**
	   * Elimina aplicaciones
	   * 
	   * @param aplicacion
	   */
	  Boolean delete(Long id);


	/**
	 * Edits the.
	 *
	 * @param aplicaciones the table
	 * @return the boolean
	 */
	Boolean edit(AplicacionTO aplicacion);

}
