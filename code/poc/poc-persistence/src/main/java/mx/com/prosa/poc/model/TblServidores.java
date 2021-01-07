package mx.com.prosa.poc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_SERVIDORES")
@NamedQuery(name="TblServidores.findAll", query="SELECT t FROM TblServidores t")
public class TblServidores implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3210099599331010531L;

	/** The pk id servidor. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_SERVIDOR")
	private long pkIdServidor;

	/** The ds ambiente. */
	@Column(name="DS_AMBIENTE")
	private String dsAmbiente;

	/** The ds code. */
	@Column(name="DS_CODE")
	private String dsCode;

	/** The ds descripcion. */
	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	/** The ds host name. */
	@Column(name="DS_HOST_NAME")
	private String dsHostName;

	/** The ds marca modelo. */
	@Column(name="DS_MARCA_MODELO")
	private String dsMarcaModelo;

	/** The ds name. */
	@Column(name="DS_NAME")
	private String dsName;

	/** The ds pci. */
	@Column(name="DS_PCI")
	private String dsPci;

	/** The ds proposito. */
	@Column(name="DS_PROPOSITO")
	private String dsProposito;

	/** The ds tipo. */
	@Column(name="DS_TIPO")
	private String dsTipo;

	/** The ds user creation. */
	@Column(name="DS_USER_CREATION")
	private String dsUserCreation;

	/** The ds user modification. */
	@Column(name="DS_USER_MODIFICATION")
	private String dsUserModification;

	/** The ds virtualizacion. */
	@Column(name="DS_VIRTUALIZACION")
	private String dsVirtualizacion;

	/** The dt creation. */
	@Column(name="DT_CREATION")
	private Timestamp dtCreation;

	/** The dt modified. */
	@Column(name="DT_MODIFIED")
	private Timestamp dtModified;

	/** The fk id responsable. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_ID_RESPONSABLE", referencedColumnName = "PK_ID_ACTOR", unique=false, nullable=false, insertable=true, updatable=true)
	private TblActores fkIdResponsable;

	/** The fk id ubicacion. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_ID_UBICACION", referencedColumnName = "PK_ID_UBICACION", unique=false, nullable=false, insertable=true, updatable=true)
	private TblUbicaciones fkIdUbicacion;

	/**
	 * Instantiates a new tbl servidores.
	 */
	public TblServidores() {
	}

	/**
	 * Gets the pk id servidor.
	 *
	 * @return the pk id servidor
	 */
	public long getPkIdServidor() {
		return this.pkIdServidor;
	}

	/**
	 * Sets the pk id servidor.
	 *
	 * @param pkIdServidor the new pk id servidor
	 */
	public void setPkIdServidor(long pkIdServidor) {
		this.pkIdServidor = pkIdServidor;
	}

	/**
	 * Gets the ds ambiente.
	 *
	 * @return the ds ambiente
	 */
	public String getDsAmbiente() {
		return this.dsAmbiente;
	}

	/**
	 * Sets the ds ambiente.
	 *
	 * @param dsAmbiente the new ds ambiente
	 */
	public void setDsAmbiente(String dsAmbiente) {
		this.dsAmbiente = dsAmbiente;
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
	 * Gets the ds host name.
	 *
	 * @return the ds host name
	 */
	public String getDsHostName() {
		return this.dsHostName;
	}

	/**
	 * Sets the ds host name.
	 *
	 * @param dsHostName the new ds host name
	 */
	public void setDsHostName(String dsHostName) {
		this.dsHostName = dsHostName;
	}

	/**
	 * Gets the ds marca modelo.
	 *
	 * @return the ds marca modelo
	 */
	public String getDsMarcaModelo() {
		return this.dsMarcaModelo;
	}

	/**
	 * Sets the ds marca modelo.
	 *
	 * @param dsMarcaModelo the new ds marca modelo
	 */
	public void setDsMarcaModelo(String dsMarcaModelo) {
		this.dsMarcaModelo = dsMarcaModelo;
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
	 * Gets the ds proposito.
	 *
	 * @return the ds proposito
	 */
	public String getDsProposito() {
		return this.dsProposito;
	}

	/**
	 * Sets the ds proposito.
	 *
	 * @param dsProposito the new ds proposito
	 */
	public void setDsProposito(String dsProposito) {
		this.dsProposito = dsProposito;
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
	 * Gets the ds virtualizacion.
	 *
	 * @return the ds virtualizacion
	 */
	public String getDsVirtualizacion() {
		return this.dsVirtualizacion;
	}

	/**
	 * Sets the ds virtualizacion.
	 *
	 * @param dsVirtualizacion the new ds virtualizacion
	 */
	public void setDsVirtualizacion(String dsVirtualizacion) {
		this.dsVirtualizacion = dsVirtualizacion;
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

	/**
	 * Gets the fk id ubicacion.
	 *
	 * @return the fk id ubicacion
	 */
	public TblUbicaciones getFkIdUbicacion() {
		return this.fkIdUbicacion;
	}

	/**
	 * Sets the fk id ubicacion.
	 *
	 * @param fkIdUbicacion the new fk id ubicacion
	 */
	public void setFkIdUbicacion(TblUbicaciones fkIdUbicacion) {
		this.fkIdUbicacion = fkIdUbicacion;
	}

}