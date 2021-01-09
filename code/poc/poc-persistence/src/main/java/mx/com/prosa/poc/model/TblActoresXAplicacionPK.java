package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_ACTORES_X_APLICACION database table.
 * 
 */
public class TblActoresXAplicacionPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	/** The fk id actor. */
	@Column(name="FK_ID_ACTOR")
	private long fkIdActor;

	/** The fk id aplicacion. */
	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;

	/**
	 * Instantiates a new tbl actores X aplicacion PK.
	 */
	public TblActoresXAplicacionPK() {
	}
	
	/**
	 * Gets the fk id actor.
	 *
	 * @return the fk id actor
	 */
	public long getFkIdActor() {
		return this.fkIdActor;
	}
	
	/**
	 * Sets the fk id actor.
	 *
	 * @param fkIdActor the new fk id actor
	 */
	public void setFkIdActor(long fkIdActor) {
		this.fkIdActor = fkIdActor;
	}
	
	/**
	 * Gets the fk id aplicacion.
	 *
	 * @return the fk id aplicacion
	 */
	public long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	
	/**
	 * Sets the fk id aplicacion.
	 *
	 * @param fkIdAplicacion the new fk id aplicacion
	 */
	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
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
		if (!(other instanceof TblActoresXAplicacionPK)) {
			return false;
		}
		TblActoresXAplicacionPK castOther = (TblActoresXAplicacionPK)other;
		return 
			(this.fkIdActor == castOther.fkIdActor)
			&& (this.fkIdAplicacion == castOther.fkIdAplicacion);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdActor ^ (this.fkIdActor >>> 32)));
		hash = hash * prime + ((int) (this.fkIdAplicacion ^ (this.fkIdAplicacion >>> 32)));
		
		return hash;
	}
}