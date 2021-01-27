package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.BaseDatosTO;

public interface  BaseDatosService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( BaseDatosTO base );

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);

	/**
	 * Edits the.
	 *
	 * @param actores the table
	 * @return the boolean
	 */
	Boolean edit(BaseDatosTO base);

}
