package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.SiteDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.SiteDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface SiteRepository extends JpaRepository<SiteDO, Long>
{

  /**
   * Busca un site por medio de su codigo
   * 
   * @param code Codigo del Site
   * @return
   */
  @Query("SELECT o FROM SiteDO o WHERE o.code = :code ")
  Optional<SiteDO> findByCode( @Param("code") String code );
}
