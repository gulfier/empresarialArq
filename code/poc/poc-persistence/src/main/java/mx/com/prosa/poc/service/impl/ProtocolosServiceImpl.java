/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblNivelesCifrado;
import mx.com.prosa.poc.model.TblProtocolos;
import mx.com.prosa.poc.persistence.TblProtocolosRepository;
import mx.com.prosa.poc.service.ProtocolosService;
import mx.com.prosa.poc.to.ProtocoloTO;

/**
 * @author gllopezv 
 * clase de para las entidades de marcas o companias de los productos
 *
 */
@Service
public class ProtocolosServiceImpl implements ProtocolosService {
	
	@Autowired
	TblProtocolosRepository  tblProtocolosRepository;

	
	/**
	 * Metodo que almacena las bases de datos existentes
	 * */
	@Override
	public void save( ProtocoloTO protocolo) {
		// TODO Auto-generated method stub
		tblProtocolosRepository.save(transformTO(protocolo));
	}

	
	  private TblProtocolos transformTO(ProtocoloTO protocolo)
	  {
		  TblProtocolos TblProtocolos = new TblProtocolos();
		  TblProtocolos.setPkIdProtocolo(protocolo.getPkIdProtocolo());
		  TblProtocolos.setDsNombre(protocolo.getDsNombre());
		  TblProtocolos.setDsVersion(protocolo.getDsVersion());
		  
		  TblNivelesCifrado  tblNivelesCifrado = new TblNivelesCifrado(); 
		  tblNivelesCifrado.setPkIdCifrado(protocolo.getFkIdCifrado());
		  TblProtocolos.setTblNivelesCifrado(tblNivelesCifrado);
		  
	
	    return TblProtocolos;
	  }
	  
  

}
