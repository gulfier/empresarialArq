package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the TBL_ACTORES_X_APLICACION database table.
 * 
 */
@Entity
@Table(name="TBL_ACTORES_X_APLICACION")
@IdClass(TblActoresXAplicacionPK.class)
@NamedQuery(name="TblActoresXAplicacion.findAll", query="SELECT t FROM TblActoresXAplicacion t")
public class TblActoresXAplicacion implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4771175060929382313L;

	/** The fk id actor. */
	@Id
	@Column(name="FK_ID_ACTOR")
	private long fkIdActor;

	/** The fk id aplicacion. */
	@Id
	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;
	
	/** The tbl base datos. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_ACTOR",referencedColumnName = "PK_ID_ACTOR", updatable=false,insertable=false)
	private TblActores tblActores;
	
	/** The tbl aplicaciones. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_APLICACION",referencedColumnName = "PK_ID_APLICACION", updatable=false,insertable=false)
	private TblAplicaciones tblAplicaciones;

	/**
	 * Instantiates a new tbl actores X aplicacion.
	 */
	public TblActoresXAplicacion() {
	}
	
	/**
	 * Gets the fk id actor.
	 *
	 * @return the fk id actor
	 */
	public long getFkIdActor() {
		return this.fkIdActor;
	}
	
	/**
	 * Sets the fk id actor.
	 *
	 * @param fkIdActor the new fk id actor
	 */
	public void setFkIdActor(long fkIdActor) {
		this.fkIdActor = fkIdActor;
	}
	
	/**
	 * Gets the fk id aplicacion.
	 *
	 * @return the fk id aplicacion
	 */
	public long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	
	/**
	 * Sets the fk id aplicacion.
	 *
	 * @param fkIdAplicacion the new fk id aplicacion
	 */
	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}
	
	/**
	 * Gets the tbl base datos.
	 *
	 * @return the tbl base datos
	 */
	public TblActores getTblActores() {
		return tblActores;
	}
	
	/**
	 * Sets the tbl base datos.
	 *
	 * @param tblBaseDatos the new tbl base datos
	 */
	public void setTblActores(TblActores tblBaseDatos) {
		this.tblActores = tblBaseDatos;
	}
	
	/**
	 * Gets the tbl aplicaciones.
	 *
	 * @return the tbl aplicaciones
	 */
	public TblAplicaciones getTblAplicaciones() {
		return tblAplicaciones;
	}
	
	/**
	 * Sets the tbl aplicaciones.
	 *
	 * @param tblAplicaciones the new tbl aplicaciones
	 */
	public void setTblAplicaciones(TblAplicaciones tblAplicaciones) {
		this.tblAplicaciones = tblAplicaciones;
	}
}