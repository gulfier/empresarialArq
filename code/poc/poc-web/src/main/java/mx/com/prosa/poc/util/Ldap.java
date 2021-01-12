package mx.com.prosa.poc.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.ldaptive.AddOperation;
import org.ldaptive.AddRequest;
import org.ldaptive.AttributeModification;
import org.ldaptive.AttributeModificationType;
import org.ldaptive.BindConnectionInitializer;
import org.ldaptive.Connection;
import org.ldaptive.ConnectionConfig;
import org.ldaptive.ConnectionFactory;
import org.ldaptive.Credential;
import org.ldaptive.DefaultConnectionFactory;
import org.ldaptive.DeleteOperation;
import org.ldaptive.DeleteRequest;
import org.ldaptive.LdapAttribute;
import org.ldaptive.LdapEntry;
import org.ldaptive.LdapException;
import org.ldaptive.ModifyOperation;
import org.ldaptive.ModifyRequest;
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
import org.ldaptive.auth.BindAuthenticationHandler;
import org.ldaptive.auth.CompareAuthenticationHandler;
import org.ldaptive.auth.SearchDnResolver;
import org.ldaptive.auth.ext.PasswordPolicyAuthenticationResponseHandler;
import org.ldaptive.control.PasswordPolicyControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;


@Component
public class Ldap {

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



    @Autowired
    private Environment env;

    @Autowired
    private ContextSource contextSource;

    @Autowired
    private LdapTemplate ldapTemplate;

    private ConnectionFactory loginLdap() {

        logger.info("inicio loginLdap");
        final ConnectionConfig connConfig = new ConnectionConfig(ldapUrl);
        // connConfig.setUseStartTLS(true);

        logger.info("inicio loginLdap ldapsecurityPrincipal [{}]", ldapsecurityPrincipal);

        connConfig.setConnectionInitializer(
                new BindConnectionInitializer(ldapsecurityPrincipal, new Credential(ldapsecurityCredencial)));
        final ConnectionFactory cf = new DefaultConnectionFactory(connConfig);
        logger.info("inicio loginLdap cf [{}]", cf);

        final SearchExecutor executor = new SearchExecutor();
        executor.setBaseDn(ldapBase);

        logger.info("inicio loginLdap executor [{}]", executor);
        logger.info("inicio loginLdap executor [{}]", executor);

        return cf;
    }

    private ConnectionFactory loginLdapSL() {

        logger.info("inicio loginLdap");
        final ConnectionConfig connConfig = new ConnectionConfig(ldapUrl);
        // connConfig.setUseStartTLS(true);

        logger.info("inicio loginLdap ldapsecurityPrincipal [{}]", ldapsecurityPrincipal);

        connConfig.setConnectionInitializer(
                new BindConnectionInitializer(ldapsecurityPrincipal, new Credential(ldapsecurityCredencial)));
        connConfig.setUseSSL(true);
        final ConnectionFactory cf = new DefaultConnectionFactory(connConfig);
        logger.info("inicio loginLdap cf [{}]", cf);

        final SearchExecutor executor = new SearchExecutor();
        executor.setBaseDn(ldapBase);

        logger.info("inicio loginLdap executor [{}]", executor);
        logger.info("inicio loginLdap executor [{}]", executor);

        return cf;
    }

