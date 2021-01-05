package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.BaseDatosTO;

public interface  BaseDatosService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( BaseDatosTO base );

}
