package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.SoftwarescomXServidorEdithTO;
import mx.com.prosa.poc.to.SoftwarescomXServidorTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SoftwarescomXServidorService.
 */
public interface SoftwarescomXServidorService {

	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save(SoftwarescomXServidorTO site);

	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(SoftwarescomXServidorEdithTO location);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(SoftwarescomXServidorTO id);
}
