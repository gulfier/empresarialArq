package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_IP_X_PUERTOS database table.
 * 
 */
@Entity
@Table(name="TBL_IP_X_PUERTOS")
@NamedQuery(name="TblIpXPuerto.findAll", query="SELECT t FROM TblIpXPuerto t")
public class TblIpXPuerto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_IP_PUERTO")
	private long pkIdIpPuerto;

	@Column(name="DS_PUERTO")
	private String dsPuerto;

	@Column(name="FK_ID_APLICACION")
	private BigDecimal fkIdAplicacion;

	@Column(name="FK_ID_IP")
	private BigDecimal fkIdIp;

	@Column(name="PK_ID_PROTOCOLO")
	private BigDecimal pkIdProtocolo;

	public TblIpXPuerto() {
	}

	public long getPkIdIpPuerto() {
		return this.pkIdIpPuerto;
	}

	public void setPkIdIpPuerto(long pkIdIpPuerto) {
		this.pkIdIpPuerto = pkIdIpPuerto;
	}

	public String getDsPuerto() {
		return this.dsPuerto;
	}

	public void setDsPuerto(String dsPuerto) {
		this.dsPuerto = dsPuerto;
	}

	public BigDecimal getFkIdAplicacion() {
		return this.fkIdAplicacion;
	}

	public void setFkIdAplicacion(BigDecimal fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}

	public BigDecimal getFkIdIp() {
		return this.fkIdIp;
	}

	public void setFkIdIp(BigDecimal fkIdIp) {
		this.fkIdIp = fkIdIp;
	}

	public BigDecimal getPkIdProtocolo() {
		return this.pkIdProtocolo;
	}

	public void setPkIdProtocolo(BigDecimal pkIdProtocolo) {
		this.pkIdProtocolo = pkIdProtocolo;
	}

}