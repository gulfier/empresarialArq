package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;

/**
 * Consulta paginada de {@link mx.com.prosa.poc.to.BaseTO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 * @param <T> Objeto base
 */
@Getter
@Setter
public class PagingRequestTO<T extends BaseTO>
{
  private T search;
  private int page;
  private int size;
  private String sortBy;
  private Direction direction;
  protected String ip;
  protected String user;
  protected String token;

  /**
   * Enumeracion para la direccion de la consulta paginada
   * 
   * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
   */
  public enum Direction
  {
    ASC, DESC
  };
}
