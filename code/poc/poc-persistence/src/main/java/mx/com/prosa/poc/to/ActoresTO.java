package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the dt modified.
 *
 * @return the dt modified
 */
@Getter

/**
 * Sets the dt modified.
 *
 * @param dtModified the new dt modified
 */
@Setter
public class ActoresTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5200897936507157830L;
	
	/** The pk id actor. */
	private long pkIdActor;
	
	/** The ds code. */
	private String dsCode;
	
	/** The ds descripcion. */
	private String dsDescripcion;
	
	/** The ds name. */
	private String dsName;
	
	/** The ds nombre. */
	private String dsNombre;
	
	/** The ds pci. */
	private String dsPci;
	
	/** The ds user creation. */
	private String dsUserCreation;
	
	/** The ds user modification. */
	private String dsUserModification;
	
	/** The dt creation. */
	private String dtCreation;
	
	/** The dt modified. */
	private String dtModified;
}
