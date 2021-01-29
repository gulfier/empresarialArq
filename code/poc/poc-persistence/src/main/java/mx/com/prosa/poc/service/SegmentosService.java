package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.SegmentosTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SegmentosService.
 */
public interface SegmentosService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( SegmentosTO site );
	
	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	Boolean edit(SegmentosTO object);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete( Long id );
}
