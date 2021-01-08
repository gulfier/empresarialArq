package mx.com.prosa.poc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.prosa.poc.model.TblIpXServidores;

public interface TblIpXServidoresRepository extends JpaRepository<TblIpXServidores, Long> {
	
}
