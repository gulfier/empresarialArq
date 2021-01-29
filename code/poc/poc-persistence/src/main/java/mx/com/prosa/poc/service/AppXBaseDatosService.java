package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.AppXBaseDatosEdithTO;
import mx.com.prosa.poc.to.AppXBaseDatosTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AppXBaseDatosService.
 */
public interface AppXBaseDatosService {
	
	/**
	 * Save.
	 *
	 * @param appDataBase the app data base
	 */
	void save( AppXBaseDatosTO appDataBase );

	/**
	 * delete
	 * Metodo para eliminar un registo.
	 * @param AppsXServAppTO
	 * */
	Boolean delete(AppXBaseDatosTO request);

	/**
	 * edit
	 * Metodo para eliminar un registo.
	 * @param AppXBaseDatosEdithTO
	 * */
	Boolean edit(AppXBaseDatosEdithTO object);
}
