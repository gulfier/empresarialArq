/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblComponentesRed;
import mx.com.prosa.poc.model.TblIp;
import mx.com.prosa.poc.persistence.TblComponentesRedRepository;
import mx.com.prosa.poc.service.ComponentesRedService;
import mx.com.prosa.poc.to.ComponentesRedTO;

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
