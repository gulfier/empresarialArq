/**
 * 
 */
package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblNivelesCifrado;
import mx.com.prosa.poc.model.TblProtocolos;
import mx.com.prosa.poc.persistence.TblNivelesCifradoRepository;
import mx.com.prosa.poc.persistence.TblProtocolosRepository;
import mx.com.prosa.poc.service.ProtocolosService;
import mx.com.prosa.poc.to.ProtocoloTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class ProtocolosServiceImpl.
 *
 * @author gllopezv clase de para las entidades de marcas o companias de los
 *         productos
 */
@Service
public class ProtocolosServiceImpl implements ProtocolosService {

	/** The tbl protocolos repository. */
	@Autowired
	TblProtocolosRepository tblProtocolosRepository;
	
	/** The tbl niveles cifrado repository. */
	@Autowired
	TblNivelesCifradoRepository tblNivelesCifradoRepository;

	/**
	 * Metodo que almacena las bases de datos existentes.
	 *
	 * @param protocolo the protocolo
	 */
	@Override
	public void save(ProtocoloTO protocolo) {
		// TODO Auto-generated method stub
		tblProtocolosRepository.save(transformTO(protocolo));
	}

	/**
	 * Transform TO.
	 *
	 * @param protocolo the protocolo
	 * @return the tbl protocolos
	 */
	private TblProtocolos transformTO(ProtocoloTO protocolo) {
		TblProtocolos TblProtocolos = new TblProtocolos();
		TblProtocolos.setPkIdProtocolo(protocolo.getPkIdProtocolo());
		TblProtocolos.setDsNombre(protocolo.getDsNombre());
		TblProtocolos.setDsVersion(protocolo.getDsVersion());

		TblNivelesCifrado tblNivelesCifrado = new TblNivelesCifrado();
		tblNivelesCifrado.setPkIdCifrado(protocolo.getFkIdCifrado());
		TblProtocolos.setTblNivelesCifrado(tblNivelesCifrado);

		return TblProtocolos;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblProtocolosRepository
				.delete(tblProtocolosRepository.findById(id).orElseThrow(SupplierBusinessException.PROTOCOL_NOT_FOUND));
		return true;
	}

	/**
	 * Edits the.
	 *
	 * @param protocol the protocol
	 * @return the boolean
	 */
	@Override
	public Boolean edit(ProtocoloTO protocol) {
		BaseTOValidationUtil.validateIdNotNull(protocol);
		TblProtocolos entity = this.tblProtocolosRepository.findById(protocol.getId())
				.orElseThrow(SupplierBusinessException.PROTOCOL_NOT_FOUND);
		entity.setDsNombre(protocol.getDsNombre());
		entity.setDsVersion(protocol.getDsVersion());

		if(protocol.getFkIdCifrado()!=null) {
			TblNivelesCifrado nivelesCifrado = tblNivelesCifradoRepository.findById(protocol.getFkIdCifrado())
					.orElseThrow(SupplierBusinessException.TABLE_NOT_FOUND);
			entity.setTblNivelesCifrado(nivelesCifrado);
		}

		this.tblProtocolosRepository.save(entity);
		this.tblProtocolosRepository.flush();
		return true;
	}

}
