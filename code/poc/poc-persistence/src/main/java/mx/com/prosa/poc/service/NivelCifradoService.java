/*
 * 
 */
package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.NivelCifradoTO;

public interface NivelCifradoService {

	/**
	 * Guarda nivel de cifrado
	 * 
	 * @param NivelCifradoTO
	 */
	void save(NivelCifradoTO nivel);

	/**
	 * Edits the.
	 *
	 * @param levelSecurity the level security
	 * @return the boolean
	 */
	Boolean edit(NivelCifradoTO levelSecurity);

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean delete(Long id);
}
