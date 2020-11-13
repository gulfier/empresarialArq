package mx.com.prosa.poc.util;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.com.prosa.poc.to.BusinessException;

public class JwtUtilTest
{
  private static final String TEST_USERNAME = "guillermo.segura@axity.com";

  private static final String TEST_SCOPE = "api/persistence";

  private static final String TEST_ISSUER = "https://www.prosamexico.mx/";

  private static final String TEST_AUDIENCE = "Interfaz:Mega/Remedy";

  private static final Logger LOG = LoggerFactory.getLogger( JwtUtilTest.class );

  private final static String SECRET_KEY_TEST = "ufCwLft4sYsQeXWkHJTR=rCzWS*e!D&7nJc6RUzVb2Ne6w@4*t_$89@WqKRX59Ft";
  @Test
  public void testCreateToken()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );
    Assert.assertNotNull( token );
    LOG.info( token );
  }

  @Test
  public void testFromToken()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt jwt2 = jwtUtil.fromToken( token );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  @Test
  public void testFromToken2()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt jwt2 = jwtUtil.fromToken( token.substring( 7 ) );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  private Jwt createJwt()
  {
    Jwt jwt = new Jwt();
    jwt.setAudience( TEST_AUDIENCE );
    jwt.setIssuer( TEST_ISSUER );
    jwt.setScope( TEST_SCOPE );
    jwt.setUsername( TEST_USERNAME );
    jwt.setSecretKey( SECRET_KEY_TEST );
    return jwt;
  }

  @Test
  public void testVerifyToken_secret()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );

    Jwt jwt2 = jwtUtil.verifyToken( token, claims );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_null()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    jwtUtil.verifyToken( token, null );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_secretMissing()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();

    jwtUtil.verifyToken( token, claims );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_secret_invalid()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( UUID.randomUUID().toString() );

    jwtUtil.verifyToken( token, claims );
  }

  @Test
  public void testVerifyToken_secretAndAudience()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( TEST_AUDIENCE );

    Jwt jwt2 = jwtUtil.verifyToken( token, claims );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_secretAndAudience_invalid()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( "Another audience" );

    jwtUtil.verifyToken( token, claims );
  }

  @Test
  public void testVerifyToken_secretAndAudienceAndIssuer()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( TEST_AUDIENCE );
    claims.setIssuer( TEST_ISSUER );

    Jwt jwt2 = jwtUtil.verifyToken( token, claims );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_secretAndAudienceAndIssuer_invalid()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( TEST_AUDIENCE );
    claims.setIssuer( "https://google.com" );

    jwtUtil.verifyToken( token, claims );
  }

  @Test
  public void testVerifyToken_secretAndAudienceAndIssuerAndScope()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( TEST_AUDIENCE );
    claims.setIssuer( TEST_ISSUER );
    claims.setScope( TEST_SCOPE );

    Jwt jwt2 = jwtUtil.verifyToken( token, claims );
    Assert.assertNotNull( jwt2 );
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    LOG.info( gson.toJson( jwt2 ) );
  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_secretAndAudienceAndIssuerAndScope_invalid()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );
    claims.setAudience( TEST_AUDIENCE );
    claims.setIssuer( TEST_ISSUER );
    claims.setScope( "api/security" );

    jwtUtil.verifyToken( token, claims );

  }

  @Test(expected = BusinessException.class)
  public void testVerifyToken_expired()
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = createJwt();
    jwt.setExpiration( -1 );
    String token = jwtUtil.createToken( jwt );

    Jwt claims = new Jwt();
    claims.setSecretKey( SECRET_KEY_TEST );

    jwtUtil.verifyToken( token, claims );

  }
}
