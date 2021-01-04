package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TBL_APLICACIONES database table.
 * 
 */
@Entity
@Table(name="TBL_APLICACIONES")
@NamedQuery(name="TblAplicaciones.findAll", query="SELECT t FROM TblAplicaciones t")
public class TblAplicaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_APLICACION")
	private long pkIdAplicacion;

	@Column(name="DS_CLASIFICACION")
	private String dsClasificacion;

	@Column(name="DS_CODE")
	private String dsCode;

	@Lob
	@Column(name="DS_COMMENT")
	private String dsComment;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_ESTATUS")
	private String dsEstatus;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_NOMBRE_CORTO")
	private String dsNombreCorto;

	@Column(name="DS_NOMBRE_LARGO")
	private String dsNombreLargo;

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

	public TblAplicaciones() {
	}

	public long getPkIdAplicacion() {
		return this.pkIdAplicacion;
	}

	public void setPkIdAplicacion(long pkIdAplicacion) {
		this.pkIdAplicacion = pkIdAplicacion;
	}

	public String getDsClasificacion() {
		return this.dsClasificacion;
	}

	public void setDsClasificacion(String dsClasificacion) {
		this.dsClasificacion = dsClasificacion;
	}

	public String getDsCode() {
		return this.dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	public String getDsComment() {
		return this.dsComment;
	}

	public void setDsComment(String dsComment) {
		this.dsComment = dsComment;
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsEstatus() {
		return this.dsEstatus;
	}

	public void setDsEstatus(String dsEstatus) {
		this.dsEstatus = dsEstatus;
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

	public String getDsNombreCorto() {
		return this.dsNombreCorto;
	}

	public void setDsNombreCorto(String dsNombreCorto) {
		this.dsNombreCorto = dsNombreCorto;
	}

	public String getDsNombreLargo() {
		return this.dsNombreLargo;
	}

	public void setDsNombreLargo(String dsNombreLargo) {
		this.dsNombreLargo = dsNombreLargo;
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

}