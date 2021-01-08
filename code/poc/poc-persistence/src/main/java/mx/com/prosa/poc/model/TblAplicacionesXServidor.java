package mx.com.prosa.poc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_APLICACIONES_X_SERVIDOR database table.
 * 
 */
@Entity
@Table(name="TBL_APLICACIONES_X_SERVIDOR")
@NamedQuery(name="TblAplicacionesXServidor.findAll", query="SELECT t FROM TblAplicacionesXServidor t")
@IdClass(TblAplicacionesXServidorPK.class)
public class TblAplicacionesXServidor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="FK_ID_SERVIDOR")
	private long fkIdServidor;
   
	@Id
	@Column(name="FK_ID_APLICACION")
	private long fkIdAplicacion;
	
	
	/** The tbl software comercial. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SERVIDOR",referencedColumnName = "PK_ID_SERVIDOR", updatable=false,insertable=false)
	private TblServidores  tblServidores;

	/** The tbl servidores. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_APLICACION",referencedColumnName = "PK_ID_APLICACION", updatable=false,insertable=false)
	private TblAplicaciones  tblAplicaciones;

	public long getFkIdServidor() {
		return fkIdServidor;
	}

	public void setFkIdServidor(long fkIdServidor) {
		this.fkIdServidor = fkIdServidor;
	}

	public long getFkIdAplicacion() {
		return fkIdAplicacion;
	}

	public void setFkIdAplicacion(long fkIdAplicacion) {
		this.fkIdAplicacion = fkIdAplicacion;
	}

	public TblServidores getTblServidores() {
		return tblServidores;
	}

	public void setTblServidores(TblServidores tblServidores) {
		this.tblServidores = tblServidores;
	}

	public TblAplicaciones getTblAplicaciones() {
		return tblAplicaciones;
	}

	public void setTblAplicaciones(TblAplicaciones tblAplicaciones) {
		this.tblAplicaciones = tblAplicaciones;
	}
	
	
	
	
	
}