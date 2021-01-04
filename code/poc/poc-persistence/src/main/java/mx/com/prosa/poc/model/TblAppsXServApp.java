package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_APPS_X_SERV_APP database table.
 * 
 */
@Entity
@Table(name="TBL_APPS_X_SERV_APP")
@NamedQuery(name="TblAppsXServApp.findAll", query="SELECT t FROM TblAppsXServApp t")
public class TblAppsXServApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblAppsXServAppPK id;

	public TblAppsXServApp() {
	}

	public TblAppsXServAppPK getId() {
		return this.id;
	}

	public void setId(TblAppsXServAppPK id) {
		this.id = id;
	}

}