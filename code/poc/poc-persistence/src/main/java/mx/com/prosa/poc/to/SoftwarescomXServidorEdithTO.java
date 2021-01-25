package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the update.
 *
 * @return the update
 */
@Getter

/**
 * Sets the update.
 *
 * @param update the new update
 */
@Setter
public class SoftwarescomXServidorEdithTO extends BaseTO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8871607636957538982L;
	
	/** The table. */
	public SoftwarescomXServidorTO table;
	
	/** The update. */
	public SoftwarescomXServidorTO update;
}
