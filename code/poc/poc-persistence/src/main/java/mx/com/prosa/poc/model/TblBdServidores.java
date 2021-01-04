package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_BD_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_BD_SERVIDORES")
@NamedQuery(name="TblBdServidores.findAll", query="SELECT t FROM TblBdServidores t")
public class TblBdServidores implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblBdServidoresPK id;

	public TblBdServidores() {
	}

	public TblBdServidoresPK getId() {
		return this.id;
	}

	public void setId(TblBdServidoresPK id) {
		this.id = id;
	}

}