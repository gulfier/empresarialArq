package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_APP_X_BASE_DATOS database table.
 * 
 */
@Embeddable
public class TblAppXBaseDatosPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	@Column(name="FK_ID_BASE")
	private long fkIdBase;

	public TblAppXBaseDatosPK() {
	}
	public long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}
	public long getFkIdBase() {
		return this.fkIdBase;
	}
	public void setFkIdBase(long fkIdBase) {
		this.fkIdBase = fkIdBase;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblAppXBaseDatosPK)) {
			return false;
		}
		TblAppXBaseDatosPK castOther = (TblAppXBaseDatosPK)other;
		return 
			(this.fkIdAplicacion == castOther.fkIdAplicacion)
			&& (this.fkIdBase == castOther.fkIdBase);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		hash = hash * prime + ((int) (this.fkIdBase ^ (this.fkIdBase >>> 32)));
		
		return hash;
	}
}