    private String findUser(final String username) throws Exception {
        final ConnectionFactory connection = loginLdap();
        ;

        String user = "";
        Connection conn = null;
        String base = findUniqueMember(username);
        try {
            //logger.info(" connection [{}]", connection);
            //logger.info(" connection [{}]", connection.getConnection());
            conn = connection.getConnection();
            //logger.info(" conn [{}]", conn);
            conn.open();
            //logger.info(" conn  open [{}]", conn);
            final SearchFilter filter = new SearchFilter("(uid={uid})");
            filter.setParameter("uid", username);
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
                logger.info(" entry [{}]", entry);
                //logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                user = entry.getAttribute("userPassword").getStringValue();
                //logger.info(" user [{}]", user);
            }
        }
        catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("Usuario y/o contraseña incorrecto");
        } finally {
            conn.close();
        }
        return user;
    }



    public String findUniqueMember(final String username) throws Exception {
        final ConnectionFactory connection = loginLdap();
        ;

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
                    logger.info(" entry [{}]", entry.toString());

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
                            logger.info(" base [{}]",base);
                            return base;
                        }
                    }


                }
                //logger.info(" userPassword [{}]", entry.getAttribute("userPassword").getStringValue());
                //user = entry.getAttribute("userPassword").getStringValue();
                //logger.info(" user [{}]", user);
            }
            logger.error("Usuario incorrecto");
        }
        catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("Usuario incorrecto");
        } finally {
            conn.close();
        }
        return "";
    }



    public void validPasswordUserSSHA(final String password, final String user) throws Exception {

        final ConnectionFactory connection = loginLdap();

        try {

            final SearchDnResolver dnResolver = new SearchDnResolver(connection);
            dnResolver.setBaseDn(ldapParams);
            dnResolver.setUserFilter("uid={user}");
            logger.info("SearchDnResolver [{}]", dnResolver);
            final BindAuthenticationHandler authHandler = new BindAuthenticationHandler(connection);
            authHandler.setAuthenticationControls(new PasswordPolicyControl());
            logger.info("authHandler [{}]", authHandler);

            final Authenticator auth = new Authenticator(dnResolver, authHandler);
            auth.setAuthenticationResponseHandlers(new PasswordPolicyAuthenticationResponseHandler());

            final AuthenticationCriteria authenticationCriteria = new AuthenticationCriteria();
            authenticationCriteria.setDn(ldapParams);

            final Credential cred = new Credential(password);
            final AuthenticationRequest authenticationRequest = new AuthenticationRequest(user, cred);
            authenticationCriteria.setAuthenticationRequest(authenticationRequest);

            final AuthenticationResponse response2 = auth.authenticate(authenticationRequest);
            if (response2 == null || response2
                    .getAuthenticationResultCode() != AuthenticationResultCode.AUTHENTICATION_HANDLER_SUCCESS) {
                logger.error(response2.toString());
                logger.error("Usuario y/o contraseña incorrecto");
            }

        } catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("Usuario y/o contraseña incorrecto");
        }
    }

    private void validPasswordUser(final String password, final String user) throws Exception {

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
            logger.info("authenticationHandler [{}]", authenticationHandler.getPasswordAttribute());
            logger.info("authenticationHandler [{}]", authenticationHandler.getPasswordScheme());

            final AuthenticationCriteria authenticationCriteria = new AuthenticationCriteria();
            authenticationCriteria.setDn(ldapParams);

            final Credential cred = new Credential(password);
            final AuthenticationRequest authenticationRequest = new AuthenticationRequest(user, cred);
            authenticationCriteria.setAuthenticationRequest(authenticationRequest);

            final Authenticator auth2 = new Authenticator(dnResolver, authenticationHandler);
            auth2.setAuthenticationResponseHandlers(new PasswordPolicyAuthenticationResponseHandler());
            final Credential credential = new Credential(password);

            final AuthenticationRequest authenticationRequest2 = new AuthenticationRequest(user, credential);
            logger.info("authenticationRequest [{}]", authenticationRequest2.toString());
            final AuthenticationResponse response2 = auth2.authenticate(authenticationRequest2);
            if (response2 == null || response2
                    .getAuthenticationResultCode() != AuthenticationResultCode.AUTHENTICATION_HANDLER_SUCCESS) {
                logger.error(response2.toString());
                logger.error("Usuario y/o contraseña incorrecto");
            }

        } catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("Usuario y/o contraseña incorrecto");
        }
    }

    public boolean addUser(final String mail, final String name, final String ldapKey, final String password)
            throws Exception {
        final ConnectionFactory connection = loginLdap();
        ;

        Connection conn = null;
        final LdapEntry entry = new LdapEntry("uid=" + mail + "," + ldapParams,
                new LdapAttribute("objectClass", "inetOrgPerson", "organizationalPerson", "person", "top"),
                new LdapAttribute("uid", mail), new LdapAttribute("sn", name), new LdapAttribute("cn", ldapKey),
                new LdapAttribute("userPassword", password));

        try {
            conn = connection.getConnection();
            conn.open();
            final AddOperation add = new AddOperation(conn);

            add.execute(new AddRequest(entry.getDn(), entry.getAttributes()));
        } catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("El usuario ya existe");
        } finally {
            conn.close();
        }

        return true;
    }

    public boolean editPass(final String username, final String password, final String newPassword)
            throws Exception {

        if (StringUtils.isBlank(username))
        	logger.error("El usuario no puede estar vacio");
        else if (StringUtils.isBlank(password))
        	logger.error("La contraseña no puede estar vacia");
        else if (StringUtils.isBlank(newPassword))
        	logger.error("La nueva contraseña no puede estar vacia");

        logger.info("inicia cambio contraeña ");
        try {
            String user = findUser(username);
            logger.info("USUARIO ENCONTRADO: {}", user);
            validPasswordUser(password,username);
        } catch (Exception e) {
        	logger.error("Contraseña incorrecta");
        }

        try {
            logger.info("Las contraseñas coinciden");

            if (password.equals(newPassword))
            	logger.error("La nueva contraseña no puede ser igual a la anterior");

            changePassword(username, newPassword);
        } catch (final Exception e) {
            logger.error(e.getMessage());
            logger.error("La contraseña no pudo ser cambiada");
        }

        return true;
    }

    public void changePassword(final String username, final String newPassword) throws Exception {

        final ConnectionFactory connection = loginLdap();
        ;

        Connection conn = null;
        try {
            conn = connection.getConnection();
            conn.open();
            final ModifyOperation modify = new ModifyOperation(conn);
            modify.execute(new ModifyRequest("uid=" + username + "," + ldapParams,

                    new AttributeModification(AttributeModificationType.REPLACE,
                            new LdapAttribute("userPassword", newPassword))));
        } catch (final LdapException e) {
            logger.error(e.getMessage());
            logger.error("La contraseña no pudo ser cambiada");
        } finally {
            conn.close();
        }

    }

    public void deleteUser(final String username) throws Exception {

        final ConnectionFactory connection = loginLdap();
        ;

        Connection conn = null;
        try {
            conn = connection.getConnection();
            conn.open();
            final DeleteOperation delete = new DeleteOperation(conn);
            delete.execute(new DeleteRequest("uid=" + username + "," + ldapParams));
        } catch (final LdapException e) {
            logger.error(e.getMessage());
        } finally {
            conn.close();
        }
    }

    public String get_SHA_512_SecurePassword(final String passwordToHash, final String salt) {
        String generatedPassword = null;
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            final byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}

