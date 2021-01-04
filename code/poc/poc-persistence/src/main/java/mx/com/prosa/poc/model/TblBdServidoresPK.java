package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TBL_BD_SERVIDORES database table.
 * 
 */
@Embeddable
public class TblBdServidoresPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FK_ID_BASE_DATOS")
	private long fkIdBaseDatos;

	@Column(name="FK_ID_SERVIDOR")
	private long fkIdServidor;

	public TblBdServidoresPK() {
	}
	public long getFkIdBaseDatos() {
		return this.fkIdBaseDatos;
	}
	public void setFkIdBaseDatos(long fkIdBaseDatos) {
		this.fkIdBaseDatos = fkIdBaseDatos;
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
		if (!(other instanceof TblBdServidoresPK)) {
			return false;
		}
		TblBdServidoresPK castOther = (TblBdServidoresPK)other;
		return 
			(this.fkIdBaseDatos == castOther.fkIdBaseDatos)
			&& (this.fkIdServidor == castOther.fkIdServidor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fkIdBaseDatos ^ (this.fkIdBaseDatos >>> 32)));
		hash = hash * prime + ((int) (this.fkIdServidor ^ (this.fkIdServidor >>> 32)));
		
		return hash;
	}
}