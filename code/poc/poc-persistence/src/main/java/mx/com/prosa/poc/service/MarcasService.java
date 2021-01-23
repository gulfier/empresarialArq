package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.MarcasTO;

public interface MarcasService {

	/**
	 * Guarda las marcas o marca del producto
	 * 
	 * @param aplicacion
	 */
	void save(MarcasTO marcas);

	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(MarcasTO location);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);

}
