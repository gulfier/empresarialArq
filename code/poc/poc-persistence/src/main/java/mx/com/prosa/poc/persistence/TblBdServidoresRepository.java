package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblBdServidores;

/**
 * The Interface TblBdServidoresRepository.
 */
public interface TblBdServidoresRepository extends JpaRepository<TblBdServidores, Long> {

	
	 @Query(value = "SELECT o FROM TBL_BD_SERVIDORES o "
	            + " WHERE o.FK_ID_SERVIDOR = :idone AND o.FK_ID_BASE_DATOS = :idtwo" , nativeQuery = true)
	 Optional<TblBdServidores> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);	
}
