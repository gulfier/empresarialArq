package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_IPS database table.
 * 
 */
@Entity
@Table(name="TBL_IPS")
@NamedQuery(name="TblIp.findAll", query="SELECT t FROM TblIp t")
public class TblIp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_IP")
	private long pkIdIp;

	@Column(name="DS_IP")
	private String dsIp;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@Column(name="FK_ID_SEGMENTO")
	private BigDecimal fkIdSegmento;

	public TblIp() {
	}

	public long getPkIdIp() {
		return this.pkIdIp;
	}

	public void setPkIdIp(long pkIdIp) {
		this.pkIdIp = pkIdIp;
	}

	public String getDsIp() {
		return this.dsIp;
	}

	public void setDsIp(String dsIp) {
		this.dsIp = dsIp;
	}

	public String getDsTipo() {
		return this.dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public BigDecimal getFkIdSegmento() {
		return this.fkIdSegmento;
	}

	public void setFkIdSegmento(BigDecimal fkIdSegmento) {
		this.fkIdSegmento = fkIdSegmento;
	}

}