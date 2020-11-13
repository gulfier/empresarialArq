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
 * Entity class de la tabla K_SITE
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Entity
@Table(name = "K_SITE")
@Getter
@Setter
public class SiteDO extends AbstractMegaEntity<SiteDO>
{

  private static final long serialVersionUID = -8729898099214711983L;
  @Id
  @Column(name = "ID_SITE")
  @GeneratedValue(generator = "SEQ_SITE", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "SEQ_SITE", sequenceName = "SEQ_SITE", allocationSize = 1, initialValue = 1)
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
  private List<ApplicationDO> applications;

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo( SiteDO that )
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
      SiteDO that = (SiteDO) object;
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
