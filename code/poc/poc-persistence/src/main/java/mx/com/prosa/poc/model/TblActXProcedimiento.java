package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_ACT_X_PROCEDIMIENTOS database table.
 * 
 */
@Entity
@Table(name="TBL_ACT_X_PROCEDIMIENTOS")
@NamedQuery(name="TblActXProcedimiento.findAll", query="SELECT t FROM TblActXProcedimiento t")
public class TblActXProcedimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblActXProcedimientoPK id;

	public TblActXProcedimiento() {
	}

	public TblActXProcedimientoPK getId() {
		return this.id;
	}

	public void setId(TblActXProcedimientoPK id) {
		this.id = id;
	}

}