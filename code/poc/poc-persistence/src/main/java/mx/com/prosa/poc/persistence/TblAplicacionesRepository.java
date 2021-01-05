package mx.com.prosa.poc.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblAplicaciones;

/**
 * Interface de repositorio para la entidad {@link mx.com.prosa.poc.model.BitacoraCambiosDO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public interface TblAplicacionesRepository extends JpaRepository<TblAplicaciones,Long>
{


}
