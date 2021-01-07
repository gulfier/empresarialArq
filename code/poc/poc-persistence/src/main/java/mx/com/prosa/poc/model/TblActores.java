package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_ACTORES database table.
 * 
 */
@Entity
@Table(name="TBL_ACTORES")
@NamedQuery(name="TblActore.findAll", query="SELECT t FROM TblActores t")
public class TblActores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6681662216760783690L;

	/** The pk id actor. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_ACTOR")
	private long pkIdActor;

	/** The ds code. */
	@Column(name="DS_CODE")
	private String dsCode;

	/** The ds descripcion. */
	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	/** The ds name. */
	@Column(name="DS_NAME")
	private String dsName;

	/** The ds nombre. */
	@Column(name="DS_NOMBRE")
	private String dsNombre;

	/** The ds pci. */
	@Column(name="DS_PCI")
	private String dsPci;

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

	/**
	 * Instantiates a new tbl actore.
	 */
	public TblActores() {
	}

	/**
	 * Gets the pk id actor.
	 *
	 * @return the pk id actor
	 */
	public long getPkIdActor() {
		return this.pkIdActor;
	}

	/**
	 * Sets the pk id actor.
	 *
	 * @param pkIdActor the new pk id actor
	 */
	public void setPkIdActor(long pkIdActor) {
		this.pkIdActor = pkIdActor;
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

}