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
   * Busca todos los sitios
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
  PagingResponseTO<BitacoraCambiosTO> findAll( PagingRequestTO<BitacoraCambiosTO> request );



	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);
}
