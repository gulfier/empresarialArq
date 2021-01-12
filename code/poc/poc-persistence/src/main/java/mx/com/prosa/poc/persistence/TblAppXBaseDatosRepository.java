package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblAppXBaseDatos;

public interface TblAppXBaseDatosRepository extends JpaRepository<TblAppXBaseDatos, Long> {

}
