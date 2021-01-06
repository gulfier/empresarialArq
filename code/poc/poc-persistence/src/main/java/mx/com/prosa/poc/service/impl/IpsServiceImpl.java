/**
 * 
 */
package mx.com.prosa.poc.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblIp;
import mx.com.prosa.poc.model.TblSegmentos;
import mx.com.prosa.poc.persistence.TblIpRepository;
import mx.com.prosa.poc.service.IpsService;
import mx.com.prosa.poc.to.IpTO;

/**
 * @author gllopezv 
 * clase de para las entidades de base de datos
 *
 */
@Service
public class IpsServiceImpl implements IpsService {
	
	@Autowired
	TblIpRepository tblIpRepository;

	
	/**
	 * Metodo que almacena las bases de datos existentes
	 * */
	@Override
	public void save( IpTO ip) {
		// TODO Auto-generated method stub
		tblIpRepository.save(transformTO(ip));
	}

	
	  private TblIp transformTO(IpTO ip )
	  {
		  TblIp tblIp = new TblIp();
		  tblIp.setPkIdIp(ip.getPkIdIp());
		  tblIp.setDsIp(ip.getDsIp());
		  tblIp.setDsTipo(ip.getDsTipo());
		  
		  TblSegmentos segmentos = new TblSegmentos();
		  segmentos.setPkIdSegmento(ip.getFkIdSegmento());
		  
		  tblIp.setTblSegmentos(segmentos);
		
	    return tblIp;
	  }
	  
  

}
