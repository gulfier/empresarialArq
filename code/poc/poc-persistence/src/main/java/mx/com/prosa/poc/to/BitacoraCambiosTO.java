package mx.com.prosa.poc.to;

import java.util.Date;



import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object de sitios
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class BitacoraCambiosTO extends BaseTO
{

  private static final long serialVersionUID = 6844642665904947290L;

  
  private Long id;
  
  private Integer dsCodigo;
  
  private Date fecha;
  
  private String dsDescripcion;
  
  private String dsTipo;
  
  private String dsAutor;

  private String dsCambioActual;

  private String dsCambioAnterior;
  
  private Integer dsEstatus;
  
  
}
