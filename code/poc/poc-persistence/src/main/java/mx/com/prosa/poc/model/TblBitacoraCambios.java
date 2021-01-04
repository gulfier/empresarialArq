package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TBL_BITACORA_CAMBIOS database table.
 * 
 */
@Entity
@Table(name="TBL_BITACORA_CAMBIOS")
@NamedQuery(name="TblBitacoraCambios.findAll", query="SELECT t FROM TblBitacoraCambios t")
public class TblBitacoraCambios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DS_AUTOR")
	private String dsAutor;

	@Lob
	@Column(name="DS_CAMBIO_ACTUAL")
	private String dsCambioActual;

	@Lob
	@Column(name="DS_CAMBIO_ANTERIOR")
	private String dsCambioAnterior;

	@Column(name="DS_CODIGO")
	private BigDecimal dsCodigo;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="DS_FECHA")
	private Date dsFecha;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@Column(name="ID_ESTATUS")
	private BigDecimal idEstatus;

	@Column(name="PK_ID_BITACORA")
	private BigDecimal pkIdBitacora;

	public TblBitacoraCambios() {
	}

	public String getDsAutor() {
		return this.dsAutor;
	}

	public void setDsAutor(String dsAutor) {
		this.dsAutor = dsAutor;
	}

	public String getDsCambioActual() {
		return this.dsCambioActual;
	}

	public void setDsCambioActual(String dsCambioActual) {
		this.dsCambioActual = dsCambioActual;
	}

	public String getDsCambioAnterior() {
		return this.dsCambioAnterior;
	}

	public void setDsCambioAnterior(String dsCambioAnterior) {
		this.dsCambioAnterior = dsCambioAnterior;
	}

	public BigDecimal getDsCodigo() {
		return this.dsCodigo;
	}

	public void setDsCodigo(BigDecimal dsCodigo) {
		this.dsCodigo = dsCodigo;
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public Date getDsFecha() {
		return this.dsFecha;
	}

	public void setDsFecha(Date dsFecha) {
		this.dsFecha = dsFecha;
	}

	public String getDsTipo() {
		return this.dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public BigDecimal getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(BigDecimal idEstatus) {
		this.idEstatus = idEstatus;
	}

	public BigDecimal getPkIdBitacora() {
		return this.pkIdBitacora;
	}

	public void setPkIdBitacora(BigDecimal pkIdBitacora) {
		this.pkIdBitacora = pkIdBitacora;
	}

}