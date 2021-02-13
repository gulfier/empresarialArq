package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.BitacoraCambiosTO;
import mx.com.prosa.poc.to.ConsoleResponseTO;

/**
 * Interface para la manipulacion de la persistencia de los sitios
 * 
 * @author Jorge Ortega Hernández <jorgeortega30@live.com.mx>
 */
public interface BitacoraCambiosService
{

  /**
   * Busca todos los sitios
   * 
   * @param request parametros de busqueda paginada
   * @return
   */
	ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>> findAll( PagingRequestTO<BitacoraCambiosTO> request, Integer page, Integer size);

	PagingResponseTO<BitacoraCambiosTO> getHistory( PagingRequestTO<BitacoraCambiosTO> request,Integer size, Integer page, String type,
			Long initDate,Long endDate);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);
}
