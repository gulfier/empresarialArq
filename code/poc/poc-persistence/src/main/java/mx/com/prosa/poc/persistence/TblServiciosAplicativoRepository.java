package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblServiciosAplicativo;

/**
 * The Interface TblServiciosAplicativoRepository.
 */
public interface TblServiciosAplicativoRepository extends JpaRepository<TblServiciosAplicativo, Long> {

}
