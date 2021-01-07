package mx.com.prosa.poc.model;

import java.io.Serializable;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDetailPk.
 */
public class TblSoftwarescomXServidorPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4604912464734807317L;

	/** The fk id software. */
	@Column(name = "FK_ID_SOFTWARE", nullable = false)
	private Long fkIdSoftware;
	
	/** The fk id server. */
	@Column(name = "FK_ID_SERVER", nullable = false)
	private Long fkIdServer;

	/**
	 * Gets the fk id software.
	 *
	 * @return the fk id software
	 */
	public Long getFkIdSoftware() {
		return fkIdSoftware;
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
		return fkIdServer;
	}

	/**
	 * Sets the fk id server.
	 *
	 * @param fkIdServer the new fk id server
	 */
	public void setFkIdServer(Long fkIdServer) {
		this.fkIdServer = fkIdServer;
	}

}
