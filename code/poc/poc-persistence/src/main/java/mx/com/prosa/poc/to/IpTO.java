package mx.com.prosa.poc.to;

public class IpTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4372356435025470725L;

	/**
	 * 
	 */
	private long pkIdIp;
	
	private String dsIp;
	
	private String dsTipo;
	
	private Long fkIdSegmento;

	public long getPkIdIp() {
		return pkIdIp;
	}

	public void setPkIdIp(long pkIdIp) {
		this.pkIdIp = pkIdIp;
	}

	public String getDsIp() {
		return dsIp;
	}

	public void setDsIp(String dsIp) {
		this.dsIp = dsIp;
	}

	public String getDsTipo() {
		return dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public Long getFkIdSegmento() {
		return fkIdSegmento;
	}

	public void setFkIdSegmento(Long fkIdSegmento) {
		this.fkIdSegmento = fkIdSegmento;
	}


	
	
	
	
	
}
