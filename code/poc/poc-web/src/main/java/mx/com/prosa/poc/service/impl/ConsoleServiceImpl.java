package mx.com.prosa.poc.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.ldaptive.BindConnectionInitializer;
import org.ldaptive.Connection;
import org.ldaptive.ConnectionConfig;
import org.ldaptive.ConnectionFactory;
import org.ldaptive.Credential;
import org.ldaptive.DefaultConnectionFactory;
import org.ldaptive.LdapAttribute;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.Response;
import org.ldaptive.SearchFilter;
import org.ldaptive.SearchOperation;
import org.ldaptive.SearchRequest;
import org.ldaptive.SearchResult;
import org.ldaptive.auth.AuthenticationCriteria;
import org.ldaptive.auth.AuthenticationRequest;
import org.ldaptive.auth.AuthenticationResponse;
import org.ldaptive.auth.AuthenticationResultCode;
import org.ldaptive.auth.Authenticator;
import org.ldaptive.auth.CompareAuthenticationHandler;
import org.ldaptive.auth.SearchDnResolver;
import org.ldaptive.auth.ext.PasswordPolicyAuthenticationResponseHandler;
import org.ldaptive.ssl.KeyStoreCredentialConfig;
import org.ldaptive.ssl.SslConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.service.ConsoleService;
import mx.com.prosa.poc.to.CredentialTO;
import mx.com.prosa.poc.to.TokenTO;
import mx.com.prosa.poc.util.Jwt;
import mx.com.prosa.poc.util.JwtUtil;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${ldap.key.params}")
    private String ldapParams;

    @Value("${ldap.key.url}")
    private String ldapUrl;
    @Value("${ldap.key.security.principal}")
    private String ldapsecurityPrincipal;
    @Value("${ldap.key.security.credencial}")
    private String ldapsecurityCredencial;
    @Value("${ldap.key.base}")
    private String ldapBase;


    @Value("${ldap.key.params.groups}")
    private String ldapGroups;
	
	public String findUniqueMember(final String username) throws Exception {
        final ConnectionFactory connection = loginLdap();

        String user = "";
        Connection conn = null;
        try {
            logger.info(" connection [{}]", connection);
            logger.info(" connection [{}]", connection.getConnection());
            conn = connection.getConnection();
            logger.info("conn: [{}]", conn);
            conn.open();
            logger.info(" conn  open [{}]", conn);
            final SearchFilter filter = new SearchFilter("(cn=*)");
            logger.info(" filter [{}]", filter);
            logger.info("conn [{}]", conn.isOpen());
            final SearchOperation search = new SearchOperation(conn);
            logger.info(" search [{}]", search);
            logger.info("ldapGroups [{}]", ldapGroups);
            final Response<SearchResult> searchRequest = search.execute(new SearchRequest(ldapGroups, filter));
            logger.info("response [{}]", searchRequest);
            final SearchResult result = searchRequest.getResult();
            logger.info(" result [{}]", result);

            for (final LdapEntry entry : result.getEntries()) { // if you're expecting multiple entries
                if( entry.toString().replaceAll(" ", "").contains("uid="+username)){
                    logger.info(" entry [{}]", entry.toString());

                    LdapAttribute ldapAttribute = entry.getAttribute("uniqueMember");
                    logger.info(" entry [{}]",ldapAttribute);

                    logger.info(" entry [{}]", ldapAttribute.getStringValues());
                    Collection<String> uids=   ldapAttribute.getStringValues();


                    Iterator<String> iterator = uids.iterator();

                    while (iterator.hasNext()) {
                        String uid =  iterator.next().toString();
                        logger.info("  [{}]",uid);

                        if(uid.replaceAll(" ", "").contains("uid="+username)){
                            String base = uid.replaceAll("uid="+username+',', "");
                            logger.info(" base [{}]",base);
                            return base;
                        }
                    }


                }
                logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                logger.info(" user [{}]", user);
            }
            throw new Exception();
        }
        catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error(e.getMatchedDn());
            logger.error(e.getResultCode().toString());
            logger.error(e.getStackTrace().toString());
            logger.error(e.getSuppressed().toString());
            return "";
        } finally {
            conn.close();
        }
    }
	
	public TokenTO createToken(CredentialTO credential) {
		final ConnectionFactory connection = loginLdap();
		;
		
		String user = "";
        Connection conn = null;
        try {
        	validPasswordUser(credential.getPassword(),credential.getUserName());
        	String base = "";
            conn = connection.getConnection();
            logger.info(" conn [{}]", conn);
            conn.open();
            logger.info(" conn  open [{}]", conn);
            final SearchFilter filter = new SearchFilter("(uid={uid})");
            filter.setParameter("uid", "Barbara Jensen");
            logger.info(" filter [{}]", filter);
            logger.info(" conn [{}]", conn.isOpen());
            final SearchOperation search = new SearchOperation(conn);
            logger.info(" search [{}]", search);
            final Response<SearchResult> searchRequest = search.execute(new SearchRequest(base, filter));
            logger.info("response [{}]", searchRequest);
            final SearchResult result = searchRequest.getResult();
            logger.info(" result [{}]", result);
            for (final LdapEntry entry : result.getEntries()) { // if you're expecting multiple entries
                logger.info(" entry [{}]", entry);
                logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                user = entry.getAttribute("userPassword").getStringValue();
                logger.info(" user [{}]", user);
            }
        }
        catch (final LdapException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
        	logger.error(e.getMessage());
		}
        
		logger.info(user);
		JwtUtil jwUtil = new JwtUtil();
		logger.info(credential.toString());
		String token = jwUtil.createToken(createJwt(credential));
		logger.info(token);
		TokenTO response = new TokenTO();
		response.setToken(token);
		return response;
	}
	
	private void validPasswordUser(final String password, final String user) {
		ConnectionFactory connection = loginLdap();
		try {
        	
            final SearchDnResolver dnResolver = new SearchDnResolver(connection);
            dnResolver.setBaseDn(ldapParams);
            dnResolver.setUserFilter("uid={user}");
            final CompareAuthenticationHandler authenticationHandler = new CompareAuthenticationHandler(connection);
            final AuthenticationCriteria authenticationCriteria = new AuthenticationCriteria();
            authenticationCriteria.setDn(ldapParams);
            final Credential cred = new Credential(password);
            final AuthenticationRequest authenticationRequest = new AuthenticationRequest(user, cred);
            authenticationCriteria.setAuthenticationRequest(authenticationRequest);
            final Authenticator auth2 = new Authenticator(dnResolver, authenticationHandler);
            auth2.setAuthenticationResponseHandlers(new PasswordPolicyAuthenticationResponseHandler());
            final Credential credential = new Credential(password);
            final AuthenticationRequest authenticationRequest2 = new AuthenticationRequest(user, credential);
            final AuthenticationResponse response2 = auth2.authenticate(authenticationRequest2);
            if (response2 == null || response2
                    .getAuthenticationResultCode() != AuthenticationResultCode.AUTHENTICATION_HANDLER_SUCCESS) {
		                logger.error(response2.toString());
		            	logger.error("Usuario y/o contraseña incorrecto");
		            }

        } catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error(e.getMatchedDn());
            logger.error(e.getResultCode().toString());
            logger.error(e.getStackTrace().toString());
            logger.error(e.getSuppressed().toString());
        	logger.error("Usuario y/o contraseña incorrecto");
        }
    }
	
	private ConnectionFactory loginLdap() {
		ConnectionConfig cc = new ConnectionConfig(ldapUrl);
    	cc.setConnectionInitializer(new BindConnectionInitializer(ldapParams, new Credential(ldapsecurityCredencial)));
    	SslConfig sslconf = new SslConfig();
    	KeyStoreCredentialConfig keystore = new KeyStoreCredentialConfig();
    	keystore.setKeyStore("classpath:/cacerts");
    	keystore.setKeyStorePassword("changeit");
    	sslconf.setCredentialConfig(keystore);
    	cc.setSslConfig(sslconf);
    	cc.setUseSSL(true);
    	cc.setUseStartTLS(true);
    	return new DefaultConnectionFactory(cc);
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
