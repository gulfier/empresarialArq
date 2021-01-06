package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblUbicaciones;

public interface TblServidoresRepository extends JpaRepository<TblUbicaciones, Long> {
	
}
