package mx.com.prosa.poc.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import mx.com.prosa.poc.to.BusinessException;

/**
 * Utileria para manipular el JWT
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public class JwtUtil
{
  private static final String ERROR_CREATING_TOKEN = "Error creando el token";
  private static final String INVALID_TOKEN = "Token invalido";
  private static final String UNSUPPORTED_ENCODING = "Unsupported encoding";
  private static final String MISSING_KEY_OR_INVALID = "Llave invalida";
  private static final String BEARER = "Bearer ";
  private static final String SCOPE_CLAIM = "scp";

  /**
   * Genera un token de autorizacion
   * 
   * @param jwt Objeto con la informacion del
   * @return
   */
  public String createToken( Jwt jwt )
  {
    Calendar now = Calendar.getInstance();
    Calendar exp = Calendar.getInstance();
    exp.add( Calendar.MINUTE, jwt.getExpiration() );
    String token;
    try
    {
      Algorithm algorithm = Algorithm.HMAC256( jwt.getSecretKey() );
      token = JWT.create().withIssuer( jwt.getIssuer() ) // iss
          .withIssuedAt( now.getTime() ) // iat
          .withSubject( jwt.getUsername() ) // sub
          .withExpiresAt( exp.getTime() ) // exp
          .withAudience( jwt.getAudience() ) // aud
          .withClaim( SCOPE_CLAIM, jwt.getScope() ) // scp
          .sign( algorithm );
    }
    catch( UnsupportedEncodingException | JWTCreationException e )
    {
      BusinessException ex = new BusinessException( ERROR_CREATING_TOKEN, e );
      ex.getError().setId( 500L );
      ex.getError().setBadRequest( false );
      ex.getError().setDescription( ERROR_CREATING_TOKEN );
      throw ex;
    }

    return new StringBuilder().append( BEARER ).append( token ).toString();
  }

  public Jwt fromToken( String token )
  {
    DecodedJWT decodedJWT = JWT.decode( cleanToken( token ) );
    Jwt jwt = transformToJwt( decodedJWT );

    return jwt;
  }

  private Jwt transformToJwt( DecodedJWT decodedJWT )
  {
    StringBuilder audience = new StringBuilder();
    decodedJWT.getAudience().stream().forEach( aud -> {
      audience.append( aud ).append( "," );
    } );
    String aud = "";
    if( audience.length() > 2 )
    {
      aud = audience.substring( 0, audience.length() - 1 );
    }

    Jwt jwt = new Jwt();
    jwt.setAudience( aud );
    jwt.setIssuer( decodedJWT.getIssuer() );
    jwt.setScope( decodedJWT.getClaim( SCOPE_CLAIM ).asString() );
    jwt.setUsername( decodedJWT.getSubject() );
    return jwt;
  }

  private String cleanToken( String token )
  {
    Pattern pattern = Pattern.compile( BEARER, Pattern.CASE_INSENSITIVE );
    Matcher matcher = pattern.matcher( token );

    String value;
    if( matcher.find() )
    {
      value = matcher.replaceFirst( "" );
    }
    else
    {
      value = token;
    }
    return value;
  }

  /**
   * Verifica un token de JWT de acuerdo a los claims
   * 
   * @param token JSON Web Token
   * @param claims
   * @return
   */
  public Jwt verifyToken( String token, Jwt claims )
  {
    DecodedJWT decodedJWT;

    validateClaims( claims );

    try
    {
      Algorithm algorithm = Algorithm.HMAC256( claims.getSecretKey() );
      Verification verification = JWT.require( algorithm );

      if( StringUtils.isNotBlank( claims.getAudience() ) )
      {
        verification.withAudience( claims.getAudience() );
      }

      if( StringUtils.isNotBlank( claims.getIssuer() ) )
      {
        verification.withIssuer( claims.getIssuer() );
      }
      if( StringUtils.isNotBlank( claims.getScope() ) )
      {
        verification.withClaim( SCOPE_CLAIM, claims.getScope() );
      }

      JWTVerifier verifier = verification.build();
      decodedJWT = verifier.verify( cleanToken( token ) );
    }
    catch( UnsupportedEncodingException e )
    {
      BusinessException ex = new BusinessException( UNSUPPORTED_ENCODING, e );
      ex.getError().setId( 401L );
      ex.getError().setUnauthorized( true );
      ex.getError().setDescription( UNSUPPORTED_ENCODING );
      throw ex;
    }
    catch( JWTVerificationException e )
    {
      BusinessException ex = new BusinessException( INVALID_TOKEN, e );
      ex.getError().setId( 401L );
      ex.getError().setUnauthorized( true );
      ex.getError().setDescription( INVALID_TOKEN );
      throw ex;
    }

    return transformToJwt( decodedJWT );
  }

  private void validateClaims( Jwt claims )
  {
    if( claims == null || StringUtils.isBlank( claims.getSecretKey() ) )
    {
      BusinessException e = new BusinessException( MISSING_KEY_OR_INVALID );
      e.getError().setId( 500L );
      e.getError().setBadRequest( false );
      e.getError().setDescription( MISSING_KEY_OR_INVALID );
      throw e;
    }
  }
}
