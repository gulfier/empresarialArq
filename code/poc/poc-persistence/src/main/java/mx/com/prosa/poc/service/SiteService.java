package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.SiteTO;

/**
 * Interface para la manipulacion de la persistencia de los sitios
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface SiteService
{

  /**
   * Guarda un sitio
   * 
   * @param site
   */
  void save( SiteTO site );

  /**
   * Busca todos los sitios
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<SiteTO> findAll( PagingRequestTO<SiteTO> request );

  /**
   * Busca los sitios por medio de los parametros de consulta
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<SiteTO> findByExample( PagingRequestTO<SiteTO> request );

  /**
   * Busca un sitio por id
   * 
   * @param id
   * @return
   */
  SiteTO findById( Long id );

  /**
   * Busca un sitio por su codigos
   * 
   * @param code
   * @return
   */
  SiteTO findByCode( String code );

  /**
   * Edita un sitio
   * 
   * @param site
   * @param patch  Indica si es parcial
   */
  void edit( SiteTO site, boolean patch );

  /**
   * Elimina un sitio
   * 
   * @param site
   */
  void delete( SiteTO site );
}
