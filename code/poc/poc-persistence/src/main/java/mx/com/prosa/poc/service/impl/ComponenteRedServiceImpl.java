/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.model.TblComponentesRed;
import mx.com.prosa.poc.model.TblIp;
import mx.com.prosa.poc.persistence.TblComponentesRedRepository;
import mx.com.prosa.poc.service.ComponentesRedService;
import mx.com.prosa.poc.to.BaseDatosTO;
import mx.com.prosa.poc.to.ComponentesRedTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * @author gllopezv 
 * clase de para las entidades componentes de RED
 *
 */
@Service
public class ComponenteRedServiceImpl implements ComponentesRedService {
	
	@Autowired
	TblComponentesRedRepository tblComponentesRedRepository;

	
	/**
	 * Metodo que almacena los componentes de red existentes
	 * */
	@Override
	public void save( ComponentesRedTO componente) {
		// TODO Auto-generated method stub
		tblComponentesRedRepository.save(transformTO(componente));
	}
	
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblComponentesRedRepository.delete(tblComponentesRedRepository.
				findById(id).orElseThrow(SupplierBusinessException.COMPONENTE_RED_NOT_FOUND));
		return true;
	}
	
	
	
	/**
	 * Edits the.
	 *
	 * @param actores the table
	 * @return the boolean
	 */
	@Override
	public Boolean edit(ComponentesRedTO base) {
		BaseTOValidationUtil.validateIdNotNull( base );
		TblComponentesRed entity = this.tblComponentesRedRepository.findById( base.getPkIdComponente() )
	        .orElseThrow( SupplierBusinessException.DATA_BASE_NOT_FOUND );
		
		
		entity.setDsDescripcion(base.getDsDescripcion());
		entity.setDsNombre(base.getDsNombre());
		entity.setDsServicio(base.getDsServicio());
		//tblComponentesRed.setFkIdIp(base.getFkIdIp());
		TblIp s = new TblIp();
		s.setPkIdIp(base.getFkIdIp());
		entity.setTblIp(s);
		entity.setPkIdComponente(base.getPkIdComponente());

	    
	    this.tblComponentesRedRepository.save( entity );
	    this.tblComponentesRedRepository.flush();
		return true;
	}

	
	private TblComponentesRed transformTO( ComponentesRedTO base )
	  {
		  
     		TblComponentesRed tblComponentesRed = new TblComponentesRed();
			tblComponentesRed.setDsDescripcion(base.getDsDescripcion());
			tblComponentesRed.setDsNombre(base.getDsNombre());
			tblComponentesRed.setDsServicio(base.getDsServicio());
			//tblComponentesRed.setFkIdIp(base.getFkIdIp());
			TblIp s = new TblIp();
			s.setPkIdIp(base.getFkIdIp());
			tblComponentesRed.setTblIp(s);
			tblComponentesRed.setPkIdComponente(base.getPkIdComponente());

		    return tblComponentesRed;
	  }
	  
	  

	  
  

}
