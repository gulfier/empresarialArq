package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_APPS_X_SERV_APP database table.
 * 
 */
@Embeddable
public class TblAppsXServAppPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	@Column(name="FK_ID_SERVICIO")
	private long fkIdServicio;

	public TblAppsXServAppPK() {
	}
	public long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}
	public long getFkIdServicio() {
		return this.fkIdServicio;
	}
	public void setFkIdServicio(long fkIdServicio) {
		this.fkIdServicio = fkIdServicio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblAppsXServAppPK)) {
			return false;
		}
		TblAppsXServAppPK castOther = (TblAppsXServAppPK)other;
		return 
			(this.fkIdAplicacion == castOther.fkIdAplicacion)
			&& (this.fkIdServicio == castOther.fkIdServicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServicio ^ (this.fkIdServicio >>> 32)));
		
		return hash;
	}
}