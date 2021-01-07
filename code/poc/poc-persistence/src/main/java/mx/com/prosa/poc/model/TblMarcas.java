package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_MARCAS database table.
 * 
 */
@Entity
@Table(name="TBL_MARCAS")
@NamedQuery(name="TblMarcas.findAll", query="SELECT t FROM TblMarcas t")
public class TblMarcas implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4808322184730619926L;

	/** The pk id marca. */
	@Id
	@SequenceGenerator(name = "SEQ_MARCAS", sequenceName = "SEQ_MARCAS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MARCAS")
	@Column(name="PK_ID_MARCA")
	private long pkIdMarca;

	/** The ds descripcion. */
	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	/** The ds nombre. */
	@Column(name="DS_NOMBRE")
	private String dsNombre;

	/**
	 * Instantiates a new tbl marcas.
	 */
	public TblMarcas() {
	}

	/**
	 * Gets the pk id marca.
	 *
	 * @return the pk id marca
	 */
	public long getPkIdMarca() {
		return this.pkIdMarca;
	}

	/**
	 * Sets the pk id marca.
	 *
	 * @param pkIdMarca the new pk id marca
	 */
	public void setPkIdMarca(long pkIdMarca) {
		this.pkIdMarca = pkIdMarca;
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

}