package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_ACTORES_X_APLICACION database table.
 * 
 */
@Entity
@Table(name="TBL_ACTORES_X_APLICACION")
@NamedQuery(name="TblActoresXAplicacion.findAll", query="SELECT t FROM TblActoresXAplicacion t")
public class TblActoresXAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblActoresXAplicacionPK id;

	public TblActoresXAplicacion() {
	}

	public TblActoresXAplicacionPK getId() {
		return this.id;
	}

	public void setId(TblActoresXAplicacionPK id) {
		this.id = id;
	}

}