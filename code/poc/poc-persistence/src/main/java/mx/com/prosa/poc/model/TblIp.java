package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@SequenceGenerator(name = "SEQ_IPS", sequenceName = "SEQ_IPS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "SEQ_IPS")
	@Column(name="PK_ID_IP")
	private long pkIdIp;

	@Column(name="DS_IP")
	private String dsIp;

	@Column(name="DS_TIPO")
	private String dsTipo;

	@ManyToOne
	@JoinColumn(name="FK_ID_SEGMENTO", referencedColumnName = "PK_ID_SEGMENTO", nullable = false, insertable = true, updatable = true)
	private TblSegmentos tblSegmentos;

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

	public TblSegmentos getTblSegmentos() {
		return tblSegmentos;
	}

	public void setTblSegmentos(TblSegmentos tblSegmentos) {
		this.tblSegmentos = tblSegmentos;
	}



}