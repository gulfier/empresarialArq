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
 * The persistent class for the TBL_APPS_X_SERV_APP database table.
 * 
 */
@Entity
@Table(name="TBL_APPS_X_SERV_APP")
@IdClass(TblAppsXServAppPK.class)
@NamedQuery(name="TblAppsXServApp.findAll", query="SELECT t FROM TblAppsXServApp t")
public class TblAppsXServApp implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -234253986745862607L;

	/** The fk id aplicacion. */
	@Id
	@Column(name="FK_ID_APLICACION")
	private Long fkIdAplicacion;

	/** The fk id servicio. */
	@Id
	@Column(name="FK_ID_SERVICIO")
	private Long fkIdServicio;
	
	/** The tbl base datos. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SERVICIO",referencedColumnName = "PK_ID_SERVICIO", updatable=false,insertable=false)
	private TblServiciosAplicativo tblServiciosAplicativo;

	/** The tbl aplicaciones. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_APLICACION",referencedColumnName = "PK_ID_APLICACION", updatable=false,insertable=false)
	private TblAplicaciones tblAplicaciones;

	/**
	 * Instantiates a new tbl apps X serv app.
	 */
	public TblAppsXServApp() {
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
	 * Gets the fk id servicio.
	 *
	 * @return the fk id servicio
	 */
	public Long getFkIdServicio() {
		return this.fkIdServicio;
	}
	
	/**
	 * Sets the fk id servicio.
	 *
	 * @param fkIdServicio the new fk id servicio
	 */
	public void setFkIdServicio(Long fkIdServicio) {
		this.fkIdServicio = fkIdServicio;
	}
	
	/**
	 * Gets the tbl base datos.
	 *
	 * @return the tbl base datos
	 */
	public TblServiciosAplicativo getTblServiciosAplicativo() {
		return tblServiciosAplicativo;
	}
	
	/**
	 * Sets the tbl base datos.
	 *
	 * @param tblBaseDatos the new tbl base datos
	 */
	public void setTblServiciosAplicativo(TblServiciosAplicativo tblBaseDatos) {
		this.tblServiciosAplicativo = tblBaseDatos;
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