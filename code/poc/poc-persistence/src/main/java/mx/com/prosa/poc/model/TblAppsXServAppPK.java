package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_APPS_X_SERV_APP database table.
 * 
 */
public class TblAppsXServAppPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8510434032679110757L;

	/** The fk id aplicacion. */
	@Column(name="FK_ID_APLICACION")
	private Long fkIdAplicacion;

	/** The fk id servicio. */
	@Column(name="FK_ID_SERVICIO")
	private Long fkIdServicio;

	/**
	 * Instantiates a new tbl apps X serv app PK.
	 */
	public TblAppsXServAppPK() {
	}
	
	/**
	 * Gets the fk id aplicacion.
	 *
	 * @return the fk id aplicacion
	 */
	public Long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	
	/**
	 * Sets the fk id aplicacion.
	 *
	 * @param fkIdAplicacion the new fk id aplicacion
	 */
	public void setFkIdAplicacion(Long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}
	
	/**
	 * Gets the fk id servicio.
	 *
	 * @return the fk id servicio
	 */
	public Long getFkIdServicio() {
		return this.fkIdServicio;
	}
	
	/**
	 * Sets the fk id servicio.
	 *
	 * @param fkIdServicio the new fk id servicio
	 */
	public void setFkIdServicio(Long fkIdServicio) {
		this.fkIdServicio = fkIdServicio;
	}

	/**
	 * Equals.
	 *
	 * @param other the other
	 * @return true, if successful
	 */
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

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServicio ^ (this.fkIdServicio >>> 32)));
		
		return hash;
	}
}