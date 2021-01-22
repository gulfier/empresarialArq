package mx.com.prosa.poc.persistence;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblTablas;

/**
 * The Interface TblTablasRepository.
 */
public interface TblTablasRepository extends JpaRepository<TblTablas, Long> {

}
