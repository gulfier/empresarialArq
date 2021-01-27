package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.BitacoraCambiosTO;

/**
 * Interface para la manipulacion de la persistencia de los sitios
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface BitacoraCambiosService
{

  /**
   * Guarda un sitio
   * 
   * @param site
   */
  void save( BitacoraCambiosTO site );

  /**
   * Busca todos los sitios
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<BitacoraCambiosTO> findAll( PagingRequestTO<BitacoraCambiosTO> request );

  /**
   * Busca los sitios por medio de los parametros de consulta
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<BitacoraCambiosTO> findByExample( PagingRequestTO<BitacoraCambiosTO> request );

  /**
   * Busca un sitio por id
   * 
   * @param id
   * @return
   */
  BitacoraCambiosTO findById( Long id );

  /**
   * Busca un sitio por su codigos
   * 
   * @param code
   * @return
   */
  BitacoraCambiosTO findByCode( String code );

  /**
   * Edita un sitio
   * 
   * @param site
   * @param patch  Indica si es parcial
   */
  void edit( BitacoraCambiosTO site, boolean patch );

  /**
   * Elimina un sitio
   * 
   * @param site
   */
  void delete( BitacoraCambiosTO site );

/**
 * Delete.
 *
 * @param id the id
 * @return the boolean
 */
Boolean delete(Long id);
}
