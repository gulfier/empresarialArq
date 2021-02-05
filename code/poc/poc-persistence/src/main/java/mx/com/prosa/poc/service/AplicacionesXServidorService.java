package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.AplicacionesXServidorTO;
import mx.com.prosa.poc.to.AplicacionesXservidorEdithTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SoftwarescomXServidorService.
 */
public interface AplicacionesXServidorService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( AplicacionesXServidorTO aplicaciones );

	/**
	 * delete.
	 *
	 * @param site the site
	 */
	Boolean delete(AplicacionesXServidorTO request);

	/**
	 * edit.
	 *
	 * @param site the AplicacionesXservidorEdithTO
	 */
	Boolean edit(AplicacionesXservidorEdithTO object);
}
