package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ApplicationTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;

/**
 * Interface para la manipulacion de la persistencia de las aplicaciones
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ApplicationService
{

  /**
   * Guarda la aplicacion
   * 
   * @param application
   */
  void save( ApplicationTO application );

  /**
   * Busca todas las aplicaciones
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ApplicationTO> findAll( PagingRequestTO<ApplicationTO> request );

  /**
   * Busca las aplicaciones por medio de los datos de consulta
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ApplicationTO> findByExample( PagingRequestTO<ApplicationTO> request );

  /**
   * Busca una aplicacion por id
   * 
   * @param id
   * @return
   */
  ApplicationTO findById( Long id );

  /**
   * Busca una aplicacion por su codigo
   * 
   * @param code
   * @return
   */
  ApplicationTO findByCode( String code );

  /**
   * Edita una aplicacion
   * 
   * @param application
   * @param patch 
   */
  void edit( ApplicationTO application, boolean patch );

  /**
   * Elimina una aplicacion
   * 
   * @param application
   */
  void delete( ApplicationTO application );
}
