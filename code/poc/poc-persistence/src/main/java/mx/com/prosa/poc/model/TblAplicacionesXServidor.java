package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_APLICACIONES_X_SERVIDOR database table.
 * 
 */
@Entity
@Table(name="TBL_APLICACIONES_X_SERVIDOR")
@NamedQuery(name="TblAplicacionesXServidor.findAll", query="SELECT t FROM TblAplicacionesXServidor t")
public class TblAplicacionesXServidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblAplicacionesXServidorPK id;

	public TblAplicacionesXServidor() {
	}

	public TblAplicacionesXServidorPK getId() {
		return this.id;
	}

	public void setId(TblAplicacionesXServidorPK id) {
		this.id = id;
	}

}