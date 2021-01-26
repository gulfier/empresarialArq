package mx.com.prosa.poc.to;

public class MarcasTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5540076409416570850L;

	/**
	 * 
	 */
	private long pkIdMarca;
	
	private String dsNombre;
	
	private String dsDescripcion;

	public long getPkIdMarca() {
		return pkIdMarca;
	}

	public void setPkIdMarca(long pkIdMarca) {
		this.pkIdMarca = pkIdMarca;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsDescripcion() {
		return dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}
	
	
	

	
	
	
	
	
}
