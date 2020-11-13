package mx.com.prosa.poc.to;

import java.io.Serializable;
import java.util.Date;

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
  protected Long id;
  protected String name;
  protected String code;
  protected Date creation;
  protected Date modified;
  protected String userCreation;
  protected String userModified;
  protected String ip;
  protected String user;
  protected String token;

  /**
   * {@inheritDoc}
   */
  public String toString()
  {
    return new GsonBuilder().create().toJson( this );
  }
}
