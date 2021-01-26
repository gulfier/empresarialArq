package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.prosa.poc.model.TblIpXServidores;

@Repository
@Transactional
public interface TblIpXServidoresRepository extends JpaRepository<TblIpXServidores, Long> {
	 @Query(value = "SELECT * FROM TBL_IP_X_SERVIDORES "
	            + " WHERE FK_ID_IP = :idone AND FK_ID_SERVIDOR = :idtwo" , nativeQuery = true)
	 Optional<TblIpXServidores> findTable(@Param("idone") Long idone,@Param("idtwo") Long idtwo);
}
