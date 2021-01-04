package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_TABLAS database table.
 * 
 */
@Entity
@Table(name="TBL_TABLAS")
@NamedQuery(name="TblTablas.findAll", query="SELECT t FROM TblTablas t")
public class TblTablas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_TABLA")
	private long pkIdTabla;

	@Lob
	@Column(name="DS_TABLA")
	private String dsTabla;

	@Column(name="FK_ID_BASE")
	private BigDecimal fkIdBase;

	public TblTablas() {
	}

	public long getPkIdTabla() {
		return this.pkIdTabla;
	}

	public void setPkIdTabla(long pkIdTabla) {
		this.pkIdTabla = pkIdTabla;
	}

	public String getDsTabla() {
		return this.dsTabla;
	}

	public void setDsTabla(String dsTabla) {
		this.dsTabla = dsTabla;
	}

	public BigDecimal getFkIdBase() {
		return this.fkIdBase;
	}

	public void setFkIdBase(BigDecimal fkIdBase) {
		this.fkIdBase = fkIdBase;
	}

}