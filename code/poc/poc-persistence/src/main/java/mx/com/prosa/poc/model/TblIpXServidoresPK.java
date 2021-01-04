package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_IP_X_SERVIDORES database table.
 * 
 */
@Embeddable
public class TblIpXServidoresPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_IP")
	private long fkIdIp;

	@Column(name="FK_ID_SERVIDOR")
	private long fkIdServidor;

	public TblIpXServidoresPK() {
	}
	public long getFkIdIp() {
		return this.fkIdIp;
	}
	public void setFkIdIp(long fkIdIp) {
		this.fkIdIp = fkIdIp;
	}
	public long getFkIdServidor() {
		return this.fkIdServidor;
	}
	public void setFkIdServidor(long fkIdServidor) {
		this.fkIdServidor = fkIdServidor;
	}

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

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdIp ^ (this.fkIdIp >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServidor ^ (this.fkIdServidor >>> 32)));
		
		return hash;
	}
}