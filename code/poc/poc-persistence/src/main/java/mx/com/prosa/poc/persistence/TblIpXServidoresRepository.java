package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblIpXServidores;

public interface TblIpXServidoresRepository extends JpaRepository<TblIpXServidores, Long> {
	 @Query(value = "SELECT o FROM TBL_IP_X_SERVIDORES o "
	            + " WHERE o.FK_ID_IP = :idone AND o.FK_ID_SERVIDOR = :idtwo" , nativeQuery = true)
	 Optional<TblIpXServidores> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);
}
