package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblMarcas;
import mx.com.prosa.poc.model.TblSoftwareComercial;
import mx.com.prosa.poc.persistence.TblMarcasRepository;
import mx.com.prosa.poc.persistence.TblSoftwareComercialRepository;
import mx.com.prosa.poc.service.SoftwareComercialService;
import mx.com.prosa.poc.to.SoftwareComercialTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class SoftwareComercialImpl.
 */
@Service
public class SoftwareComercialImpl implements SoftwareComercialService {

	/** The tbl software comercial. */
	@Autowired
	private TblSoftwareComercialRepository tblSoftwareComercial;
	
	/** The tbl marcas repository. */
	@Autowired
	private TblMarcasRepository tblMarcasRepository;
	
	/**
	 * Save.
	 *
	 * @param software the software
	 */
	@Override
	public void save(SoftwareComercialTO software) {
		TblSoftwareComercial entity = new TblSoftwareComercial();
		entity.setPkIdSoftware(software.getPkIdSoftware());
		entity.setDsNombre(software.getDsNombre());
		entity.setDsTipo(software.getDsTipo());
		entity.setDsVersion(software.getDsVersion());
		
		TblMarcas marca = tblMarcasRepository.findById(software.getFkIdMarca())
					.orElseThrow(SupplierBusinessException.BRAND_NOT_FOUND);
		
		entity.setFkIdMarca(marca);
		tblSoftwareComercial.save(entity);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblSoftwareComercial.delete(tblSoftwareComercial.
				findById(id).orElseThrow(SupplierBusinessException.SOFTWARE_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param software the software
	 * @return the boolean
	 */
	@Override
	public Boolean edit(SoftwareComercialTO software) {
		BaseTOValidationUtil.validateIdNotNull( software );
		TblSoftwareComercial entity = this.tblSoftwareComercial.findById( software.getPkIdSoftware() )
	        .orElseThrow( SupplierBusinessException.SOFTWARE_NOT_FOUND );
		entity.setDsNombre(software.getDsNombre());
		entity.setDsTipo(software.getDsTipo());
		entity.setDsVersion(software.getDsVersion());
		
		if(software.getFkIdMarca()!=null) {
			TblMarcas marca = tblMarcasRepository.findById(software.getFkIdMarca())
						.orElseThrow(SupplierBusinessException.BRAND_NOT_FOUND);
			entity.setFkIdMarca(marca);
		}

	    this.tblSoftwareComercial.save( entity );
	    this.tblSoftwareComercial.flush();
		return true;
	}
}
