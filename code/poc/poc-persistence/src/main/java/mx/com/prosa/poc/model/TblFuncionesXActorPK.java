package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_FUNCIONES_X_ACTOR database table.
 * 
 */
@Embeddable
public class TblFuncionesXActorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_FUNCION")
	private long fkIdFuncion;

	@Column(name="FK_ID_ROL")
	private long fkIdRol;

	public TblFuncionesXActorPK() {
	}
	public long getFkIdFuncion() {
		return this.fkIdFuncion;
	}
	public void setFkIdFuncion(long fkIdFuncion) {
		this.fkIdFuncion = fkIdFuncion;
	}
	public long getFkIdRol() {
		return this.fkIdRol;
	}
	public void setFkIdRol(long fkIdRol) {
		this.fkIdRol = fkIdRol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblFuncionesXActorPK)) {
			return false;
		}
		TblFuncionesXActorPK castOther = (TblFuncionesXActorPK)other;
		return 
			(this.fkIdFuncion == castOther.fkIdFuncion)
			&& (this.fkIdRol == castOther.fkIdRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdFuncion ^ (this.fkIdFuncion >>> 32)));
		hash = hash * prime + ((int) (this.fkIdRol ^ (this.fkIdRol >>> 32)));
		
		return hash;
	}
}