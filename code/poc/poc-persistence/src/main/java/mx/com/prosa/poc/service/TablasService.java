package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.TablasTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TablasService.
 */
public interface TablasService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( TablasTO table );
	
	/**
	 * Edits the.
	 *
	 * @param table the table
	 * @return the boolean
	 */
	Boolean edit(TablasTO table);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete( Long id );
}
