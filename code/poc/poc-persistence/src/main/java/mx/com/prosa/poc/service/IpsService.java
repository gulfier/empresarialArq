package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.IpTO;

public interface  IpsService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( IpTO ip );

}
