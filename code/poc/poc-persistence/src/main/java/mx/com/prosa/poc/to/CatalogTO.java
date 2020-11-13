package mx.com.prosa.poc.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CatalogTO.
 */

@Getter
@Setter
public class CatalogTO implements Serializable
{

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4863718221506509821L;

  /** The id. */
  @JsonInclude(Include.NON_NULL)
  protected Long id;

  /** The name. */
  @JsonInclude(Include.NON_NULL)
  protected String name;

}
