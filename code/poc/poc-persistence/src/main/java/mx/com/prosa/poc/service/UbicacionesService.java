package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.UbicacionTO;

/**
 * The Interface UbicacionesService.
 */
public interface UbicacionesService {
	
	/**
	 * Guarda un sitio.
	 *
	 * @param site the site
	 */
	void save( UbicacionTO location );
	
	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(UbicacionTO location);
	
	/**
	 * Delete.
	 *
	 * @param site the site
	 * @return the boolean
	 */
	Boolean delete( Long id );
}
