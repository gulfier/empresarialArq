package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.AppXservicioEdithTO;
import mx.com.prosa.poc.to.AppsXServAppTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TblAppsXServAppService.
 */
public interface AppsXServAppService {
	
	/**
	 * Save.
	 *
	 * @param appsServiceApp the apps service app
	 */
	void save(AppsXServAppTO appsServiceApp);

	
	/**
	 * delete.
	 *
	 * @param AppsXServAppTO the apps service app
	 */
	Boolean delete(AppsXServAppTO request);

	/**
	 * edit.
	 *
	 * @param AppXservicioEdithTO the apps service app
	 */
	Boolean edit(AppXservicioEdithTO object);
}
