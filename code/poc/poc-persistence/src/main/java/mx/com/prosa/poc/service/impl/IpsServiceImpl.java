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
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class IpsServiceImpl.
 *
 * @author gllopezv clase de para las entidades de base de datos
 */
@Service
public class IpsServiceImpl implements IpsService {

	/** The tbl ip repository. */
	@Autowired
	TblIpRepository tblIpRepository;

	/**
	 * Metodo que almacena las bases de datos existentes.
	 *
	 * @param ip the ip
	 */
	@Override
	public void save(IpTO ip) {
		// TODO Auto-generated method stub
		tblIpRepository.save(transformTO(ip));
	}

	/**
	 * Transform TO.
	 *
	 * @param ip the ip
	 * @return the tbl ip
	 */
	private TblIp transformTO(IpTO ip) {
		TblIp tblIp = new TblIp();
		tblIp.setPkIdIp(ip.getPkIdIp());
		tblIp.setDsIp(ip.getDsIp());
		tblIp.setDsTipo(ip.getDsTipo());

		TblSegmentos segmentos = new TblSegmentos();
		segmentos.setPkIdSegmento(ip.getFkIdSegmento());

		tblIp.setTblSegmentos(segmentos);

		return tblIp;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblIpRepository
				.delete(tblIpRepository.findById(id).orElseThrow(SupplierBusinessException.IP_NOT_FOUND));
		return true;
	}

	/**
	 * Edits the.
	 *
	 * @param location the location
	 * @return the boolean
	 */
	@Override
	public Boolean edit(IpTO ip) {
		BaseTOValidationUtil.validateIdNotNull(ip);
		TblIp entity = this.tblIpRepository.findById(ip.getId())
				.orElseThrow(SupplierBusinessException.IP_NOT_FOUND);
		entity.setDsIp(ip.getDsIp());
		entity.setDsTipo(ip.getDsTipo());

		this.tblIpRepository.save(entity);
		this.tblIpRepository.flush();
		return true;
	}

}
