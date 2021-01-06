/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblNivelesCifrado;
import mx.com.prosa.poc.persistence.TblNivelesCifradoRepository;
import mx.com.prosa.poc.service.NivelCifradoService;
import mx.com.prosa.poc.to.NivelCifradoTO;

/**
 * @author gllopezv 
 * clase de para las entidades de marcas o companias de los productos
 *
 */
@Service
public class NivelCifradoServiceImpl implements NivelCifradoService {
	
	@Autowired
	TblNivelesCifradoRepository tblNivelesCifradoRepository ;

	
	/**
	 * Metodo que almacena las bases de datos existentes
	 * */
	@Override
	public void save( NivelCifradoTO nivel) {
		// TODO Auto-generated method stub
		tblNivelesCifradoRepository.save(transformTO(nivel));
	}

	
	  private TblNivelesCifrado transformTO(NivelCifradoTO marca )
	  {
		  TblNivelesCifrado TblNivelesCifrado = new TblNivelesCifrado();
		  TblNivelesCifrado.setPkIdCifrado(marca.getPkIdCifrado());
		  TblNivelesCifrado.setDsNombre(marca.getDsNombre());

		  
	
	    return TblNivelesCifrado;
	  }
	  
  

}
