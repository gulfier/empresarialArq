package mx.com.prosa.poc.to;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1515442541566298557L;
	
	private String userName;
	private String password;
	private String secret;
	private String audience;
	private String scope;
	private String issued;
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("userName: ");
		cadena.append(userName);
		cadena.append("password: ");
		cadena.append(password);
		cadena.append("secret: ");
		cadena.append(secret);
		cadena.append("audience: ");
		cadena.append(audience);
		cadena.append("scope: ");
		cadena.append(scope);
		cadena.append("issued: ");
		cadena.append(issued);
		return cadena.toString();
	}

}
