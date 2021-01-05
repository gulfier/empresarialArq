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
	void save( UbicacionTO site );
}
