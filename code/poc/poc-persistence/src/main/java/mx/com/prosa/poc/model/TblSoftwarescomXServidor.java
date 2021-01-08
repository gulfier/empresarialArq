package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the TBL_SOFTWARESCOM_X_SERVIDOR database table.
 * 
 */
@Entity
@Table(name = "TBL_SOFTWARESCOM_X_SERVIDOR")
@IdClass(TblSoftwarescomXServidorPK.class)
public class TblSoftwarescomXServidor implements Serializable {
	
	/** The Constant serialVersionUID. */
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	/** The fk id software. */
	@Id
	@Column(name = "FK_ID_SOFTWARE", nullable = false)
	private Long fkIdSoftware;
	
	/** The fk id server. */
	@Id
	@Column(name = "FK_ID_SERVER",nullable = false,insertable=false, updatable=false)
	private Long fkIdServer;

	/** The tbl software comercial. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SOFTWARE",referencedColumnName = "PK_ID_SOFTWARE", updatable=false,insertable=false)
	private TblSoftwareComercial tblSoftwareComercial;

	/** The tbl servidores. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SERVER",referencedColumnName = "PK_ID_SERVIDOR", updatable=false,insertable=false)
	private TblServidores tblServidores;

	/**
	 * Instantiates a new tbl softwarescom X servidor PK.
	 */
	public TblSoftwarescomXServidor() {
	}
	
	/**
	 * Gets the fk id software.
	 *
	 * @return the fk id software
	 */
	public Long getFkIdSoftware() {
		return this.fkIdSoftware;
	}
	
	/**
	 * Sets the fk id software.
	 *
	 * @param fkIdSoftware the new fk id software
	 */
	public void setFkIdSoftware(Long fkIdSoftware) {
		this.fkIdSoftware = fkIdSoftware;
	}
	
	/**
	 * Gets the fk id server.
	 *
	 * @return the fk id server
	 */
	public Long getFkIdServer() {
		return this.fkIdServer;
	}
	
	/**
	 * Sets the fk id server.
	 *
	 * @param fkIdServer the new fk id server
	 */
	public void setFkIdServer(Long fkIdServer) {
		this.fkIdServer = fkIdServer;
	}

	/**
	 * Gets the tbl software comercial.
	 *
	 * @return the tbl software comercial
	 */
	public TblSoftwareComercial getTblSoftwareComercial() {
		return tblSoftwareComercial;
	}
	
	/**
	 * Sets the tbl software comercial.
	 *
	 * @param tblSoftwareComercial the new tbl software comercial
	 */
	public void setTblSoftwareComercial(TblSoftwareComercial tblSoftwareComercial) {
		this.tblSoftwareComercial = tblSoftwareComercial;
	}
	
	/**
	 * Gets the tbl servidores.
	 *
	 * @return the tbl servidores
	 */
	public TblServidores getTblServidores() {
		return tblServidores;
	}
	
	/**
	 * Sets the tbl servidores.
	 *
	 * @param tblServidores the new tbl servidores
	 */
	public void setTblServidores(TblServidores tblServidores) {
		this.tblServidores = tblServidores;
	}
	
	/**
	 * Equals.
	 *
	 * @param other the other
	 * @return true, if successful
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblSoftwarescomXServidor)) {
			return false;
		}
		TblSoftwarescomXServidor castOther = (TblSoftwarescomXServidor)other;
		return 
			(this.fkIdSoftware == castOther.fkIdSoftware)
			&& (this.fkIdServer == castOther.fkIdServer);
	}

}