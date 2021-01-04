package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_MARCAS database table.
 * 
 */
@Entity
@Table(name="TBL_MARCAS")
@NamedQuery(name="TblMarcas.findAll", query="SELECT t FROM TblMarcas t")
public class TblMarcas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_MARCA")
	private long pkIdMarca;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	public TblMarcas() {
	}

	public long getPkIdMarca() {
		return this.pkIdMarca;
	}

	public void setPkIdMarca(long pkIdMarca) {
		this.pkIdMarca = pkIdMarca;
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

}