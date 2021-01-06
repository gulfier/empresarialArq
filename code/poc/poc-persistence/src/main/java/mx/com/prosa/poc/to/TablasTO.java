package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the fk id base.
 *
 * @return the fk id base
 */
@Getter

/**
 * Sets the fk id base.
 *
 * @param fkIdBase the new fk id base
 */
@Setter
public class TablasTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5541588884376762115L;
	
	/** The pk id tabla. */
	private long pkIdTabla;
	
	/** The ds tabla. */
	private String dsTabla;
	
	/** The fk id base. */
	private Long fkIdBase;
}
