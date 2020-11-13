package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;

/**
 * Interface para la manipulacion de la persistencia de los servicios de TI
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ITServiceService
{
  /**
   * Guarda el servicio de TI
   * 
   * @param itService
   */
  void save( ITServiceTO itService );

  /**
   * Busca todos los servicios de TI
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ITServiceTO> findAll( PagingRequestTO<ITServiceTO> request );

  /**
   * Busca los servicios de TI por medio de los parametros de consulta
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ITServiceTO> findByExample( PagingRequestTO<ITServiceTO> request );

  /**
   * Busca un servicio de TI por id
   * 
   * @param id
   * @return
   */
  ITServiceTO findById( Long id );

  /**
   * Busca un servicio de TI por su codigo
   * 
   * @param code
   * @return
   */
  ITServiceTO findByCode( String code );

  /**
   * Edita un servicio de TI
   * 
   * @param itService
   */
  void edit( ITServiceTO itService );

  /**
   * Elimina un servicio de TI
   * 
   * @param itService
   */
  void delete( ITServiceTO itService );
}
