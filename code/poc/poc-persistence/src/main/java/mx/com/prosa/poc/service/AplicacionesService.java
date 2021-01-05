package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.AplicacionTO;

public interface  AplicacionesService {
	
	  /**
	   * Guarda una aplicacion
	   * 
	   * @param aplicacion
	   */
	  void save( AplicacionTO aplicacion );

}
