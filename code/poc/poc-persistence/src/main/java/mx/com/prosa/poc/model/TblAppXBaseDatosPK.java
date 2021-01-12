package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_APP_X_BASE_DATOS database table.
 * 
 */
public class TblAppXBaseDatosPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3182145542051338456L;

	/** The fk id aplicacion. */
	@Column(name="FK_ID_APLICACION")
	private Long fkIdAplicacion;

	/** The fk id base. */
	@Column(name="FK_ID_BASE")
	private Long fkIdBase;

	/**
	 * Instantiates a new tbl app X base datos PK.
	 */
	public TblAppXBaseDatosPK() {
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
	 * Gets the fk id base.
	 *
	 * @return the fk id base
	 */
	public Long getFkIdBase() {
		return this.fkIdBase;
	}
	
	/**
	 * Sets the fk id base.
	 *
	 * @param fkIdBase the new fk id base
	 */
	public void setFkIdBase(Long fkIdBase) {
		this.fkIdBase = fkIdBase;
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
		if (!(other instanceof TblAppXBaseDatosPK)) {
			return false;
		}
		TblAppXBaseDatosPK castOther = (TblAppXBaseDatosPK)other;
		return 
			(this.fkIdAplicacion == castOther.fkIdAplicacion)
			&& (this.fkIdBase == castOther.fkIdBase);
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
		hash = hash * prime + ((int) (this.fkIdBase ^ (this.fkIdBase >>> 32)));
		
		return hash;
	}
}