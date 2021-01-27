package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ActoresTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ActoresService.
 */
public interface ActoresService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( ActoresTO site );
	/**
	 * delete.
	 *
	 * @param site the site
	 */
	 Boolean delete(Long id);
	/**
	 * Edits the.
	 *
	 * @param table the table
	 * @return the boolean
	 */
	Boolean edit(ActoresTO table);
}
