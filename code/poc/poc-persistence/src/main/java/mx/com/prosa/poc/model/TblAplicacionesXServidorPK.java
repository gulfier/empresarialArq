package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_APLICACIONES_X_SERVIDOR database table.
 * 
 */
@Embeddable
public class TblAplicacionesXServidorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_SERVIDOR")
	private long fkIdServidor;

	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	public TblAplicacionesXServidorPK() {
	}
	public long getFkIdServidor() {
		return this.fkIdServidor;
	}
	public void setFkIdServidor(long fkIdServidor) {
		this.fkIdServidor = fkIdServidor;
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
		if (!(other instanceof TblAplicacionesXServidorPK)) {
			return false;
		}
		TblAplicacionesXServidorPK castOther = (TblAplicacionesXServidorPK)other;
		return 
			(this.fkIdServidor == castOther.fkIdServidor)
			&& (this.fkIdAplicacion == castOther.fkIdAplicacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdServidor ^ (this.fkIdServidor >>> 32)));
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		
		return hash;
	}
}