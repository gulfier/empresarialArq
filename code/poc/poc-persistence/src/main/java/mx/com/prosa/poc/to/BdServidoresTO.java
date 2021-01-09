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
public class BdServidoresTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5681504807467893578L;

	/** The fk id base datos. */
	private long fkIdBaseDatos;

	/** The fk id servidor. */
	private long fkIdServidor;
}
