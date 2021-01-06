package mx.com.prosa.poc.to;

import java.io.Serializable;
import java.math.BigDecimal;


public class BaseDatosTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6847525115406333934L;

	/**
	 * 
	 */

	private long pkIdBase;

	private String dsAlgoritmo;

	private String dsCode;

	private String dsEncripcion;

	private String dsName;

	private String dsNombre;

	private String dsPci;

	private String dsUserCreation;

	private String dsUserModification;

	private String dtCreation;

	private String dtModified;

	private BigDecimal fkIdModeloDatos;

	private BigDecimal fkIdResponsable;

	public long getPkIdBase() {
		return pkIdBase;
	}

	public void setPkIdBase(long pkIdBase) {
		this.pkIdBase = pkIdBase;
	}

	public String getDsAlgoritmo() {
		return dsAlgoritmo;
	}

	public void setDsAlgoritmo(String dsAlgoritmo) {
		this.dsAlgoritmo = dsAlgoritmo;
	}

	public String getDsCode() {
		return dsCode;
	}

	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}

	public String getDsEncripcion() {
		return dsEncripcion;
	}

	public void setDsEncripcion(String dsEncripcion) {
		this.dsEncripcion = dsEncripcion;
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

	public BigDecimal getFkIdModeloDatos() {
		return fkIdModeloDatos;
	}

	public void setFkIdModeloDatos(BigDecimal fkIdModeloDatos) {
		this.fkIdModeloDatos = fkIdModeloDatos;
	}

	public BigDecimal getFkIdResponsable() {
		return fkIdResponsable;
	}

	public void setFkIdResponsable(BigDecimal fkIdResponsable) {
		this.fkIdResponsable = fkIdResponsable;
	}
	
	
	


}
