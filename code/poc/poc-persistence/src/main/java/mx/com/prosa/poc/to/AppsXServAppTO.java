package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the fk id servicio.
 *
 * @return the fk id servicio
 */
@Getter

/**
 * Sets the fk id servicio.
 *
 * @param fkIdServicio the new fk id servicio
 */
@Setter
public class AppsXServAppTO extends BaseTO{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4649352340981030504L;
	
	/** The fk id aplicacion. */
	private Long fkIdAplicacion;
	
	/** The fk id servicio. */
	private Long fkIdServicio;
}
