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
public class SegmentosTO extends BaseTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 780038339582664042L;

	/** The pk id segmento. */
	private long pkIdSegmento;
	
	/** The ds descrpcion. */
	private String dsDescrpcion;
	
	/** The ds nombre. */
	private String dsNombre;
	
	/** The ds pci. */
	private String dsPci;
	
	/** The ds rango ip inicia. */
	private String dsRangoIpInicia;
	
	/** The ds rango ip termina. */
	private String dsRangoIpTermina;
	
	/** The ds tipo. */
	private String dsTipo;
	
	/** The fk id ubicacion. */
	private Long fkIdUbicacion;
}
