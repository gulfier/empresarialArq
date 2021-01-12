package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the fk id responsable.
 *
 * @return the fk id responsable
 */
@Getter

/**
 * Sets the fk id responsable.
 *
 * @param fkIdResponsable the new fk id responsable
 */
@Setter
public class UbicacionTO extends BaseTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 361235339134489640L;

	/** The pk id ubicacion. */
	private Long pkIdUbicacion;
	
	/** The ds ciudad. */
	private String dsCiudad;
	
	/** The ds code. */
	private String dsCode;
	
	/** The ds descripcion. */
	private String dsDescripcion;
	
	/** The ds direccion. */
	private String dsDireccion;
	
	/** The ds estado. */
	private String dsEstado;
	
	/** The ds name. */
	private String dsName;
	
	/** The ds nombre. */
	private String dsNombre;
	
	/** The ds pais. */
	private String dsPais;
	
	/** The ds pci. */
	private String dsPci;
	
	/** The ds tipo. */
	private String dsTipo;
	
	/** The ds user creation. */
	private String dsUserCreation;
	
	/** The ds user modification. */
	private String dsUserModification;
	
	/** The dt creation. */
	private String dtCreation;
	
	/** The dt modified. */
	private String dtModified;
	
	/** The fk id responsable. */
	private Long fkIdResponsable;
}
