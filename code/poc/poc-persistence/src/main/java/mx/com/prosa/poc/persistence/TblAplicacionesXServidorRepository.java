package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblActoresXAplicacion;
import mx.com.prosa.poc.model.TblAplicacionesXServidor;

/**
 * The Interface TblAplicacionesXServidor.
 */
public interface TblAplicacionesXServidorRepository extends JpaRepository<TblAplicacionesXServidor, Long>  {
	
	
	 @Query(value = "SELECT o.* FROM TBL_APLICACIONES_X_SERVIDOR o "
	            + " WHERE o.FK_ID_APLICACION = :idone AND o.FK_ID_SERVIDOR = :idtwo" , nativeQuery = true)
	 Optional<TblAplicacionesXServidor> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);	

}
