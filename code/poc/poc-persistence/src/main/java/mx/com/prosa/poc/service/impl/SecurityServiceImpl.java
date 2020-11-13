package mx.com.prosa.poc.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.prosa.poc.service.SecurityService;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.util.Jwt;
import mx.com.prosa.poc.util.JwtUtil;

/**
 * Implementacion de la interface {@link mx.com.prosa.poc.service.impl.SecurityServiceImpl}
 *
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Service
public class SecurityServiceImpl implements SecurityService
{
  private static final String UNAUTHORIZED = "Unauthorized";

  @Value("${jwt.secretKey}")
  private String secretKey;

  @Value("${jwt.audience}")
  private String audience;

  @Value("${jwt.issuer}")
  private String issuer;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getUser( String authorization )
  {
    JwtUtil jwtUtil = new JwtUtil();
    Jwt jwt = jwtUtil.fromToken( authorization );
    return jwt.getUsername();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void validate( String authorization, Jwt claims )
  {
    if( claims == null )
    {
      throwError();
    }
    claims.setAudience( this.audience );
    claims.setIssuer( this.issuer );
    claims.setSecretKey( this.secretKey );
    
    JwtUtil jwtUtil = new JwtUtil();
    jwtUtil.verifyToken( authorization, claims );
  }

  private void throwError()
  {
    BusinessException e = new BusinessException( UNAUTHORIZED );
    e.getError().setId( 401L );
    e.getError().setUnauthorized( true );
    e.getError().setDescription( UNAUTHORIZED );
    throw e;
  }

}
