package mx.com.prosa.poc.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.BitacoraCambiosDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.BitacoraCambiosDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface BitacoraCambiosRepository extends JpaRepository<BitacoraCambiosDO,Long>, PagingAndSortingRepository<BitacoraCambiosDO,Long>
{

    @Query(value = "SELECT * FROM tbl_bitacora_cambios "
            + " ORDER BY pk_id_bitacora ASC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY" , nativeQuery = true)
    List<BitacoraCambiosDO> findAllCambios();
	
}
