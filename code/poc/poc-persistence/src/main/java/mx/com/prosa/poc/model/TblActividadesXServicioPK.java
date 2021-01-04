package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_ACTIVIDADES_X_SERVICIO database table.
 * 
 */
@Embeddable
public class TblActividadesXServicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_ACTIVIDAD")
	private long fkIdActividad;

	@Column(name="FK_ID_SERVICIO")
	private long fkIdServicio;

	public TblActividadesXServicioPK() {
	}
	public long getFkIdActividad() {
		return this.fkIdActividad;
	}
	public void setFkIdActividad(long fkIdActividad) {
		this.fkIdActividad = fkIdActividad;
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
		if (!(other instanceof TblActividadesXServicioPK)) {
			return false;
		}
		TblActividadesXServicioPK castOther = (TblActividadesXServicioPK)other;
		return 
			(this.fkIdActividad == castOther.fkIdActividad)
			&& (this.fkIdServicio == castOther.fkIdServicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdActividad ^ (this.fkIdActividad >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServicio ^ (this.fkIdServicio >>> 32)));
		
		return hash;
	}
}