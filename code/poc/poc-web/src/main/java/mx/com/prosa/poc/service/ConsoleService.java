package mx.com.prosa.poc.service;

import mx.com.prosa.poc.to.CredentialTO;
import mx.com.prosa.poc.to.TokenTO;

public interface ConsoleService {
	public TokenTO createToken(CredentialTO credential);
}
