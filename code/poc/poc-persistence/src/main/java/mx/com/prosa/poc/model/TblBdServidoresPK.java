package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_BD_SERVIDORES database table.
 * 
 */
public class TblBdServidoresPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	/** The fk id base datos. */
	@Column(name="FK_ID_BASE_DATOS", nullable = false)
	private Long fkIdBaseDatos;

	/** The fk id servidor. */
	@Column(name="FK_ID_SERVIDOR", nullable = false)
	private Long fkIdServidor;

	/**
	 * Instantiates a new tbl bd servidores PK.
	 */
	public TblBdServidoresPK() {
	}
	
	/**
	 * Gets the fk id base datos.
	 *
	 * @return the fk id base datos
	 */
	public Long getFkIdBaseDatos() {
		return this.fkIdBaseDatos;
	}
	
	/**
	 * Sets the fk id base datos.
	 *
	 * @param fkIdBaseDatos the new fk id base datos
	 */
	public void setFkIdBaseDatos(Long fkIdBaseDatos) {
		this.fkIdBaseDatos = fkIdBaseDatos;
	}
	
	/**
	 * Gets the fk id servidor.
	 *
	 * @return the fk id servidor
	 */
	public Long getFkIdServidor() {
		return this.fkIdServidor;
	}
	
	/**
	 * Sets the fk id servidor.
	 *
	 * @param fkIdServidor the new fk id servidor
	 */
	public void setFkIdServidor(Long fkIdServidor) {
		this.fkIdServidor = fkIdServidor;
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
		if (!(other instanceof TblBdServidoresPK)) {
			return false;
		}
		TblBdServidoresPK castOther = (TblBdServidoresPK)other;
		return 
			(this.fkIdBaseDatos == castOther.fkIdBaseDatos)
			&& (this.fkIdServidor == castOther.fkIdServidor);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdBaseDatos ^ (this.fkIdBaseDatos >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServidor ^ (this.fkIdServidor >>> 32)));
		
		return hash;
	}
}