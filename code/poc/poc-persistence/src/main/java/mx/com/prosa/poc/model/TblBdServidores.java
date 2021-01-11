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
 * The persistent class for the TBL_BD_SERVIDORES database table.
 * 
 */
@Entity
@Table(name="TBL_BD_SERVIDORES")
@IdClass(TblBdServidoresPK.class)
public class TblBdServidores implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6850165839078711328L;

	/** The fk id base datos. */
	@Id
	@Column(name="FK_ID_BASE_DATOS")
	private Long fkIdBaseDatos;

	/** The fk id servidor. */
	@Id
	@Column(name="FK_ID_SERVIDOR")
	private Long fkIdServidor;
	
	/** The tbl base datos. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_BASE_DATOS",referencedColumnName = "PK_ID_BASE", updatable=false,insertable=false)
	private TblBaseDatos tblBaseDatos;

	/** The tbl servidores. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ID_SERVIDOR",referencedColumnName = "PK_ID_SERVIDOR", updatable=false,insertable=false)
	private TblServidores tblServidores;

	/**
	 * Instantiates a new tbl bd servidores.
	 */
	public TblBdServidores() {
	}
	
	/**
	 * Gets the fk id base datos.
	 *
	 * @return the fk id base datos
	 */
	public Long getFkIdBaseDatos() {
		return this.fkIdBaseDatos;
	}
	
	/**
	 * Sets the fk id base datos.
	 *
	 * @param fkIdBaseDatos the new fk id base datos
	 */
	public void setFkIdBaseDatos(Long fkIdBaseDatos) {
		this.fkIdBaseDatos = fkIdBaseDatos;
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
	 * Gets the tbl base datos.
	 *
	 * @return the tbl base datos
	 */
	public TblBaseDatos getTblBaseDatos() {
		return tblBaseDatos;
	}
	
	/**
	 * Sets the tbl base datos.
	 *
	 * @param tblBaseDatos the new tbl base datos
	 */
	public void setTblBaseDatos(TblBaseDatos tblBaseDatos) {
		this.tblBaseDatos = tblBaseDatos;
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