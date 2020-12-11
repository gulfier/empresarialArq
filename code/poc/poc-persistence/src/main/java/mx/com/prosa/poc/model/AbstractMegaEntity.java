package mx.com.prosa.poc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * Super clase de las entidades de Mega
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 *
 * @param <T>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractMegaEntity<T> extends AbstractEntity<T>
{

  private static final long serialVersionUID = 7852754173408662085L;

  @Column(name = "DS_CODE", nullable = false, unique = true)
  protected String code;

  @Column(name = "DS_NAME", nullable = false)
  protected String name;

  @Column(name = "DT_CREATION", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  protected Date creation;



  @Column(name = "DS_USER_CREATION", nullable = false)
  protected String userCreation;



}
