package mx.com.prosa.poc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class de la tabla K_APPLICATION
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Entity
@Table(name = "K_APPLICATION")
@Getter
@Setter
public class ApplicationDO extends AbstractMegaEntity<ApplicationDO>
{

  private static final long serialVersionUID = -4963453756076422569L;

  @Id
  @Column(name = "ID_APPLICATION")
  @GeneratedValue(generator = "SEQ_APPLICATION", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "SEQ_APPLICATION", sequenceName = "SEQ_APPLICATION", allocationSize = 1, initialValue = 1)
  private Long id;

  @Lob
  @Column(name = "DS_COMMENT", nullable = true)
  private String comment;

  @ManyToOne
  @JoinColumn(name = "ID_SITE", referencedColumnName = "ID_SITE", nullable = false)
  private SiteDO site;

  @ManyToOne
  @JoinColumn(name = "ID_IT_SERVICE", referencedColumnName = "ID_IT_SERVICE", nullable = false)
  private ITServiceDO itService;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "K_APPLICATION_X_SERVER", joinColumns = {
      @JoinColumn(name = "ID_APPLICATION", referencedColumnName = "ID_APPLICATION") }, inverseJoinColumns = {
          @JoinColumn(name = "ID_SERVER", referencedColumnName = "ID_SERVER") })
  private List<ServerDO> servers;

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo( ApplicationDO that )
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
      ApplicationDO that = (ApplicationDO) object;
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
