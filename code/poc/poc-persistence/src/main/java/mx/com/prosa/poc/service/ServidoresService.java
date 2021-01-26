package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ServidoresTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServidoresService.
 */
public interface ServidoresService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( ServidoresTO server );
	
	/**
	 * Edits the.
	 *
	 * @param server the server
	 * @return the boolean
	 */
	Boolean edit(ServidoresTO server);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete( Long id );
}
