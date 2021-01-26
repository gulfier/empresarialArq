package mx.com.prosa.poc.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.model.TblUbicaciones;
import mx.com.prosa.poc.persistence.TblActorRepository;
import mx.com.prosa.poc.persistence.TblServidoresRepository;
import mx.com.prosa.poc.persistence.TblUbicacionesRepository;
import mx.com.prosa.poc.service.ServidoresService;
import mx.com.prosa.poc.to.ServidoresTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.CommonsUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class ServidoresServiceImpl.
 */
@Service
public class ServidoresServiceImpl implements ServidoresService {

	/** The tbl servidores repository. */
	@Autowired
	private TblServidoresRepository tblServidoresRepository;
	
	/** The tbl actor repository. */
	@Autowired
	private TblActorRepository tblActorRepository;
	
	/** The ubicaciones repository. */
	@Autowired
	private TblUbicacionesRepository ubicacionesRepository;
	
	/**
	 * Save.
	 *
	 * @param servidor the servidor
	 */
	@Override
	public void save(ServidoresTO servidor) {
		TblServidores entity = new TblServidores();
		entity.setPkIdServidor(servidor.getPkIdServidor());
		entity.setDsAmbiente(servidor.getDsAmbiente());
		entity.setDsCode(servidor.getDsCode());
		entity.setDsDescripcion(servidor.getDsDescripcion());
		entity.setDsHostName(servidor.getDsHostName());
		entity.setDsMarcaModelo(servidor.getDsMarcaModelo());
		entity.setDsName(servidor.getDsName());
		entity.setDsPci(servidor.getDsPci());
		entity.setDsProposito(servidor.getDsProposito());
		entity.setDsTipo(servidor.getDsTipo());
		entity.setDsUserCreation(servidor.getDsUserCreation());
		entity.setDsUserModification(servidor.getDsUserModification());
		entity.setDsVirtualizacion(servidor.getDsVirtualizacion());
		entity.setDtCreation(CommonsUtil.toTimestamp(servidor.getDtCreation()));
		entity.setDtModified(CommonsUtil.toTimestamp(servidor.getDtModified()));
		TblActores actore = tblActorRepository.findById(servidor.getFkIdResponsable())
				.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
		entity.setFkIdResponsable(actore);
		TblUbicaciones ubicaciones = ubicacionesRepository.findById(servidor.getFkIdUbicacion())
				.orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND);
		entity.setFkIdUbicacion(ubicaciones);
		tblServidoresRepository.save(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblServidoresRepository.delete(tblServidoresRepository.
				findById(id).orElseThrow(SupplierBusinessException.SERVER_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param server the server
	 * @return the boolean
	 */
	@Override
	public Boolean edit(ServidoresTO server) {
		BaseTOValidationUtil.validateIdNotNull( server );
	    TblServidores entity = this.tblServidoresRepository.findById( server.getPkIdServidor() )
	        .orElseThrow( SupplierBusinessException.IT_SERVICE_NOT_FOUND );
	    entity.setDsAmbiente(server.getDsAmbiente());
		entity.setDsCode(server.getDsCode());
		entity.setDsDescripcion(server.getDsDescripcion());
		entity.setDsHostName(server.getDsHostName());
		entity.setDsMarcaModelo(server.getDsMarcaModelo());
		entity.setDsName(server.getDsName());
		entity.setDsPci(server.getDsPci());
		entity.setDsProposito(server.getDsProposito());
		entity.setDsTipo(server.getDsTipo());
		entity.setDsVirtualizacion(server.getDsVirtualizacion());
		if(server.getFkIdResponsable()!=null) {
			TblActores actore = tblActorRepository.findById(server.getFkIdResponsable())
					.orElseThrow(SupplierBusinessException.ACTOR_NOT_FOUND);
			entity.setFkIdResponsable(actore);
		}
		if(server.getFkIdUbicacion()!=null) {
			TblUbicaciones ubicaciones = ubicacionesRepository.findById(server.getFkIdUbicacion())
					.orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND);
			entity.setFkIdUbicacion(ubicaciones);
		}
	    
		entity.setDsUserModification(server.getDsUserModification());
	    entity.setDtModified( Timestamp.valueOf(LocalDateTime.now()) );

	    this.tblServidoresRepository.save( entity );
	    this.tblServidoresRepository.flush();
		return true;
	}
}
