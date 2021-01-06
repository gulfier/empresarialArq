package mx.com.prosa.poc.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblProtocolos;

/**
 * Interface de repositorio de IPs {@link mx.com.prosa.poc.model.TblNivelesCifrado}
 * 
 * @author Gulfier leonel L.
 */
public interface TblProtocolosRepository extends JpaRepository<TblProtocolos,Long>
{


}
