package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ActoresXAplicacionTO;
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ActoresXAplicacionService.
 */
public interface ActoresXAplicacionService {
	
	/**
	 * Save.
	 *
	 * @param actorApp the actor app
	 */
	void save(ActoresXAplicacionTO actorApp);

	/**
	 * Delete.
	 *
	 * @param ipServer the ip server
	 * @return the boolean
	 */
	Boolean  delete(ActoresXAplicacionTO request);
	
	
	/**
	 * Edits the.
	 *
	 * @param ipServer the ip server
	 * @return the boolean
	 */
	Boolean edit(ActoresXaplicacionEdithTO request);
}
