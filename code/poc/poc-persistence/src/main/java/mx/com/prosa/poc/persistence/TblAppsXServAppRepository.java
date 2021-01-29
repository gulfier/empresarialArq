package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblAppsXServApp;

/**
 * The Interface TblAppsXServAppRepository.
 */
public interface TblAppsXServAppRepository extends JpaRepository<TblAppsXServApp, Long> {

	
	 @Query(value = "SELECT * FROM TBL_APPS_X_SERV_APP o "
	            + " WHERE o.FK_ID_APLICACION = :idone AND o.FK_ID_SERVICIO = :idtwo" , nativeQuery = true)
	 Optional<TblAppsXServApp> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);	
	
}
