package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.IpXServidoresEdithTO;
import mx.com.prosa.poc.to.TblIpXServidoresTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TblIpXServidoresService.
 */
public interface TblIpXServidoresService {
	
	/**
	 * Save.
	 *
	 * @param site the site
	 */
	void save( TblIpXServidoresTO ipServer );
	
	/**
	 * Edits the.
	 *
	 * @param ipServer the ip server
	 * @return the boolean
	 */
	Boolean edit(IpXServidoresEdithTO ipServer);
	
	/**
	 * Delete.
	 *
	 * @param ipServer the ip server
	 * @return the boolean
	 */
	Boolean delete( TblIpXServidoresTO ipServer );
}
