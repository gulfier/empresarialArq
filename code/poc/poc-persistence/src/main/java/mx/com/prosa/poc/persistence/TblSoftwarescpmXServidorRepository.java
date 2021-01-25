package mx.com.prosa.poc.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblSoftwarescomXServidor;

// TODO: Auto-generated Javadoc
/**
 * The Interface TblSoftwarescpmXServidorRepository.
 */
public interface TblSoftwarescpmXServidorRepository extends JpaRepository<TblSoftwarescomXServidor, Long> {
	
	/**
	 * Find table.
	 *
	 * @param idone the idone
	 * @param idtwo the idtwo
	 * @return the optional
	 */
	@Query(value = "SELECT o FROM TBL_SOFTWARESCOM_X_SERVIDOR o "
			+ " WHERE o.FK_ID_SOFTWARE = :idone AND o.FK_ID_SERVER = :idtwo", nativeQuery = true)
	Optional<TblSoftwarescomXServidor> findTable(@Param("idone") Long idone, @Param("idtwo") Long idtwo);
}
