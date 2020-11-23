package mx.com.prosa.poc.service;

import mx.com.prosa.poc.util.Jwt;

public interface SecurityService
{

  /**
   * Obtiene el usuario de un token de JWT
   * 
   * @param authorization
   * @return
   */
  String getUser( String authorization );

  /**
   * Valida que el token de JWT soporte los claims
   * 
   * @param authorization
   * @param claims
   */
  void validate( String authorization, Jwt claims );

}
