package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_IP_X_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_IP_X_SERVIDORES")
@NamedQuery(name="TblIpXServidores.findAll", query="SELECT t FROM TblIpXServidores t")
public class TblIpXServidores implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblIpXServidoresPK id;

	public TblIpXServidores() {
	}

	public TblIpXServidoresPK getId() {
		return this.id;
	}

	public void setId(TblIpXServidoresPK id) {
		this.id = id;
	}

}