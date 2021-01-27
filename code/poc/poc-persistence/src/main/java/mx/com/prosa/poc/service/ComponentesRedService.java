package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ComponentesRedTO;

public interface  ComponentesRedService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( ComponentesRedTO componente );

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
	Boolean edit(ComponentesRedTO base);

}
