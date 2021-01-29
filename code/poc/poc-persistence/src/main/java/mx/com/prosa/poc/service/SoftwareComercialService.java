package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.SoftwareComercialTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SoftwareComercialService.
 */
public interface SoftwareComercialService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( SoftwareComercialTO site );
	
	/**
	 * Edits the.
	 *
	 * @param software the software
	 * @return the boolean
	 */
	Boolean edit(SoftwareComercialTO software);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete( Long id );
}
