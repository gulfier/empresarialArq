package mx.com.prosa.poc.to;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Transfer object base
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class BaseTO implements Serializable
{

  private static final long serialVersionUID = 8268621426705589426L;

  @JsonInclude(Include.NON_NULL)
  protected Long id;

  @JsonInclude(Include.NON_NULL)
  protected String name;

  @JsonInclude(Include.NON_NULL)
  protected String code;

  @JsonInclude(Include.NON_NULL)
  protected Date creation;

  @JsonInclude(Include.NON_NULL)
  protected Date modified;

  @JsonInclude(Include.NON_NULL)
  protected String userCreation;

  @JsonInclude(Include.NON_NULL)
  protected String userModified;

  @JsonInclude(Include.NON_NULL)
  protected String ip;

  @JsonInclude(Include.NON_NULL)
  protected String user;

  @JsonIgnore
  protected String token;

  /**
   * {@inheritDoc}
   */
  public String toString()
  {
    return new GsonBuilder().create().toJson( this );
  }
}
