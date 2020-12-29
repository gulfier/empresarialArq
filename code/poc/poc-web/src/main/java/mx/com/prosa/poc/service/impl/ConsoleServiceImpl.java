package mx.com.prosa.poc.service.impl;

import java.io.IOException;
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
import org.ldaptive.LdapUtils;
import org.ldaptive.Response;
import org.ldaptive.SearchExecutor;
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
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.service.ConsoleService;
import mx.com.prosa.poc.to.CredentialTO;
import mx.com.prosa.poc.to.TokenTO;
import mx.com.prosa.poc.util.Jwt;
import mx.com.prosa.poc.util.JwtUtil;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	
	public String findUniqueMember(final String username) throws Exception {
        final ConnectionFactory connection = loginLdap();
        ;
        
        String ldapGroups = "ou=People,dc=example,dc=com";

        String user = "";
        Connection conn = null;
        try {
            //logger.info(" connection [{}]", connection);
            //logger.info(" connection [{}]", connection.getConnection());
            conn = connection.getConnection();
            //logger.info(" conn [{}]", conn);
            conn.open();
            //logger.info(" conn  open [{}]", conn);
            final SearchFilter filter = new SearchFilter("(cn=*)");
           // filter.setParameter("uid", username);
            //logger.info(" filter [{}]", filter);
            //logger.info(" conn [{}]", conn.isOpen());
            final SearchOperation search = new SearchOperation(conn);
           // logger.info(" search [{}]", search);
            //final SearchResult result = search.execute(new SearchRequest(ldapParams, filter)).getResult();
            //logger.info("ldapGroups [{}]", ldapGroups);
            final Response searchRequest = search.execute(new SearchRequest(ldapGroups, filter));
            //logger.info("response [{}]", searchRequest);
            final SearchResult result = (SearchResult) searchRequest.getResult();
            //logger.info(" result [{}]", result);

            for (final LdapEntry entry : result.getEntries()) { // if you're expecting multiple entries
                if( entry.toString().replaceAll(" ", "").contains("uid="+username)){
//                    logger.info(" entry [{}]", entry.toString());

                    LdapAttribute ldapAttribute = entry.getAttribute("uniqueMember");
                    //logger.info(" entry [{}]",ldapAttribute);

                    //logger.info(" entry [{}]", ldapAttribute.getStringValues());
                    Collection<String> uids=   ldapAttribute.getStringValues();


                    Iterator<String> iterator = uids.iterator();

                    while (iterator.hasNext()) {
                        String uid =  iterator.next().toString();
                        //logger.info("  [{}]",uid);

                        if(uid.replaceAll(" ", "").contains("uid="+username)){
                            String base = uid.replaceAll("uid="+username+',', "");
//                            logger.info(" base [{}]",base);
                            return base;
                        }
                    }


                }
                //logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                //user = entry.getAttribute("userPassword").getStringValue();
                //logger.info(" user [{}]", user);
            }
            throw new Exception();
        }
        catch (final LdapException e) {
//            logger.error(e.getMessage());
            e.printStackTrace();
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
        	validPasswordUser("Barbara Jensen","password");
//        	String base = findUniqueMember("Barbara Jensen");
        	String base = "";
            conn = connection.getConnection();
            //logger.info(" conn [{}]", conn);
            conn.open();
            //logger.info(" conn  open [{}]", conn);
            final SearchFilter filter = new SearchFilter("(uid={uid})");
            filter.setParameter("uid", "Barbara Jensen");
            //logger.info(" filter [{}]", filter);
            //logger.info(" conn [{}]", conn.isOpen());
            final SearchOperation search = new SearchOperation(conn);
            //logger.info(" search [{}]", search);
            //final SearchResult result = search.execute(new SearchRequest(ldapParams, filter)).getResult();
            final Response searchRequest = search.execute(new SearchRequest(base, filter));
            //logger.info("response [{}]", searchRequest);
            final SearchResult result = (SearchResult) searchRequest.getResult();
            //logger.info(" result [{}]", result);
            for (final LdapEntry entry : result.getEntries()) { // if you're expecting multiple entries
//                logger.info(" entry [{}]", entry);
                //logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                user = entry.getAttribute("userPassword").getStringValue();
                //logger.info(" user [{}]", user);
            }
        }
        catch (final LdapException e) {
//            logger.error(e.getMessage());
        	e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("User "+user);
		JwtUtil jwUtil = new JwtUtil();
		System.out.println("Data: "+credential.toString());
		String token = jwUtil.createToken(createJwt(credential));
		System.out.println("token: "+token);
		TokenTO response = new TokenTO();
		response.setToken(token);
		return response;
	}
	
	private void validPasswordUser(final String password, final String user) {
		String ldapParams = "ou=People,dc=example,dc=com";
        final ConnectionFactory connection = loginLdapSL();

        // Connection conn = null;
        try {
            // conn = connection.getConnection();

            final SearchDnResolver dnResolver = new SearchDnResolver(connection);
            dnResolver.setBaseDn(ldapParams);
            dnResolver.setUserFilter("uid={user}");
            // logger.info("SearchDnResolver [{}]", dnResolver);
            // final BindAuthenticationHandler authHandler = new
            // BindAuthenticationHandler(connection);
            // authHandler.setAuthenticationControls(new PasswordPolicyControl());
            // logger.info("authHandler [{}]", authHandler);

            // final Authenticator auth = new Authenticator(dnResolver, authHandler);
            // auth.setAuthenticationResponseHandlers(new
            // PasswordPolicyAuthenticationResponseHandler());
            // logger.info("auth [{}]", auth);
            final CompareAuthenticationHandler authenticationHandler = new CompareAuthenticationHandler(connection);

            // Set<String> messageDigest = Security.getAlgorithms("MessageDigest");
            // messageDigest.forEach(x -> System.out.println(x));

            //authenticationHandler.setPasswordAttribute(ldapAttribute);
            //authenticationHandler.setPasswordScheme(ldapScheme);
//            logger.info("authenticationHandler [{}]", authenticationHandler.getPasswordAttribute());
//            logger.info("authenticationHandler [{}]", authenticationHandler.getPasswordScheme());

            final AuthenticationCriteria authenticationCriteria = new AuthenticationCriteria();
            authenticationCriteria.setDn(ldapParams);

            final Credential cred = new Credential(password);
            final AuthenticationRequest authenticationRequest = new AuthenticationRequest(user, cred);
            authenticationCriteria.setAuthenticationRequest(authenticationRequest);

            final Authenticator auth2 = new Authenticator(dnResolver, authenticationHandler);
            auth2.setAuthenticationResponseHandlers(new PasswordPolicyAuthenticationResponseHandler());
            final Credential credential = new Credential(password);

            final AuthenticationRequest authenticationRequest2 = new AuthenticationRequest(user, credential);
//            logger.info("authenticationRequest [{}]", authenticationRequest2.toString());
            final AuthenticationResponse response2 = auth2.authenticate(authenticationRequest2);
            if (response2 == null || response2
                    .getAuthenticationResultCode() != AuthenticationResultCode.AUTHENTICATION_HANDLER_SUCCESS) {
//                logger.error(response2.toString());
//                throw new GeneralException(ErrorCode.INCORRECT_PASS, "Usuario y/o contraseña incorrecto");
            		System.out.println("Usuario y/o contraseña incorrecto");
            }

        } catch (final LdapException e) {
//            logger.error(e.getMessage());
//            throw new GeneralException(ErrorCode.INCORRECT_PASS, "Usuario y/o contraseña incorrecto");
        	System.out.println(e.getMessage());
        }
    }
	
	private ConnectionFactory loginLdapSL() {
		String ldapsecurityPrincipal = "cn=Accounting Managers,ou=Groups,dc=example,dc=com";
		String ldapsecurityCredencial = "Axity2019";
		String ldapBase = "dc=example,dc=com";

//        logger.info("inicio loginLdap");
        final ConnectionConfig connConfig = new ConnectionConfig("ldaps://192.168.0.21:1636");
        // connConfig.setUseStartTLS(true);

//        logger.info("inicio loginLdap ldapsecurityPrincipal [{}]", ldapsecurityPrincipal);

        connConfig.setConnectionInitializer(
                new BindConnectionInitializer(ldapsecurityPrincipal, new Credential(ldapsecurityCredencial)));
        connConfig.setUseSSL(true);
        final ConnectionFactory cf = new DefaultConnectionFactory(connConfig);
//        logger.info("inicio loginLdap cf [{}]", cf);

        final SearchExecutor executor = new SearchExecutor();
        executor.setBaseDn(ldapBase);

//        logger.info("inicio loginLdap executor [{}]", executor);
//        logger.info("inicio loginLdap executor [{}]", executor);

        return cf;
    }
	
	private ConnectionFactory loginLdap() {
		  String ldapsecurityPrincipal = "cn=Accounting Managers,ou=Groups,dc=example,dc=com";
		  String ldapsecurityCredencial = "Axity2019";
		  String ldapBase = "dc=example,dc=com";
	      final ConnectionConfig connConfig = new ConnectionConfig("ldaps://localhost:1636");
	      // connConfig.setUseStartTLS(true);

    	  connConfig.setConnectionInitializer(
	              new BindConnectionInitializer(ldapsecurityPrincipal, new Credential(
	            		  ldapsecurityCredencial.getBytes())));
	      final ConnectionFactory cf = new DefaultConnectionFactory(connConfig);
//	      logger.info("inicio loginLdap cf [{}]", cf);

	      final SearchExecutor executor = new SearchExecutor();
	      executor.setBaseDn(ldapBase);

//	      logger.info("inicio loginLdap executor [{}]", executor);
//	      logger.info("inicio loginLdap executor [{}]", executor);

	      return cf;
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
