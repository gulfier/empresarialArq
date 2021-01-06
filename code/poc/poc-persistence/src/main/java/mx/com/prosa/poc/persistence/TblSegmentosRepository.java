package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblSegmentos;

public interface TblSegmentosRepository extends JpaRepository<TblSegmentos, Long>  {

}
