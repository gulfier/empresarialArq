package mx.com.prosa.poc.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.prosa.poc.model.BitacoraCambiosDO;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.BitacoraCambiosDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface BitacoraCambiosRepository extends JpaRepository<BitacoraCambiosDO,Long>
{

//    @Query(value = "SELECT * FROM tbl_bitacora_cambios "
//            + "ORDER BY pk_id_bitacora ASC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY" , nativeQuery = true)
//    List<BitacoraCambiosDO> findAllCambios();
	
	@Query(value = "SELECT e"
			 + " FROM BitacoraCambiosDO e ")
	List<BitacoraCambiosDO> findAllCambios(Pageable paginacion);
	
	@Query(value = "select count(PK_ID_BITACORA) from TBL_BITACORA_CAMBIOS", nativeQuery= true)
	Long countChanges();
}
