package mx.com.prosa.poc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * Entity class de la tabla K_SITE.
 *
 * @author Jorge Ortega Hernández <jorgeortega30@live.com.mx>
 */
@Entity
@Table(name = "TBL_BITACORA_CAMBIOS")
public class BitacoraCambiosDO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 24906249547588369L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_BITACORA")
	private Long id;

	/** The ds codigo. */
	@Column(name = "DS_CODIGO")
	private Integer dsCodigo;

	/** The fecha. */
	@Column(name = "DS_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	/** The ds descripcion. */
	@Column(name = "DS_DESCRIPCION")
	private String dsDescripcion;

	/** The ds tipo. */
	@Column(name = "DS_TIPO")
	private String dsTipo;

	/** The ds autor. */
	@Column(name = "DS_AUTOR")
	private String dsAutor;

	/** The ds cambio actual. */
	@Lob
	@Column(name = "DS_CAMBIO_ACTUAL")
	private String dsCambioActual;

	/** The ds cambio anterior. */
	@Lob
	@Column(name = "DS_CAMBIO_ANTERIOR")
	private String dsCambioAnterior;

	/** The ds estatus. */
	@Column(name = "ID_ESTATUS")
	private Integer dsEstatus;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the ds codigo.
	 *
	 * @return the ds codigo
	 */
	public Integer getDsCodigo() {
		return dsCodigo;
	}

	/**
	 * Sets the ds codigo.
	 *
	 * @param dsCodigo the new ds codigo
	 */
	public void setDsCodigo(Integer dsCodigo) {
		this.dsCodigo = dsCodigo;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the ds descripcion.
	 *
	 * @return the ds descripcion
	 */
	public String getDsDescripcion() {
		return dsDescripcion;
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
	 * Gets the ds tipo.
	 *
	 * @return the ds tipo
	 */
	public String getDsTipo() {
		return dsTipo;
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
	 * Gets the ds autor.
	 *
	 * @return the ds autor
	 */
	public String getDsAutor() {
		return dsAutor;
	}

	/**
	 * Sets the ds autor.
	 *
	 * @param dsAutor the new ds autor
	 */
	public void setDsAutor(String dsAutor) {
		this.dsAutor = dsAutor;
	}

	/**
	 * Gets the ds cambio actual.
	 *
	 * @return the ds cambio actual
	 */
	public String getDsCambioActual() {
		return dsCambioActual;
	}

	/**
	 * Sets the ds cambio actual.
	 *
	 * @param dsCambioActual the new ds cambio actual
	 */
	public void setDsCambioActual(String dsCambioActual) {
		this.dsCambioActual = dsCambioActual;
	}

	/**
	 * Gets the ds cambio anterior.
	 *
	 * @return the ds cambio anterior
	 */
	public String getDsCambioAnterior() {
		return dsCambioAnterior;
	}

	/**
	 * Sets the ds cambio anterior.
	 *
	 * @param dsCambioAnterior the new ds cambio anterior
	 */
	public void setDsCambioAnterior(String dsCambioAnterior) {
		this.dsCambioAnterior = dsCambioAnterior;
	}

	/**
	 * Gets the ds estatus.
	 *
	 * @return the ds estatus
	 */
	public Integer getDsEstatus() {
		return dsEstatus;
	}

	/**
	 * Sets the ds estatus.
	 *
	 * @param dsEstatus the new ds estatus
	 */
	public void setDsEstatus(Integer dsEstatus) {
		this.dsEstatus = dsEstatus;
	}

}
