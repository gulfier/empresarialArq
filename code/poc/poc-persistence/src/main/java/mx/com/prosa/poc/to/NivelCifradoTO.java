package mx.com.prosa.poc.to;

import java.io.Serializable;

public class NivelCifradoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5540076409416570850L;

	/**
	 * 
	 */
	private long pkIdCifrado;
	
	private String dsNombre;
	

	

	public long getPkIdCifrado() {
		return pkIdCifrado;
	}

	public void setPkIdCifrado(long pkIdCifrado) {
		this.pkIdCifrado = pkIdCifrado;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	
	
	
}
