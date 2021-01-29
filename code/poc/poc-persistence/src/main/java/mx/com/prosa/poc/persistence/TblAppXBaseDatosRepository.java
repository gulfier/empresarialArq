package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblAppXBaseDatos;

public interface TblAppXBaseDatosRepository extends JpaRepository<TblAppXBaseDatos, Long> {
	
	 @Query(value = "SELECT o.* FROM TBL_APP_X_BASE_DATOS o "
	            + " WHERE o.FK_ID_APLICACION = :idone AND o.FK_ID_BASE = :idtwo" , nativeQuery = true)
	 Optional<TblAppXBaseDatos> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);	

}
