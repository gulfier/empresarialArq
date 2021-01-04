package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_SER_NEGOCIO_X_APPS database table.
 * 
 */
@Embeddable
public class TblSerNegocioXAppPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_SERVICIO_NEGOCIO")
	private long fkIdServicioNegocio;

	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	public TblSerNegocioXAppPK() {
	}
	public long getFkIdServicioNegocio() {
		return this.fkIdServicioNegocio;
	}
	public void setFkIdServicioNegocio(long fkIdServicioNegocio) {
		this.fkIdServicioNegocio = fkIdServicioNegocio;
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
		if (!(other instanceof TblSerNegocioXAppPK)) {
			return false;
		}
		TblSerNegocioXAppPK castOther = (TblSerNegocioXAppPK)other;
		return 
			(this.fkIdServicioNegocio == castOther.fkIdServicioNegocio)
			&& (this.fkIdAplicacion == castOther.fkIdAplicacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdServicioNegocio ^ (this.fkIdServicioNegocio >>> 32)));
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		
		return hash;
	}
}