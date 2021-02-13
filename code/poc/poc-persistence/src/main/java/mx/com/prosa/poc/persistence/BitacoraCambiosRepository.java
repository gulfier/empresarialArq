package mx.com.prosa.poc.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.BitacoraCambiosDO;

// TODO: Auto-generated Javadoc
/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.BitacoraCambiosDO}
 * 
 * @author Jorge Ortega Hernández <jorgeortega30@live.com.mx>
 */
public interface BitacoraCambiosRepository extends JpaRepository<BitacoraCambiosDO,Long>
{
	
	/**
	 * Find all cambios.
	 *
	 * @param paginacion the paginacion
	 * @return the list
	 */
	@Query(value = "SELECT e"
			 + " FROM BitacoraCambiosDO e"
			 + " WHERE e.dsEstatus = 1")
	List<BitacoraCambiosDO> findAllCambios(Pageable paginacion);
	
	/**
	 * Count changes.
	 *
	 * @return the long
	 */
	@Query(value = "select count(PK_ID_BITACORA) from TBL_BITACORA_CAMBIOS WHERE ID_ESTATUS=1", nativeQuery= true)
	Long countChanges();
	
	/**
	 * History.
	 *
	 * @param paginacion the paginacion
	 * @return the list
	 */
	@Query(value = "SELECT e"
			 + " FROM BitacoraCambiosDO e "
			 + " WHERE e.dsEstatus != 1")
	List<BitacoraCambiosDO> history(Pageable paginacion);
	
	/**
	 * Filter history.
	 *
	 * @param paginacion the paginacion
	 * @param type the type
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return the list
	 */
	@Query(value = "SELECT t FROM BitacoraCambiosDO t"
			+ " WHERE t.dsTipo = :type AND t.dsEstatus != 1"
			+ " AND t.fecha BETWEEN :initDate AND :endDate"
			+ " ORDER BY t.fecha")
	List<BitacoraCambiosDO> filterHistory(Pageable paginacion,@Param("type") String type,
			@Param("initDate") Date initDate,@Param("endDate") Date endDate);
	
	/**
	 * Filter history type.
	 *
	 * @param paginacion the paginacion
	 * @param type the type
	 * @return the list
	 */
	@Query(value = "SELECT t FROM BitacoraCambiosDO t"
			+ " WHERE t.dsTipo = :type AND t.dsEstatus != 1")
	List<BitacoraCambiosDO> filterHistoryType(Pageable paginacion,@Param("type") String type);
	
	/**
	 * Count changes with filters.
	 *
	 * @param type the type
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return the long
	 */
	@Query(value = "select count(t.id) from BitacoraCambiosDO t"
			+ " WHERE t.dsTipo = :type AND t.dsEstatus != 1"
			+ " AND t.fecha BETWEEN :initDate AND :endDate"
			+ " ORDER BY t.fecha")
	Long countChangesWithFilters(@Param("type") String type,
			@Param("initDate") Date initDate,@Param("endDate") Date endDate);
	
	/**
	 * Count changes with type.
	 *
	 * @param type the type
	 * @return the long
	 */
	@Query(value = "select count(t.id) from BitacoraCambiosDO t"
			+ " WHERE t.dsTipo = :type AND t.dsEstatus != 1")
	Long countChangesWithType(@Param("type") String type);
}
