package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_SOFTWARE_COMERCIAL database table.
 * 
 */
@Entity
@Table(name="TBL_SOFTWARE_COMERCIAL")
public class TblSoftwareComercial implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pk id software. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_SOFTWARE")
	private Long pkIdSoftware;

	/** The ds nombre. */
	@Column(name="DS_NOMBRE")
	private String dsNombre;

	/** The ds tipo. */
	@Column(name="DS_TIPO")
	private String dsTipo;

	/** The ds version. */
	@Column(name="DS_VERSION")
	private String dsVersion;

	/** The fk id marca. */
	@Column(name="FK_ID_MARCA")
	private TblMarcas fkIdMarca;

	/**
	 * Instantiates a new tbl software comercial.
	 */
	public TblSoftwareComercial() {
	}

	/**
	 * Gets the pk id software.
	 *
	 * @return the pk id software
	 */
	public Long getPkIdSoftware() {
		return this.pkIdSoftware;
	}

	/**
	 * Sets the pk id software.
	 *
	 * @param pkIdSoftware the new pk id software
	 */
	public void setPkIdSoftware(Long pkIdSoftware) {
		this.pkIdSoftware = pkIdSoftware;
	}

	/**
	 * Gets the ds nombre.
	 *
	 * @return the ds nombre
	 */
	public String getDsNombre() {
		return this.dsNombre;
	}

	/**
	 * Sets the ds nombre.
	 *
	 * @param dsNombre the new ds nombre
	 */
	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	/**
	 * Gets the ds tipo.
	 *
	 * @return the ds tipo
	 */
	public String getDsTipo() {
		return this.dsTipo;
	}

	/**
	 * Sets the ds tipo.
	 *
	 * @param dsTipo the new ds tipo
	 */
	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	/**
	 * Gets the ds version.
	 *
	 * @return the ds version
	 */
	public String getDsVersion() {
		return this.dsVersion;
	}

	/**
	 * Sets the ds version.
	 *
	 * @param dsVersion the new ds version
	 */
	public void setDsVersion(String dsVersion) {
		this.dsVersion = dsVersion;
	}

	/**
	 * Gets the fk id marca.
	 *
	 * @return the fk id marca
	 */
	public TblMarcas getFkIdMarca() {
		return this.fkIdMarca;
	}

	/**
	 * Sets the fk id marca.
	 *
	 * @param fkIdMarca the new fk id marca
	 */
	public void setFkIdMarca(TblMarcas fkIdMarca) {
		this.fkIdMarca = fkIdMarca;
	}

}