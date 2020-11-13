package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.ServerTO;

/**
 * Interface para la manipulacion de la persistencia de los servidores
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ServerService
{

  /**
   * Guarda un servidor
   * 
   * @param server
   */
  void save( ServerTO server );

  /**
   * Busca todos los servidores
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ServerTO> findAll( PagingRequestTO<ServerTO> request );

  /**
   * Busca los servidores por medio de los datos de consulta
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<ServerTO> findByExample( PagingRequestTO<ServerTO> request );

  /**
   * Busca un servidor por id
   * 
   * @param id
   * @return
   */
  ServerTO findById( Long id );

  /**
   * Busca un servidor por su codigo
   * 
   * @param code
   * @return
   */
  ServerTO findByCode( String code );

  /**
   * Edita un servidor
   * 
   * @param server
   */
  void edit( ServerTO server );

  /**
   * Elimina un servidor
   * 
   * @param server
   */
  void delete( ServerTO server );
}
