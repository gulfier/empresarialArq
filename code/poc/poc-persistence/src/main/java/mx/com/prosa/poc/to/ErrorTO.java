package mx.com.prosa.poc.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ErrorTO.
 */
@Getter
@Setter
public class ErrorTO extends CatalogTO
{

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 6821167174466991022L;

  /** The description. */
  @JsonInclude(Include.NON_NULL)
  private String description;

  /** The trace. */
  @JsonInclude(Include.NON_NULL)
  private String trace;

  /** The bad request. */
  @JsonIgnore
  private boolean badRequest;

  /** Forbidden . */
  @JsonIgnore
  private boolean forbidden;

  /** Unauthorized */
  @JsonIgnore
  private boolean unauthorized;
  
  /** Detail */
  @JsonInclude(Include.NON_NULL)
  private Serializable detail;

}
