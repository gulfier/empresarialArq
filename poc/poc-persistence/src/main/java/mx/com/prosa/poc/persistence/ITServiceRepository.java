package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.ITServiceDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.ITServiceDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface ITServiceRepository extends JpaRepository<ITServiceDO, Long>
{

  /**
   * Busca una IT Service por medio de su codigo
   * 
   * @param code Codigo del IT Service
   * @return
   */
  @Query("SELECT o FROM ITServiceDO o WHERE o.code = :code ")
  Optional<ITServiceDO> findByCode( @Param("code") String code );

}
