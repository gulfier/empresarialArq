package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ProtocoloTO;

public interface ProtocolosService {

	/**
	 * Guarda las marcas o marca del producto
	 * 
	 * @param aplicacion
	 */
	void save(ProtocoloTO protocolo);

	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(ProtocoloTO location);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);
}
