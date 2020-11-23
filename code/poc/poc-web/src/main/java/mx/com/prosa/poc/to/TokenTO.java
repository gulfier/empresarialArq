package mx.com.prosa.poc.to;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1737733775934196155L;
	
	private String token;
}
