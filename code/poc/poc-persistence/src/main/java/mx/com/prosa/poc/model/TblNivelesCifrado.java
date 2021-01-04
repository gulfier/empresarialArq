package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_NIVELES_CIFRADO database table.
 * 
 */
@Entity
@Table(name="TBL_NIVELES_CIFRADO")
@NamedQuery(name="TblNivelesCifrado.findAll", query="SELECT t FROM TblNivelesCifrado t")
public class TblNivelesCifrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_CIFRADO")
	private long pkIdCifrado;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	public TblNivelesCifrado() {
	}

	public long getPkIdCifrado() {
		return this.pkIdCifrado;
	}

	public void setPkIdCifrado(long pkIdCifrado) {
		this.pkIdCifrado = pkIdCifrado;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

}