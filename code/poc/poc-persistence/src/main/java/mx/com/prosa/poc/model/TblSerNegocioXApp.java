package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_SER_NEGOCIO_X_APPS database table.
 * 
 */
@Entity
@Table(name="TBL_SER_NEGOCIO_X_APPS")
@NamedQuery(name="TblSerNegocioXApp.findAll", query="SELECT t FROM TblSerNegocioXApp t")
public class TblSerNegocioXApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblSerNegocioXAppPK id;

	public TblSerNegocioXApp() {
	}

	public TblSerNegocioXAppPK getId() {
		return this.id;
	}

	public void setId(TblSerNegocioXAppPK id) {
		this.id = id;
	}

}