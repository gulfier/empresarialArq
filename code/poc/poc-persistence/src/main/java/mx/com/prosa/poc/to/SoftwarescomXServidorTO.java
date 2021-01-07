package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;
import mx.com.prosa.poc.model.TblServidores;
import mx.com.prosa.poc.model.TblSoftwareComercial;

// TODO: Auto-generated Javadoc
/**
 * Gets the fk id server.
 *
 * @return the fk id server
 */
@Getter

/**
 * Sets the fk id server.
 *
 * @param fkIdServer the new fk id server
 */
@Setter
public class SoftwarescomXServidorTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5809860400045074477L;
	
	/** The fk id software. */
	private Long fkIdSoftware;
	
	/** The fk id server. */
	private Long fkIdServer;
}
