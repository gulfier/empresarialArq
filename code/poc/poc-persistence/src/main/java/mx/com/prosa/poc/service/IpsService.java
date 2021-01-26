package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.IpTO;

/**
 * The Interface IpsService.
 */
public interface IpsService {

	/**
	 * Guarda una aplicacion.
	 *
	 * @param ip the ip
	 */
	void save(IpTO ip);

	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(IpTO location);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);

}
