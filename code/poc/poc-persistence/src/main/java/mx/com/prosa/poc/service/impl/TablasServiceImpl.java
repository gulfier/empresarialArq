package mx.com.prosa.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.model.TblTablas;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblTablasRepository;
import mx.com.prosa.poc.service.TablasService;
import mx.com.prosa.poc.to.TablasTO;
import mx.com.prosa.poc.util.BaseTOValidationUtil;
import mx.com.prosa.poc.util.SupplierBusinessException;

/**
 * The Class TablasServiceImpl.
 */
@Service
public class TablasServiceImpl implements TablasService {

	/** The tbl tablas repository. */
	@Autowired
	private TblTablasRepository tblTablasRepository;
	
	/** The tbl base datos repository. */
	@Autowired
	private TblBaseDatosRepository tblBaseDatosRepository;
	
	/**
	 * Save.
	 *
	 * @param tablas the tablas
	 */
	@Override
	public void save(TablasTO tablas) {
		TblTablas entity = new TblTablas();
		entity.setDsTabla(tablas.getDsTabla());
		TblBaseDatos base = tblBaseDatosRepository.findById(tablas.getFkIdBase())
				.orElseThrow(SupplierBusinessException.DATA_BASE_NOT_FOUND);
		entity.setFkIdBase(base);
		entity.setPkIdTabla(tablas.getPkIdTabla());
		tblTablasRepository.save(entity);
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Override
	public Boolean delete(Long id) {
		tblTablasRepository.delete(tblTablasRepository.
				findById(id).orElseThrow(SupplierBusinessException.LOCATION_NOT_FOUND));
		return true;
	}
	
	/**
	 * Edits the.
	 *
	 * @param table the table
	 * @return the boolean
	 */
	@Override
	public Boolean edit(TablasTO table) {
		BaseTOValidationUtil.validateIdNotNull( table );
	    TblTablas entity = this.tblTablasRepository.findById( table.getId() )
	        .orElseThrow( SupplierBusinessException.TABLE_NOT_FOUND );
	    entity.setDsTabla(table.getDsTabla());
	    if(table.getFkIdBase()!=null) {
	    	Optional<TblBaseDatos> base = tblBaseDatosRepository.findById(table.getFkIdBase());
	    	if(base.isPresent()) {
	    		entity.setFkIdBase(base.get());
	    	}
	    }

	    this.tblTablasRepository.save( entity );
	    this.tblTablasRepository.flush();
		return true;
	}
	
}
