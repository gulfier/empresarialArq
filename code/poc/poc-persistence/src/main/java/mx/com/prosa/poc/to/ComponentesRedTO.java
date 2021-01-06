package mx.com.prosa.poc.to;

import java.io.Serializable;

public class ComponentesRedTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5159749359493442397L;

	
	private String dsDescripcion;

	private String dsNombre;

	private String dsServicio;

	private Long fkIdIp;

	private Long pkIdComponente;

	public String getDsDescripcion() {
		return dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsServicio() {
		return dsServicio;
	}

	public void setDsServicio(String dsServicio) {
		this.dsServicio = dsServicio;
	}

	public Long getFkIdIp() {
		return fkIdIp;
	}

	public void setFkIdIp(Long fkIdIp) {
		this.fkIdIp = fkIdIp;
	}

	public Long getPkIdComponente() {
		return pkIdComponente;
	}

	public void setPkIdComponente(Long pkIdComponente) {
		this.pkIdComponente = pkIdComponente;
	}
	
	
}
