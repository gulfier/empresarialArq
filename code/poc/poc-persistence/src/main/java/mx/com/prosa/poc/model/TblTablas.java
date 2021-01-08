package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_TABLAS database table.
 * 
 */
@Entity
@Table(name="TBL_TABLAS")
@NamedQuery(name="TblTablas.findAll", query="SELECT t FROM TblTablas t")
public class TblTablas implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pk id tabla. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_TABLA")
	private long pkIdTabla;

	/** The ds tabla. */
	@Lob
	@Column(name="DS_TABLA")
	private String dsTabla;

	/** The fk id base. */
	@ManyToOne
	@JoinColumn(name="FK_ID_BASE", referencedColumnName = "PK_ID_BASE", nullable = false, insertable = true, updatable = true)
	private TblBaseDatos fkIdBase;

	/**
	 * Instantiates a new tbl tablas.
	 */
	public TblTablas() {
	}

	/**
	 * Gets the pk id tabla.
	 *
	 * @return the pk id tabla
	 */
	public long getPkIdTabla() {
		return this.pkIdTabla;
	}

	/**
	 * Sets the pk id tabla.
	 *
	 * @param pkIdTabla the new pk id tabla
	 */
	public void setPkIdTabla(long pkIdTabla) {
		this.pkIdTabla = pkIdTabla;
	}

	/**
	 * Gets the ds tabla.
	 *
	 * @return the ds tabla
	 */
	public String getDsTabla() {
		return this.dsTabla;
	}

	/**
	 * Sets the ds tabla.
	 *
	 * @param dsTabla the new ds tabla
	 */
	public void setDsTabla(String dsTabla) {
		this.dsTabla = dsTabla;
	}

	/**
	 * Gets the fk id base.
	 *
	 * @return the fk id base
	 */
	public TblBaseDatos getFkIdBase() {
		return this.fkIdBase;
	}

	/**
	 * Sets the fk id base.
	 *
	 * @param fkIdBase the new fk id base
	 */
	public void setFkIdBase(TblBaseDatos fkIdBase) {
		this.fkIdBase = fkIdBase;
	}

}