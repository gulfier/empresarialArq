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
 * The persistent class for the TBL_APP_X_BASE_DATOS database table.
 * 
 */
@Entity
@Table(name="TBL_APP_X_BASE_DATOS")
@IdClass(TblAppXBaseDatosPK.class)
@NamedQuery(name="TblAppXBaseDatos.findAll", query="SELECT t FROM TblAppXBaseDatos t")
public class TblAppXBaseDatos implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3431541819364642455L;

	/** The fk id aplicacion. */
	@Id
	@Column(name="FK_ID_APLICACION")
	private Long fkIdAplicacion;

	/** The fk id base. */
	@Id
	@Column(name="FK_ID_BASE")
	private Long fkIdBase;
	
	/** The tbl base datos. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_BASE",referencedColumnName = "PK_ID_BASE", updatable=false,insertable=false)
	private TblBaseDatos tblBaseDatos;

	/** The tbl aplicaciones. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_APLICACION",referencedColumnName = "PK_ID_APLICACION", updatable=false,insertable=false)
	private TblAplicaciones tblAplicaciones;

	/**
	 * Instantiates a new tbl app X base datos.
	 */
	public TblAppXBaseDatos() {
	}
	
	/**
	 * Gets the fk id aplicacion.
	 *
	 * @return the fk id aplicacion
	 */
	public Long getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}
	
	/**
	 * Sets the fk id aplicacion.
	 *
	 * @param fkIdAplicacion the new fk id aplicacion
	 */
	public void setFkIdAplicacion(Long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}
	
	/**
	 * Gets the fk id base.
	 *
	 * @return the fk id base
	 */
	public Long getFkIdBase() {
		return this.fkIdBase;
	}
	
	/**
	 * Sets the fk id base.
	 *
	 * @param fkIdBase the new fk id base
	 */
	public void setFkIdBase(Long fkIdBase) {
		this.fkIdBase = fkIdBase;
	}
	
	/**
	 * Gets the tbl base datos.
	 *
	 * @return the tbl base datos
	 */
	public TblBaseDatos getTblBaseDatos() {
		return tblBaseDatos;
	}
	
	/**
	 * Sets the tbl base datos.
	 *
	 * @param tblBaseDatos the new tbl base datos
	 */
	public void setTblBaseDatos(TblBaseDatos tblBaseDatos) {
		this.tblBaseDatos = tblBaseDatos;
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