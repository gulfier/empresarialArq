package mx.com.prosa.poc.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblComponentesRed;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.TblComponentesRed}
 * 
 * @author Gulfier Leonel L.
 */
public interface TblComponentesRedRepository extends JpaRepository<TblComponentesRed,Long>
{


}
