package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_COMPONENTES_RED database table.
 * 
 */
@Entity
@Table(name="TBL_COMPONENTES_RED")
public class TblComponentesRed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SEQ_COMPONENTE_RED", sequenceName = "SEQ_COMPONENTE_RED", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "SEQ_COMPONENTE_RED")
	@Column(name="PK_ID_COMPONENTE")
	private Long pkIdComponente;


	@Column(name="DS_DESCRIPCION")
	private String dsDescripcion;

	@Column(name="DS_NOMBRE")
	private String dsNombre;

	@Column(name="DS_SERVICIO")
	private String dsServicio;

	
	@ManyToOne
	@JoinColumn(name="FK_ID_IP", referencedColumnName = "PK_ID_IP", nullable = false, insertable = true, updatable = true)
	private TblIp tblIp;


	public TblComponentesRed() {
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsServicio() {
		return this.dsServicio;
	}

	public void setDsServicio(String dsServicio) {
		this.dsServicio = dsServicio;
	}

	public Long getPkIdComponente() {
		return this.pkIdComponente;
	}

	public TblIp getTblIp() {
		return tblIp;
	}

	public void setTblIp(TblIp tblIp) {
		this.tblIp = tblIp;
	}

	public void setPkIdComponente(Long pkIdComponente) {
		this.pkIdComponente = pkIdComponente;
	}

}