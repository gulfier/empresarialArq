package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_APP_X_BASE_DATOS database table.
 * 
 */
@Entity
@Table(name="TBL_APP_X_BASE_DATOS")
@NamedQuery(name="TblAppXBaseDatos.findAll", query="SELECT t FROM TblAppXBaseDatos t")
public class TblAppXBaseDatos implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblAppXBaseDatosPK id;

	public TblAppXBaseDatos() {
	}

	public TblAppXBaseDatosPK getId() {
		return this.id;
	}

	public void setId(TblAppXBaseDatosPK id) {
		this.id = id;
	}

}