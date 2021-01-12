package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Sets the fk id aplicacion.
 *
 * @param fkIdAplicacion the new fk id aplicacion
 */
@Setter

/**
 * Gets the fk id aplicacion.
 *
 * @return the fk id aplicacion
 */
@Getter
public class ActoresXAplicacionTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7359258303365304858L;
	
	/** The fk id actor. */
	private long fkIdActor;
	
	/** The fk id aplicacion. */
	private long fkIdAplicacion;
}
