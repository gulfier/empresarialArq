package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_ACT_X_PROCEDIMIENTOS database table.
 * 
 */
@Embeddable
public class TblActXProcedimientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_PROCEDIMIENTO")
	private long fkProcedimiento;

	@Column(name="FK_ID_ACTIVIDAD")
	private long fkIdActividad;

	public TblActXProcedimientoPK() {
	}
	public long getFkProcedimiento() {
		return this.fkProcedimiento;
	}
	public void setFkProcedimiento(long fkProcedimiento) {
		this.fkProcedimiento = fkProcedimiento;
	}
	public long getFkIdActividad() {
		return this.fkIdActividad;
	}
	public void setFkIdActividad(long fkIdActividad) {
		this.fkIdActividad = fkIdActividad;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblActXProcedimientoPK)) {
			return false;
		}
		TblActXProcedimientoPK castOther = (TblActXProcedimientoPK)other;
		return 
			(this.fkProcedimiento == castOther.fkProcedimiento)
			&& (this.fkIdActividad == castOther.fkIdActividad);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkProcedimiento ^ (this.fkProcedimiento >>> 32)));
		hash = hash * prime + ((int) (this.fkIdActividad ^ (this.fkIdActividad >>> 32)));
		
		return hash;
	}
}