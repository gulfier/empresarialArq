package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_SOFTWARESCOM_X_SERVIDOR database table.
 * 
 */
@Embeddable
public class TblSoftwarescomXServidorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_SOFTWARE")
	private long fkIdSoftware;

	@Column(name="FK_ID_SERVER")
	private long fkIdServer;

	public TblSoftwarescomXServidorPK() {
	}
	public long getFkIdSoftware() {
		return this.fkIdSoftware;
	}
	public void setFkIdSoftware(long fkIdSoftware) {
		this.fkIdSoftware = fkIdSoftware;
	}
	public long getFkIdServer() {
		return this.fkIdServer;
	}
	public void setFkIdServer(long fkIdServer) {
		this.fkIdServer = fkIdServer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblSoftwarescomXServidorPK)) {
			return false;
		}
		TblSoftwarescomXServidorPK castOther = (TblSoftwarescomXServidorPK)other;
		return 
			(this.fkIdSoftware == castOther.fkIdSoftware)
			&& (this.fkIdServer == castOther.fkIdServer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdSoftware ^ (this.fkIdSoftware >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServer ^ (this.fkIdServer >>> 32)));
		
		return hash;
	}
}