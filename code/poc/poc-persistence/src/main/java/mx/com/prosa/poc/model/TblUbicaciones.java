package mx.com.prosa.poc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_UBICACIONES database table.
 * 
 */
@Entity
@Table(name="TBL_UBICACIONES")
@NamedQuery(name="TblUbicaciones.findAll", query="SELECT t FROM TblUbicaciones t")
public class TblUbicaciones implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -423571826954153084L;

	/** The pk id ubicacion. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_UBICACION")
	private long pkIdUbicacion;

	/** The ds ciudad. */
	@Column(name="DS_CIUDAD")
	private String dsCiudad;

	/** The ds code. */
	@Column(name="DS_CODE")
	private String dsCode;

	/** The ds descripcion. */
	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	/** The ds direccion. */
	@Column(name="DS_DIRECCION")
	private String dsDireccion;

	/** The ds estado. */
	@Column(name="DS_ESTADO")
	private String dsEstado;

	/** The ds name. */
	@Column(name="DS_NAME")
	private String dsName;

	/** The ds nombre. */
	@Column(name="DS_NOMBRE")
	private String dsNombre;

	/** The ds pais. */
	@Column(name="DS_PAIS")
	private String dsPais;

	/** The ds pci. */
	@Column(name="DS_PCI")
	private String dsPci;

	/** The ds tipo. */
	@Column(name="DS_TIPO")
	private String dsTipo;

	/** The ds user creation. */
	@Column(name="DS_USER_CREATION")
	private String dsUserCreation;

	/** The ds user modification. */
	@Column(name="DS_USER_MODIFICATION")
	private String dsUserModification;

	/** The dt creation. */
	@Column(name="DT_CREATION")
	private Timestamp dtCreation;

	/** The dt modified. */
	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;

	/** The fk id responsable. */
	@ManyToOne
	@JoinColumn(name="FK_ID_RESPONSABLE", referencedColumnName = "PK_ID_ACTOR", nullable = false, insertable = true, updatable = true)
	private TblActores fkIdResponsable;

	/**
	 * Instantiates a new tbl ubicaciones.
	 */
	public TblUbicaciones() {
	}

	/**
	 * Gets the pk id ubicacion.
	 *
	 * @return the pk id ubicacion
	 */
	public long getPkIdUbicacion() {
		return this.pkIdUbicacion;
	}

	/**
	 * Sets the pk id ubicacion.
	 *
	 * @param pkIdUbicacion the new pk id ubicacion
	 */
	public void setPkIdUbicacion(long pkIdUbicacion) {
		this.pkIdUbicacion = pkIdUbicacion;
	}

	/**
	 * Gets the ds ciudad.
	 *
	 * @return the ds ciudad
	 */
	public String getDsCiudad() {
		return this.dsCiudad;
	}

	/**
	 * Sets the ds ciudad.
	 *
	 * @param dsCiudad the new ds ciudad
	 */
	public void setDsCiudad(String dsCiudad) {
		this.dsCiudad = dsCiudad;
	}

	/**
	 * Gets the ds code.
	 *
	 * @return the ds code
	 */
	public String getDsCode() {
		return this.dsCode;
	}

	/**
	 * Sets the ds code.
	 *
	 * @param dsCode the new ds code
	 */
	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	/**
	 * Gets the ds descripcion.
	 *
	 * @return the ds descripcion
	 */
	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	/**
	 * Sets the ds descripcion.
	 *
	 * @param dsDescripcion the new ds descripcion
	 */
	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	/**
	 * Gets the ds direccion.
	 *
	 * @return the ds direccion
	 */
	public String getDsDireccion() {
		return this.dsDireccion;
	}

	/**
	 * Sets the ds direccion.
	 *
	 * @param dsDireccion the new ds direccion
	 */
	public void setDsDireccion(String dsDireccion) {
		this.dsDireccion = dsDireccion;
	}

	/**
	 * Gets the ds estado.
	 *
	 * @return the ds estado
	 */
	public String getDsEstado() {
		return this.dsEstado;
	}

	/**
	 * Sets the ds estado.
	 *
	 * @param dsEstado the new ds estado
	 */
	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}

	/**
	 * Gets the ds name.
	 *
	 * @return the ds name
	 */
	public String getDsName() {
		return this.dsName;
	}

	/**
	 * Sets the ds name.
	 *
	 * @param dsName the new ds name
	 */
	public void setDsName(String dsName) {
		this.dsName = dsName;
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
	 * Gets the ds pais.
	 *
	 * @return the ds pais
	 */
	public String getDsPais() {
		return this.dsPais;
	}

	/**
	 * Sets the ds pais.
	 *
	 * @param dsPais the new ds pais
	 */
	public void setDsPais(String dsPais) {
		this.dsPais = dsPais;
	}

	/**
	 * Gets the ds pci.
	 *
	 * @return the ds pci
	 */
	public String getDsPci() {
		return this.dsPci;
	}

	/**
	 * Sets the ds pci.
	 *
	 * @param dsPci the new ds pci
	 */
	public void setDsPci(String dsPci) {
		this.dsPci = dsPci;
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
	 * Gets the ds user creation.
	 *
	 * @return the ds user creation
	 */
	public String getDsUserCreation() {
		return this.dsUserCreation;
	}

	/**
	 * Sets the ds user creation.
	 *
	 * @param dsUserCreation the new ds user creation
	 */
	public void setDsUserCreation(String dsUserCreation) {
		this.dsUserCreation = dsUserCreation;
	}

	/**
	 * Gets the ds user modification.
	 *
	 * @return the ds user modification
	 */
	public String getDsUserModification() {
		return this.dsUserModification;
	}

	/**
	 * Sets the ds user modification.
	 *
	 * @param dsUserModification the new ds user modification
	 */
	public void setDsUserModification(String dsUserModification) {
		this.dsUserModification = dsUserModification;
	}

	/**
	 * Gets the dt creation.
	 *
	 * @return the dt creation
	 */
	public Timestamp getDtCreation() {
		return this.dtCreation;
	}

	/**
	 * Sets the dt creation.
	 *
	 * @param dtCreation the new dt creation
	 */
	public void setDtCreation(Timestamp dtCreation) {
		this.dtCreation = dtCreation;
	}

	/**
	 * Gets the dt modified.
	 *
	 * @return the dt modified
	 */
	public Timestamp getDtModified() {
		return this.dtModified;
	}

	/**
	 * Sets the dt modified.
	 *
	 * @param dtModified the new dt modified
	 */
	public void setDtModified(Timestamp dtModified) {
		this.dtModified = dtModified;
	}

	/**
	 * Gets the fk id responsable.
	 *
	 * @return the fk id responsable
	 */
	public TblActores getFkIdResponsable() {
		return this.fkIdResponsable;
	}

	/**
	 * Sets the fk id responsable.
	 *
	 * @param fkIdResponsable the new fk id responsable
	 */
	public void setFkIdResponsable(TblActores fkIdResponsable) {
		this.fkIdResponsable = fkIdResponsable;
	}

}