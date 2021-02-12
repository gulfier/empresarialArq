package mx.com.prosa.poc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.BitacoraCambiosDO;
import mx.com.prosa.poc.persistence.BitacoraCambiosRepository;
import mx.com.prosa.poc.service.BitacoraCambiosService;
import mx.com.prosa.poc.to.BitacoraCambiosTO;
import mx.com.prosa.poc.to.ConsoleResponseTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface
 * {@link mx.com.prosa.poc.service.BitacoraCambiosService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class BitacoraCambiosServiceImpl implements BitacoraCambiosService {

	@Autowired
	private BitacoraCambiosRepository bitacoraCambiosRepository;

	/**
   * {@inheritDoc}
   */
  @Override
  public ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>> findAll( PagingRequestTO<BitacoraCambiosTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

   //Iterable<BitacoraCambiosDO> bitacoraCambiosDO = bitacoraCambiosRepository.findAll();
   //Integer a=  bitacoraCambiosDO.size();
    
   // Page<BitacoraCambiosDO> paged = this.bitacoraCambiosRepository.findAll( pg );
    
    Pageable paginacion = PageRequest.of(1 - 1, 10);
    
    List<BitacoraCambiosDO> hj= bitacoraCambiosRepository.findAllCambios(paginacion);

     PagingResponseTO<BitacoraCambiosTO> response = new PagingResponseTO<>();

    List<BitacoraCambiosTO> data = new ArrayList<>();

    
     hj.forEach(entity -> {
      BitacoraCambiosTO site = transform2TO( entity );
      data.add( site );
    });
  /*  paged.get().forEach( entity -> {
      BitacoraCambiosTO site = transform2TO( entity );
      data.add( site );
    } );*/

    response.setData( data );

    response.setPage( pg.getPageNumber() );
    response.setSize( pg.getPageSize() );
    response.setRecords( bitacoraCambiosRepository.countChanges());
    response.setPages(1 );
    
    ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>> consoleData = new ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>>();
	consoleData.setChanges(response);
	
	consoleData.setGraph("{\"puntos\":[{\"date\":\"01/NOV/20\",\"changes\":0},{\"date\":\"15/NOV/20\",\"changes\":300},{\"date\":\"01/DIC/20\",\"changes\":600},{\"date\":\"15/DIC/20\",\"changes\":800},{\"date\":\"01/ENE/21\",\"changes\":1500},{\"date\":\"15/ENE/21\",\"changes\":2000},{\"date\":\"01/FEB/21\",\"changes\":2400},{\"date\":\"15/FEB/21\",\"changes\":2400},{\"date\":\"01/MAR/21\"}]}");

    return consoleData;
  }

	private BitacoraCambiosTO transform2TO(BitacoraCambiosDO entity) {
		BitacoraCambiosTO siteTO = new BitacoraCambiosTO();
		siteTO.setId(entity.getId());
		siteTO.setDsCodigo(entity.getDsCodigo());
		siteTO.setFecha(entity.getFecha());
		siteTO.setDsDescripcion(entity.getDsDescripcion());
		siteTO.setDsTipo(entity.getDsTipo());
		siteTO.setDsAutor(entity.getDsAutor());
		siteTO.setDsCambioActual(entity.getDsCambioActual());
		siteTO.setDsCambioAnterior(entity.getDsCambioAnterior());
		siteTO.setDsEstatus(entity.getDsEstatus());

		return siteTO;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		bitacoraCambiosRepository.delete(
				bitacoraCambiosRepository.findById(id).orElseThrow(SupplierBusinessException.BITACORA_NOT_FOUND));
		return true;
	}

}
