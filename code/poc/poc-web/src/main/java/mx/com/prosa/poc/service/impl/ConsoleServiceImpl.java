package mx.com.prosa.poc.service.impl;

import org.springframework.stereotype.Service;

import mx.com.prosa.poc.service.ConsoleService;
import mx.com.prosa.poc.to.CredentialTO;
import mx.com.prosa.poc.to.TokenTO;
import mx.com.prosa.poc.util.Jwt;
import mx.com.prosa.poc.util.JwtUtil;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	
	public TokenTO createToken(CredentialTO credential) {
		JwtUtil jwUtil = new JwtUtil();
		System.out.println("Data: "+credential.toString());
		String token = jwUtil.createToken(createJwt(credential));
		System.out.println("token: "+token);
		TokenTO response = new TokenTO();
		response.setToken(token);
		return response;
	}
	
	private Jwt createJwt(CredentialTO credential){
		Jwt jwt = new Jwt();
		jwt.setAudience( credential.getAudience() );
		jwt.setIssuer( credential.getIssued() );
		jwt.setScope( credential.getScope() );
		jwt.setUsername( credential.getUserName() );
		jwt.setSecretKey( credential.getSecret() );
		jwt.setExpiration(999999999);
		return jwt;
	}
}
