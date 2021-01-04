package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_BUSPROCESOS_X_ORG_PROC database table.
 * 
 */
@Entity
@Table(name="TBL_BUSPROCESOS_X_ORG_PROC")
@NamedQuery(name="TblBusprocesosXOrgProc.findAll", query="SELECT t FROM TblBusprocesosXOrgProc t")
public class TblBusprocesosXOrgProc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblBusprocesosXOrgProcPK id;

	public TblBusprocesosXOrgProc() {
	}

	public TblBusprocesosXOrgProcPK getId() {
		return this.id;
	}

	public void setId(TblBusprocesosXOrgProcPK id) {
		this.id = id;
	}

}