package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.ApplicationDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.ApplicationDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ApplicationRepository extends JpaRepository<ApplicationDO, Long>
{

  /**
   * Busca una aplicacion por medio de su codigo
   * 
   * @param code Codigo de la aplicacion
   * @return
   */
  @Query("SELECT o FROM ApplicationDO o WHERE o.code = :code ")
  Optional<ApplicationDO> findByCode( @Param("code") String code );

  /**
   * Cuenta los registros de aplicaciones asociados a un IT Service id
   * 
   * @param itServiceId
   * @return
   */
  @Query("SELECT COUNT(o) FROM ApplicationDO o WHERE o.itService.id = :itServiceId")
  Long countByITServiceId( @Param("itServiceId") Long itServiceId );

  /**
   * Cuenta los registros de aplicaciones asociados a un Site Id
   * 
   * @param siteId
   * @return
   */
  @Query("SELECT COUNT(o) FROM ApplicationDO o WHERE o.site.id = :siteId")
  Long countBySiteId( @Param("siteId") Long siteId );
}
