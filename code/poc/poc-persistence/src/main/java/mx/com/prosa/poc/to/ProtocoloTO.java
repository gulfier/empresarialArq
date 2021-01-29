package mx.com.prosa.poc.to;

public class ProtocoloTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5540076409416570850L;

	/**
	 * 
	 */
	
	private long pkIdProtocolo;
	
	private String dsNombre;
	
	private String dsVersion;
	
	private Long fkIdCifrado;

	public long getPkIdProtocolo() {
		return pkIdProtocolo;
	}

	public void setPkIdProtocolo(long pkIdProtocolo) {
		this.pkIdProtocolo = pkIdProtocolo;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsVersion() {
		return dsVersion;
	}

	public void setDsVersion(String dsVersion) {
		this.dsVersion = dsVersion;
	}

	public Long getFkIdCifrado() {
		return fkIdCifrado;
	}

	public void setFkIdCifrado(Long fkIdCifrado) {
		this.fkIdCifrado = fkIdCifrado;
	}

	
}
