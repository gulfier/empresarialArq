package mx.com.prosa.poc.to;

import lombok.Getter;
import lombok.Setter;
import mx.com.prosa.poc.model.TblAplicacionesXServidor;

@Getter
@Setter
public class AplicacionesXservidorEdithTO extends BaseTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5611964884880118483L;
	private AplicacionesXServidorTO table;
	private AplicacionesXServidorTO update;
}
