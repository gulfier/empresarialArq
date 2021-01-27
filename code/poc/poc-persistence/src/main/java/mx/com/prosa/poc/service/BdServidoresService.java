package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.BdServidoresEditTO;
import mx.com.prosa.poc.to.BdServidoresTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BdServidoresService.
 */
public interface BdServidoresService {
	
	/**
	 * Save.
	 *
	 * @param bdServer the bd server
	 */
	void save( BdServidoresTO bdServer );

	/**
	 * delete
	 * Metodo para eliminar un registo.
	 * @param AppXBaseDatosTO
	 * */
	Boolean delete(BdServidoresTO request);

	Boolean edit(BdServidoresEditTO object);
}
