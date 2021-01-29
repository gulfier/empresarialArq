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
public class BdServidoresEditTO extends BaseTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4865350223128693645L;
	/**
	 * 
	 */
	private BdServidoresTO table;
	private BdServidoresTO update;

}
