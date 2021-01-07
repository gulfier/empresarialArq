package mx.com.prosa.poc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the TBL_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_SERVIDORES")
@NamedQuery(name="TblServidores.findAll", query="SELECT t FROM TblServidores t")
public class TblServidores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3210099599331010531L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_SERVIDOR")
	private long pkIdServidor;

	@Column(name="DS_AMBIENTE")
	private String dsAmbiente;

	@Column(name="DS_CODE")
	private String dsCode;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_HOST_NAME")
	private String dsHostName;

	@Column(name="DS_MARCA_MODELO")
	private String dsMarcaModelo;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="DS_PCI")
	private String dsPci;

	@Column(name="DS_PROPOSITO")
	private String dsProposito;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@Column(name="DS_USER_CREATION")
	private String dsUserCreation;

	@Column(name="DS_USER_MODIFICATION")
	private String dsUserModification;

	@Column(name="DS_VIRTUALIZACION")
	private String dsVirtualizacion;

	@Column(name="DT_CREATION")
	private Timestamp dtCreation;

	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;

	@Column(name="FK_ID_RESPONSABLE")
	private TblActores fkIdResponsable;

	@Column(name="FK_ID_UBICACION")
	private TblUbicaciones fkIdUbicacion;

	public TblServidores() {
	}

	public long getPkIdServidor() {
		return this.pkIdServidor;
	}

	public void setPkIdServidor(long pkIdServidor) {
		this.pkIdServidor = pkIdServidor;
	}

	public String getDsAmbiente() {
		return this.dsAmbiente;
	}

	public void setDsAmbiente(String dsAmbiente) {
		this.dsAmbiente = dsAmbiente;
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

	public String getDsHostName() {
		return this.dsHostName;
	}

	public void setDsHostName(String dsHostName) {
		this.dsHostName = dsHostName;
	}

	public String getDsMarcaModelo() {
		return this.dsMarcaModelo;
	}

	public void setDsMarcaModelo(String dsMarcaModelo) {
		this.dsMarcaModelo = dsMarcaModelo;
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsPci() {
		return this.dsPci;
	}

	public void setDsPci(String dsPci) {
		this.dsPci = dsPci;
	}

	public String getDsProposito() {
		return this.dsProposito;
	}

	public void setDsProposito(String dsProposito) {
		this.dsProposito = dsProposito;
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

	public String getDsVirtualizacion() {
		return this.dsVirtualizacion;
	}

	public void setDsVirtualizacion(String dsVirtualizacion) {
		this.dsVirtualizacion = dsVirtualizacion;
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

	public TblActores getFkIdResponsable() {
		return this.fkIdResponsable;
	}

	public void setFkIdResponsable(TblActores fkIdResponsable) {
		this.fkIdResponsable = fkIdResponsable;
	}

	public TblUbicaciones getFkIdUbicacion() {
		return this.fkIdUbicacion;
	}

	public void setFkIdUbicacion(TblUbicaciones fkIdUbicacion) {
		this.fkIdUbicacion = fkIdUbicacion;
	}

}