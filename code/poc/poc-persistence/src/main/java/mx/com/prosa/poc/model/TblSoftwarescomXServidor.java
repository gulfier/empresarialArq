package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_SOFTWARESCOM_X_SERVIDOR database table.
 * 
 */
@Entity
@Table(name="TBL_SOFTWARESCOM_X_SERVIDOR")
@NamedQuery(name="TblSoftwarescomXServidor.findAll", query="SELECT t FROM TblSoftwarescomXServidor t")
public class TblSoftwarescomXServidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblSoftwarescomXServidorPK id;

	public TblSoftwarescomXServidor() {
	}

	public TblSoftwarescomXServidorPK getId() {
		return this.id;
	}

	public void setId(TblSoftwarescomXServidorPK id) {
		this.id = id;
	}

}