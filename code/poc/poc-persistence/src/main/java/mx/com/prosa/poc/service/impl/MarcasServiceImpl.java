/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblMarcas;
import mx.com.prosa.poc.persistence.TblMarcasRepository;
import mx.com.prosa.poc.service.MarcasService;
import mx.com.prosa.poc.to.MarcasTO;

/**
 * @author gllopezv 
 * clase de para las entidades de marcas o companias de los productos
 *
 */
@Service
public class MarcasServiceImpl implements MarcasService {
	
	@Autowired
	TblMarcasRepository  tblMarcasRepository;

	
	/**
	 * Metodo que almacena las bases de datos existentes
	 * */
	@Override
	public void save( MarcasTO marca) {
		// TODO Auto-generated method stub
		tblMarcasRepository.save(transformTO(marca));
	}

	
	  private TblMarcas transformTO(MarcasTO marca )
	  {
		  TblMarcas tblMarcas = new TblMarcas();
		  tblMarcas.setPkIdMarca(marca.getPkIdMarca());
		  tblMarcas.setDsNombre(marca.getDsNombre());
		  tblMarcas.setDsDescripcion(marca.getDsDescripcion());
		  
	
	    return tblMarcas;
	  }
	  
  

}
