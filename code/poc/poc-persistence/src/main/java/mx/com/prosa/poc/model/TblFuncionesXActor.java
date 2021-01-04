package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_FUNCIONES_X_ACTOR database table.
 * 
 */
@Entity
@Table(name="TBL_FUNCIONES_X_ACTOR")
@NamedQuery(name="TblFuncionesXActor.findAll", query="SELECT t FROM TblFuncionesXActor t")
public class TblFuncionesXActor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblFuncionesXActorPK id;

	public TblFuncionesXActor() {
	}

	public TblFuncionesXActorPK getId() {
		return this.id;
	}

	public void setId(TblFuncionesXActorPK id) {
		this.id = id;
	}

}