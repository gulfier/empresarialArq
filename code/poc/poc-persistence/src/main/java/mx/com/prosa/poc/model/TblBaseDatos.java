package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the TBL_BASE_DATOS database table.
 * 
 */
@Entity
@Table(name="TBL_BASE_DATOS")
@NamedQuery(name="TblBaseDatos.findAll", query="SELECT t FROM TblBaseDatos t")
public class TblBaseDatos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_BASE")
	private long pkIdBase;

	@Column(name="DS_ALGORITMO")
	private String dsAlgoritmo;

	@Column(name="DS_CODE")
	private String dsCode;

	@Column(name="DS_ENCRIPCION")
	private String dsEncripcion;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_PCI")
	private String dsPci;

	@Column(name="DS_USER_CREATION")
	private String dsUserCreation;

	@Column(name="DS_USER_MODIFICATION")
	private String dsUserModification;

	@Column(name="DT_CREATION")
	private Timestamp dtCreation;

	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;

	@Column(name="FK_ID_MODELO_DATOS")
	private BigDecimal fkIdModeloDatos;

	@Column(name="FK_ID_RESPONSABLE")
	private BigDecimal fkIdResponsable;

	public TblBaseDatos() {
	}

	public long getPkIdBase() {
		return this.pkIdBase;
	}

	public void setPkIdBase(long pkIdBase) {
		this.pkIdBase = pkIdBase;
	}

	public String getDsAlgoritmo() {
		return this.dsAlgoritmo;
	}

	public void setDsAlgoritmo(String dsAlgoritmo) {
		this.dsAlgoritmo = dsAlgoritmo;
	}

	public String getDsCode() {
		return this.dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	public String getDsEncripcion() {
		return this.dsEncripcion;
	}

	public void setDsEncripcion(String dsEncripcion) {
		this.dsEncripcion = dsEncripcion;
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

	public String getDsPci() {
		return this.dsPci;
	}

	public void setDsPci(String dsPci) {
		this.dsPci = dsPci;
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

	public BigDecimal getFkIdModeloDatos() {
		return this.fkIdModeloDatos;
	}

	public void setFkIdModeloDatos(BigDecimal fkIdModeloDatos) {
		this.fkIdModeloDatos = fkIdModeloDatos;
	}

	public BigDecimal getFkIdResponsable() {
		return this.fkIdResponsable;
	}

	public void setFkIdResponsable(BigDecimal fkIdResponsable) {
		this.fkIdResponsable = fkIdResponsable;
	}

}