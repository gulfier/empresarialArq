package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblSoftwareComercial;

/**
 * The Interface TblSoftwareComercialRepository.
 */
public interface TblSoftwareComercialRepository extends JpaRepository<TblSoftwareComercial, Long> {

}
