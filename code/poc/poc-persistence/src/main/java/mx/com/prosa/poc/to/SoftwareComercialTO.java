package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Sets the fk id marca.
 *
 * @param fkIdMarca the new fk id marca
 */
@Setter

/**
 * Gets the fk id marca.
 *
 * @return the fk id marca
 */
@Getter
public class SoftwareComercialTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2689197375636951668L;
	
	/** The pk id software. */
	private Long pkIdSoftware;
	
	/** The ds nombre. */
	private String dsNombre;
	
	/** The ds tipo. */
	private String dsTipo;
	
	/** The ds version. */
	private String dsVersion;
	
	/** The fk id marca. */
	private Long fkIdMarca;
}
