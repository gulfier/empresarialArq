package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_ACTORES_X_APLICACION database table.
 * 
 */
@Embeddable
public class TblActoresXAplicacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_ACTOR")
	private long fkIdActor;

	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	public TblActoresXAplicacionPK() {
	}
	public long getFkIdActor() {
		return this.fkIdActor;
	}
	public void setFkIdActor(long fkIdActor) {
		this.fkIdActor = fkIdActor;
	}
	public long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblActoresXAplicacionPK)) {
			return false;
		}
		TblActoresXAplicacionPK castOther = (TblActoresXAplicacionPK)other;
		return 
			(this.fkIdActor == castOther.fkIdActor)
			&& (this.fkIdAplicacion == castOther.fkIdAplicacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdActor ^ (this.fkIdActor >>> 32)));
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		
		return hash;
	}
}