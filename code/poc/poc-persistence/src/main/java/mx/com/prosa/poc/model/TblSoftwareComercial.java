package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_SOFTWARE_COMERCIAL database table.
 * 
 */
@Entity
@Table(name="TBL_SOFTWARE_COMERCIAL")
@NamedQuery(name="TblSoftwareComercial.findAll", query="SELECT t FROM TblSoftwareComercial t")
public class TblSoftwareComercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_SOFTWARE")
	private String pkIdSoftware;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@Column(name="DS_VERSION")
	private String dsVersion;

	@Column(name="FK_ID_MARCA")
	private BigDecimal fkIdMarca;

	public TblSoftwareComercial() {
	}

	public String getPkIdSoftware() {
		return this.pkIdSoftware;
	}

	public void setPkIdSoftware(String pkIdSoftware) {
		this.pkIdSoftware = pkIdSoftware;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsTipo() {
		return this.dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public String getDsVersion() {
		return this.dsVersion;
	}

	public void setDsVersion(String dsVersion) {
		this.dsVersion = dsVersion;
	}

	public BigDecimal getFkIdMarca() {
		return this.fkIdMarca;
	}

	public void setFkIdMarca(BigDecimal fkIdMarca) {
		this.fkIdMarca = fkIdMarca;
	}

}