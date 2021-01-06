package mx.com.prosa.poc.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.prosa.poc.model.TblActores;
import mx.com.prosa.poc.model.TblUbicaciones;

// TODO: Auto-generated Javadoc
/**
 * The Interface TblActorRepository.
 */
public interface TblActorRepository extends JpaRepository<TblActores, Long>  {
	
	/**
	 * Gets the by fiid.
	 *
	 * @param fiid the fiid
	 * @return the by fiid
	 */
	@Query(value = "select e from TblActore e where e.pkIdActor = :fiid")
	List<TblUbicaciones> getByFiid(@Param("fiid") String fiid);
}