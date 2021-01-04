package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_ACTIVIDADES_X_SERVICIO database table.
 * 
 */
@Entity
@Table(name="TBL_ACTIVIDADES_X_SERVICIO")
@NamedQuery(name="TblActividadesXServicio.findAll", query="SELECT t FROM TblActividadesXServicio t")
public class TblActividadesXServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblActividadesXServicioPK id;

	public TblActividadesXServicio() {
	}

	public TblActividadesXServicioPK getId() {
		return this.id;
	}

	public void setId(TblActividadesXServicioPK id) {
		this.id = id;
	}

}