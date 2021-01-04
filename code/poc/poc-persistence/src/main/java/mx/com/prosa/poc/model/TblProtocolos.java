package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_PROTOCOLOS database table.
 * 
 */
@Entity
@Table(name="TBL_PROTOCOLOS")
@NamedQuery(name="TblProtocolos.findAll", query="SELECT t FROM TblProtocolos t")
public class TblProtocolos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PK_ID_PROTOCOLO")
	private long pkIdProtocolo;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_VERSION")
	private String dsVersion;

	@Column(name="FK_ID_CIFRADO")
	private BigDecimal fkIdCifrado;

	public TblProtocolos() {
	}

	public long getPkIdProtocolo() {
		return this.pkIdProtocolo;
	}

	public void setPkIdProtocolo(long pkIdProtocolo) {
		this.pkIdProtocolo = pkIdProtocolo;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsVersion() {
		return this.dsVersion;
	}

	public void setDsVersion(String dsVersion) {
		this.dsVersion = dsVersion;
	}

	public BigDecimal getFkIdCifrado() {
		return this.fkIdCifrado;
	}

	public void setFkIdCifrado(BigDecimal fkIdCifrado) {
		this.fkIdCifrado = fkIdCifrado;
	}

}