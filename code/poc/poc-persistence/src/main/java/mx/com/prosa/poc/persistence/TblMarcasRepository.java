package mx.com.prosa.poc.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblMarcas;

/**
 * Interface de repositorio de IPs {@link mx.com.prosa.poc.model.TblMarcas}
 * 
 * @author Gulfier leonel L.
 */
public interface TblMarcasRepository extends JpaRepository<TblMarcas,Long>
{


}
