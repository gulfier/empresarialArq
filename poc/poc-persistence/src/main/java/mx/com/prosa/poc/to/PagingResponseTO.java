package mx.com.prosa.poc.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Respuesta de un consulta paginada
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 * @param <T>
 */
@Getter
@Setter
public class PagingResponseTO<T extends BaseTO>
{

  private List<T> data;
  private long records;
  private int pages;
  private int page;
  private int size;
}
