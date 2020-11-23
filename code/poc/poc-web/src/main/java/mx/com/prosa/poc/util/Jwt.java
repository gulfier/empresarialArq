package mx.com.prosa.poc.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase de atributos para el Json Web Token
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Getter
@Setter
public class Jwt
{

  /** Usuario */
  private String username;

  /** Emisor del JWT */
  private String issuer;

  /** Audiencia */
  private String audience;

  /** Scope */
  private String scope;

  /** Llave secreta */
  private String secretKey;

  /** Tiempo de expiracion en minutos, default 5 minutos */
  private int expiration = 5;

}
