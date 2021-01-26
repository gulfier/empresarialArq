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
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * @author gllopezv clase de para las entidades de marcas o companias de los
 *         productos
 *
 */
@Service
public class MarcasServiceImpl implements MarcasService {

	@Autowired
	TblMarcasRepository tblMarcasRepository;

	/**
	 * Metodo que almacena las bases de datos existentes
	 */
	@Override
	public void save(MarcasTO marca) {
		// TODO Auto-generated method stub
		tblMarcasRepository.save(transformTO(marca));
	}

	private TblMarcas transformTO(MarcasTO marca) {
		TblMarcas tblMarcas = new TblMarcas();
		tblMarcas.setPkIdMarca(marca.getPkIdMarca());
		tblMarcas.setDsNombre(marca.getDsNombre());
		tblMarcas.setDsDescripcion(marca.getDsDescripcion());

		return tblMarcas;
	}
	
	@Override
	public Boolean delete(Long id) {
		tblMarcasRepository.delete(tblMarcasRepository.
				findById(id).orElseThrow(SupplierBusinessException.BRAND_NOT_FOUND));
		return true;
	}
	
	@Override
	public Boolean edit(MarcasTO brand) {
		BaseTOValidationUtil.validateIdNotNull( brand );
		TblMarcas entity = this.tblMarcasRepository.findById( brand.getPkIdMarca() )
	        .orElseThrow( SupplierBusinessException.BRAND_NOT_FOUND );
		entity.setDsNombre(brand.getDsNombre());
		entity.setDsDescripcion(brand.getDsDescripcion());

	    this.tblMarcasRepository.save( entity );
	    this.tblMarcasRepository.flush();
		return true;
	}

}
