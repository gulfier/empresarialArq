package mx.com.prosa.poc.to;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Respuesta
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 * @param <T>
 */
@Getter
@Setter
public class Response<T extends Serializable> implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 2873273101577446183L;
  private int code;
  private String message;
  private T t;
}
