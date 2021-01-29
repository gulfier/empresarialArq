package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblActoresXAplicacion;

/**
 * The Interface TblActoresXAplicacionRepository.
 */
public interface TblActoresXAplicacionRepository extends JpaRepository<TblActoresXAplicacion, Long> {
	
	 @Query(value = "SELECT * FROM TBL_ACTORES_X_APLICACION o "
	            + " WHERE o.FK_ID_ACTOR = :idone AND o.FK_ID_APLICACION = :idtwo" , nativeQuery = true)
	 Optional<TblActoresXAplicacion> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);	

}
