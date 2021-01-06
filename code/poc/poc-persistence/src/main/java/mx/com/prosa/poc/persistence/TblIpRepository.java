package mx.com.prosa.poc.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblIp;

/**
 * Interface de repositorio de IPs {@link mx.com.prosa.poc.model.TBLIP}
 * 
 * @author Gulfier leonel L.
 */
public interface TblIpRepository extends JpaRepository<TblIp,Long>
{


}
