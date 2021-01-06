package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.prosa.poc.model.TblBaseDatos;
import mx.com.prosa.poc.model.TblTablas;
import mx.com.prosa.poc.persistence.TblBaseDatosRepository;
import mx.com.prosa.poc.persistence.TblTablasRepository;
import mx.com.prosa.poc.service.TablasService;
import mx.com.prosa.poc.to.TablasTO;
import mx.com.prosa.poc.util.SupplierBusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class TablasServiceImpl.
 */
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
}
