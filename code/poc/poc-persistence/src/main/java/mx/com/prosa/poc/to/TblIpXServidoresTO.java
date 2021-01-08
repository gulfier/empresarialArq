package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the fk id servidor.
 *
 * @return the fk id servidor
 */
@Getter

/**
 * Sets the fk id servidor.
 *
 * @param fkIdServidor the new fk id servidor
 */
@Setter
public class TblIpXServidoresTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2404397933651780123L;
	
	/** The fk id ip. */
	private Long fkIdIp;
	
	/** The fk id servidor. */
	private Long fkIdServidor;
}
