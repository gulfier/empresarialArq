package mx.com.prosa.poc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.BitacoraCambiosDO;
import mx.com.prosa.poc.persistence.BitacoraCambiosRepository;
import mx.com.prosa.poc.service.BitacoraCambiosService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.BitacoraCambiosTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.PagingRequestUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * Implementacion de la interface {@link mx.com.prosa.poc.service.BitacoraCambiosService}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class BitacoraCambiosServiceImpl implements BitacoraCambiosService
{

  private static final String VALIDATION_ERROR = "Error de validaci\u00F3n";
  private static final String VALIDATION_ERROR_SITE_CODE_EXISTS = "Ya existe el sitio";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED_NUMBER = "Hay %s aplicaciones asociadas al sitio";

  private static final String VALIDATION_ERROR_APPLICATION_ASSOCIATED = "Hay aplicaciones asociadas al sitio";

  @Autowired
  private BitacoraCambiosRepository bitacoraCambiosRepository;


  /**
   * {@inheritDoc}
   */
  @Override
  public PagingResponseTO<BitacoraCambiosTO> findAll( PagingRequestTO<BitacoraCambiosTO> request )
  {
    PageRequest pg = PagingRequestUtil.extractPaging( request );

   //Iterable<BitacoraCambiosDO> bitacoraCambiosDO = bitacoraCambiosRepository.findAll();
   //Integer a=  bitacoraCambiosDO.size();
    
   // Page<BitacoraCambiosDO> paged = this.bitacoraCambiosRepository.findAll( pg );
    
    List<BitacoraCambiosDO> hj= bitacoraCambiosRepository.findAllCambios();

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
    response.setRecords( data.size());
    response.setPages(1 );

    return response;
  }

  private BitacoraCambiosTO transform2TO( BitacoraCambiosDO entity )
  {
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

@Override
public void save(BitacoraCambiosTO site) {
	// TODO Auto-generated method stub
	
}

@Override
public PagingResponseTO<BitacoraCambiosTO> findByExample(PagingRequestTO<BitacoraCambiosTO> request) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public BitacoraCambiosTO findById(Long id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public BitacoraCambiosTO findByCode(String code) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void edit(BitacoraCambiosTO site, boolean patch) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(BitacoraCambiosTO site) {
	// TODO Auto-generated method stub
	
}



}
