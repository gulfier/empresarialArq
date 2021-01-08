package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_IP_X_SERVIDORES database table.
 * 
 */
public class TblIpXServidoresPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4893550957062722084L;

	/** The fk id ip. */
	@Column(name="FK_ID_IP", nullable = false)
	private Long fkIdIp;

	/** The fk id servidor. */
	@Column(name="FK_ID_SERVIDOR", nullable = false)
	private Long fkIdServidor;

	/**
	 * Instantiates a new tbl ip X servidores PK.
	 */
	public TblIpXServidoresPK() {
	}
	
	/**
	 * Gets the fk id ip.
	 *
	 * @return the fk id ip
	 */
	public Long getFkIdIp() {
		return this.fkIdIp;
	}
	
	/**
	 * Sets the fk id ip.
	 *
	 * @param fkIdIp the new fk id ip
	 */
	public void setFkIdIp(Long fkIdIp) {
		this.fkIdIp = fkIdIp;
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
		if (!(other instanceof TblIpXServidoresPK)) {
			return false;
		}
		TblIpXServidoresPK castOther = (TblIpXServidoresPK)other;
		return 
			(this.fkIdIp == castOther.fkIdIp)
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
		hash = hash * prime + ((int) (this.fkIdIp ^ (this.fkIdIp >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServidor ^ (this.fkIdServidor >>> 32)));
		
		return hash;
	}
}