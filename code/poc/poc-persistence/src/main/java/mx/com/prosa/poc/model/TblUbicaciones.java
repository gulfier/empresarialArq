package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the TBL_UBICACIONES database table.
 * 
 */
@Entity
@Table(name="TBL_UBICACIONES")
@NamedQuery(name="TblUbicaciones.findAll", query="SELECT t FROM TblUbicaciones t")
public class TblUbicaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_UBICACION")
	private long pkIdUbicacion;

	@Column(name="DS_CIUDAD")
	private String dsCiudad;

	@Column(name="DS_CODE")
	private String dsCode;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_DIRECCION")
	private String dsDireccion;

	@Column(name="DS_ESTADO")
	private String dsEstado;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_PAIS")
	private String dsPais;

	@Column(name="DS_PCI")
	private String dsPci;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@Column(name="DS_USER_CREATION")
	private String dsUserCreation;

	@Column(name="DS_USER_MODIFICATION")
	private String dsUserModification;

	@Column(name="DT_CREATION")
	private Timestamp dtCreation;

	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;

	@Column(name="FK_ID_RESPONSABLE")
	private BigDecimal fkIdResponsable;

	public TblUbicaciones() {
	}

	public long getPkIdUbicacion() {
		return this.pkIdUbicacion;
	}

	public void setPkIdUbicacion(long pkIdUbicacion) {
		this.pkIdUbicacion = pkIdUbicacion;
	}

	public String getDsCiudad() {
		return this.dsCiudad;
	}

	public void setDsCiudad(String dsCiudad) {
		this.dsCiudad = dsCiudad;
	}

	public String getDsCode() {
		return this.dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsDireccion() {
		return this.dsDireccion;
	}

	public void setDsDireccion(String dsDireccion) {
		this.dsDireccion = dsDireccion;
	}

	public String getDsEstado() {
		return this.dsEstado;
	}

	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsPais() {
		return this.dsPais;
	}

	public void setDsPais(String dsPais) {
		this.dsPais = dsPais;
	}

	public String getDsPci() {
		return this.dsPci;
	}

	public void setDsPci(String dsPci) {
		this.dsPci = dsPci;
	}

	public String getDsTipo() {
		return this.dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public String getDsUserCreation() {
		return this.dsUserCreation;
	}

	public void setDsUserCreation(String dsUserCreation) {
		this.dsUserCreation = dsUserCreation;
	}

	public String getDsUserModification() {
		return this.dsUserModification;
	}

	public void setDsUserModification(String dsUserModification) {
		this.dsUserModification = dsUserModification;
	}

	public Timestamp getDtCreation() {
		return this.dtCreation;
	}

	public void setDtCreation(Timestamp dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Timestamp getDtModified() {
		return this.dtModified;
	}

	public void setDtModified(Timestamp dtModified) {
		this.dtModified = dtModified;
	}

	public BigDecimal getFkIdResponsable() {
		return this.fkIdResponsable;
	}

	public void setFkIdResponsable(BigDecimal fkIdResponsable) {
		this.fkIdResponsable = fkIdResponsable;
	}

}