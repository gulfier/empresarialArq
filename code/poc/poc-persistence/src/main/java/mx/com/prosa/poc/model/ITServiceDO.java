package mx.com.prosa.poc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class de la tabla K_IT_SERVICE
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Entity
@Table(name = "K_IT_SERVICE")
@Getter
@Setter
public class ITServiceDO extends AbstractMegaEntity<ITServiceDO>
{

  private static final long serialVersionUID = 8463720335798959163L;

  @Id
  @Column(name = "ID_IT_SERVICE")
  @GeneratedValue(generator = "SEQ_IT_SERVICE", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "SEQ_IT_SERVICE", sequenceName = "SEQ_IT_SERVICE", allocationSize = 1, initialValue = 1)
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "itService")
  private List<ApplicationDO> applications;

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo( ITServiceDO that )
  {
    return new CompareToBuilder().append( this.id, that.id ).toComparison();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals( Object object )
  {

    boolean isEquals = false;
    if( this == object )
    {
      isEquals = true;
    }
    else if( object != null && object.getClass().equals( this.getClass() ) )
    {
      ITServiceDO that = (ITServiceDO) object;
      isEquals = new EqualsBuilder().append( this.id, that.id ).isEquals();
    }
    return isEquals;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    return new HashCodeBuilder().append( this.id ).hashCode();
  }

}
