package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Sets the fk id base.
 *
 * @param fkIdBase the new fk id base
 */
@Setter

/**
 * Gets the fk id base.
 *
 * @return the fk id base
 */
@Getter
public class AppXBaseDatosTO extends BaseTO{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4444427410111791052L;
	
	/** The fk id aplicacion. */
	private Long fkIdAplicacion;
	
	/** The fk id base. */
	private Long fkIdBase;
}
