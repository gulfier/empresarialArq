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
 * The persistent class for the TBL_IP_X_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_IP_X_SERVIDORES")
@IdClass(TblIpXServidoresPK.class)
public class TblIpXServidores implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6865785773069503373L;
	
	/** The fk id ip. */
	@Id
	@Column(name="FK_ID_IP")
	private Long fkIdIp;

	/** The fk id servidor. */
	@Id
	@Column(name="FK_ID_SERVIDOR")
	private Long fkIdServidor;
	
	/** The tbl software comercial. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_IP",referencedColumnName = "PK_ID_IP", updatable=false,insertable=false)
	private TblIp tblIp;

	/** The tbl servidores. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SERVIDOR",referencedColumnName = "PK_ID_SERVIDOR", updatable=false,insertable=false)
	private TblServidores tblServidores;

	/**
	 * Instantiates a new tbl ip X servidores.
	 */
	public TblIpXServidores() {
	}
	
	/**
	 * Gets the fk id ip.
	 *
	 * @return the fk id ip
	 */
	public Long getFkIdIp() {
		return this.fkIdIp;
	}
	
	/**
	 * Sets the fk id ip.
	 *
	 * @param fkIdIp the new fk id ip
	 */
	public void setFkIdIp(Long fkIdIp) {
		this.fkIdIp = fkIdIp;
	}
	
	/**
	 * Gets the fk id servidor.
	 *
	 * @return the fk id servidor
	 */
	public Long getFkIdServidor() {
		return this.fkIdServidor;
	}
	
	/**
	 * Sets the fk id servidor.
	 *
	 * @param fkIdServidor the new fk id servidor
	 */
	public void setFkIdServidor(Long fkIdServidor) {
		this.fkIdServidor = fkIdServidor;
	}
	
	
	/**
	 * Gets the tbl ip.
	 *
	 * @return the tbl ip
	 */
	public TblIp getTblIp() {
		return tblIp;
	}
	
	/**
	 * Sets the tbl ip.
	 *
	 * @param tblIp the new tbl ip
	 */
	public void setTblIp(TblIp tblIp) {
		this.tblIp = tblIp;
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

}