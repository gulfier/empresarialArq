package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_COMPONENTES_RED database table.
 * 
 */
@Entity
@Table(name="TBL_COMPONENTES_RED")
@NamedQuery(name="TblComponentesRed.findAll", query="SELECT t FROM TblComponentesRed t")
public class TblComponentesRed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_SERVICIO")
	private String dsServicio;

	@Column(name="FK_ID_IP")
	private BigDecimal fkIdIp;

	@Column(name="PK_ID_COMPONENTE")
	private BigDecimal pkIdComponente;

	public TblComponentesRed() {
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsServicio() {
		return this.dsServicio;
	}

	public void setDsServicio(String dsServicio) {
		this.dsServicio = dsServicio;
	}

	public BigDecimal getFkIdIp() {
		return this.fkIdIp;
	}

	public void setFkIdIp(BigDecimal fkIdIp) {
		this.fkIdIp = fkIdIp;
	}

	public BigDecimal getPkIdComponente() {
		return this.pkIdComponente;
	}

	public void setPkIdComponente(BigDecimal pkIdComponente) {
		this.pkIdComponente = pkIdComponente;
	}

}