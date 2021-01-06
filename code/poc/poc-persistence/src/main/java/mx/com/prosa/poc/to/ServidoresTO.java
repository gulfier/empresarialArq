package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Sets the fk id ubicacion.
 *
 * @param fkIdUbicacion the new fk id ubicacion
 */
@Setter

/**
 * Gets the fk id ubicacion.
 *
 * @return the fk id ubicacion
 */
@Getter
public class ServidoresTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -769254753077544733L;
	
	/** The pk id servidor. */
	private long pkIdServidor;
	
	/** The ds ambiente. */
	private String dsAmbiente;
	
	/** The ds code. */
	private String dsCode;
	
	/** The ds descripcion. */
	private String dsDescripcion;
	
	/** The ds host name. */
	private String dsHostName;
	
	/** The ds marca modelo. */
	private String dsMarcaModelo;
	
	/** The ds name. */
	private String dsName;
	
	/** The ds pci. */
	private String dsPci;
	
	/** The ds proposito. */
	private String dsProposito;
	
	/** The ds tipo. */
	private String dsTipo;
	
	/** The ds user creation. */
	private String dsUserCreation;
	
	/** The ds user modification. */
	private String dsUserModification;
	
	/** The ds virtualizacion. */
	private String dsVirtualizacion;
	
	/** The dt creation. */
	private String dtCreation;
	
	/** The dt modified. */
	private String dtModified;
	
	/** The fk id responsable. */
	private Long fkIdResponsable;
	
	/** The fk id ubicacion. */
	private Long fkIdUbicacion;
}
