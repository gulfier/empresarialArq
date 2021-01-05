package mx.com.prosa.poc.to;

import java.io.Serializable;


public class AplicacionTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3670798248929358646L;

	
	
	private Long pkIdAplicacion;

	private String dsClasificacion;

	private String dsCode;

	private String dsComment;

	private String dsDescripcion;

	private String dsEstatus;

	private String dsName;

	private String dsNombre;

	private String dsNombreCorto;

	private String dsNombreLargo;

	private String dsPci;

	private String dsUserCreation;

	private String dsUserModification;

	private String dtCreation;

	private String dtModified;

	public Long getPkIdAplicacion() {
		return pkIdAplicacion;
	}

	public void setPkIdAplicacion(Long pkIdAplicacion) {
		this.pkIdAplicacion = pkIdAplicacion;
	}

	public String getDsClasificacion() {
		return dsClasificacion;
	}

	public void setDsClasificacion(String dsClasificacion) {
		this.dsClasificacion = dsClasificacion;
	}

	public String getDsCode() {
		return dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	public String getDsComment() {
		return dsComment;
	}

	public void setDsComment(String dsComment) {
		this.dsComment = dsComment;
	}

	public String getDsDescripcion() {
		return dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsEstatus() {
		return dsEstatus;
	}

	public void setDsEstatus(String dsEstatus) {
		this.dsEstatus = dsEstatus;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsNombreCorto() {
		return dsNombreCorto;
	}

	public void setDsNombreCorto(String dsNombreCorto) {
		this.dsNombreCorto = dsNombreCorto;
	}

	public String getDsNombreLargo() {
		return dsNombreLargo;
	}

	public void setDsNombreLargo(String dsNombreLargo) {
		this.dsNombreLargo = dsNombreLargo;
	}

	public String getDsPci() {
		return dsPci;
	}

	public void setDsPci(String dsPci) {
		this.dsPci = dsPci;
	}

	public String getDsUserCreation() {
		return dsUserCreation;
	}

	public void setDsUserCreation(String dsUserCreation) {
		this.dsUserCreation = dsUserCreation;
	}

	public String getDsUserModification() {
		return dsUserModification;
	}

	public void setDsUserModification(String dsUserModification) {
		this.dsUserModification = dsUserModification;
	}

	public String getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(String dtCreation) {
		this.dtCreation = dtCreation;
	}

	public String getDtModified() {
		return dtModified;
	}

	public void setDtModified(String dtModified) {
		this.dtModified = dtModified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
