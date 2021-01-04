package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_BUSPROCESOS_X_ORG_PROC database table.
 * 
 */
@Embeddable
public class TblBusprocesosXOrgProcPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_PROCESO")
	private long fkIdProceso;

	@Column(name="FK_ID_PROCEDIMIENTO")
	private long fkIdProcedimiento;

	public TblBusprocesosXOrgProcPK() {
	}
	public long getFkIdProceso() {
		return this.fkIdProceso;
	}
	public void setFkIdProceso(long fkIdProceso) {
		this.fkIdProceso = fkIdProceso;
	}
	public long getFkIdProcedimiento() {
		return this.fkIdProcedimiento;
	}
	public void setFkIdProcedimiento(long fkIdProcedimiento) {
		this.fkIdProcedimiento = fkIdProcedimiento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblBusprocesosXOrgProcPK)) {
			return false;
		}
		TblBusprocesosXOrgProcPK castOther = (TblBusprocesosXOrgProcPK)other;
		return 
			(this.fkIdProceso == castOther.fkIdProceso)
			&& (this.fkIdProcedimiento == castOther.fkIdProcedimiento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdProceso ^ (this.fkIdProceso >>> 32)));
		hash = hash * prime + ((int) (this.fkIdProcedimiento ^ (this.fkIdProcedimiento >>> 32)));
		
		return hash;
	}
}