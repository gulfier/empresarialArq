package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.ServerDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.ServerDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ServerRepository extends JpaRepository<ServerDO, Long>
{

  /**
   * Busca un servidor por medio de su codigo
   * 
   * @param code Codigo del servidor
   * @return
   */
  @Query("SELECT o FROM ServerDO o WHERE o.code = :code ")
  Optional<ServerDO> findByCode( @Param("code") String code );

  /**
   * Cuenta las aplicaciones asociadas a un servidor
   * 
   * @param serverId
   * @return
   */
  @Query("SELECT COUNT(a.id) FROM ServerDO o JOIN o.applications a WHERE o.id = :serverId")
  Long countApplicationAssociatedByServerId( @Param("serverId") Long serverId );
}
