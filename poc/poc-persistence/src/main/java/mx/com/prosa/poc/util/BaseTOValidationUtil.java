package mx.com.prosa.poc.util;

import org.apache.commons.lang3.StringUtils;

import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BusinessException;

/**
 * Clase de validacion de {@link mx.com.prosa.poc.to.BaseTO}
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public final class BaseTOValidationUtil
{

  private static final String DATOS_INCORRECTOS_NULL = "Datos incorrectos: null";
  private static final String DATOS_INCORRECTOS_USER = "Datos incorrectos: user";
  private static final String DATOS_INCORRECTOS_ID = "Datos incorrectos: id";
  private static final String DATOS_INCORRECTOS_NAME = "Datos incorrectos: name";
  private static final String DATOS_INCORRECTOS_CODE = "Datos incorrectos: code";
  private static final String DATOS_INCORRECTOS = "Datos incorrectos";

  private BaseTOValidationUtil()
  {
    // Se ofusca el constructor
  }

  /**
   * Valida los valores requeridos de un objeto de transferencia para su guardado, en caso de error lanza la excepcion
   * de runtime {@link mx.com.prosa.poc.to.BusinessException} correspondientes <br>
   * Valida lo siguiente:
   * <ul>
   * <li>El objecto no sea nulo
   * <li>El codigo no sea nulo ni vacio
   * <li>El nombre no sea nulo ni vacio
   * <li>El user no sea nulo ni vacio
   * </ul>
   * 
   * @param baseTO Objeto a validar
   */
  public static void validateSave( BaseTO baseTO )
  {
    validateNotNull( baseTO );

    if( StringUtils.isBlank( baseTO.getCode() ) )
    {
      BusinessException e = new BusinessException( DATOS_INCORRECTOS );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( DATOS_INCORRECTOS_CODE );
      throw e;
    }

    if( StringUtils.isBlank( baseTO.getName() ) )
    {
      BusinessException e = new BusinessException( DATOS_INCORRECTOS );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( DATOS_INCORRECTOS_NAME );
      throw e;
    }

    validateUser( baseTO );
  }

  /**
   * Valida los valores requeridos de un objeto de transferencia para su guardado, en caso de error lanza la excepcion
   * de runtime {@link mx.com.prosa.poc.to.BusinessException} correspondientes <br>
   * Valida lo siguiente:
   * <ul>
   * <li>El objecto no sea nulo
   * <li>El id no sea nulo
   * <li>El codigo no sea nulo ni vacio
   * <li>El nombre no sea nulo ni vacio
   * <li>El user no sea nulo ni vacio
   * </ul>
   * 
   * @param baseTO Objeto a validar
   */
  public static void validateEdit( BaseTO baseTO )
  {
    validateSave( baseTO );
    validateIdNotNull( baseTO );
  }

  /**
   * Valida los valores requeridos de un objeto de transferencia para su eliminacion, en caso de error lanza la
   * excepcion de runtime {@link mx.com.prosa.poc.to.BusinessException} correspondientes <br>
   * Valida lo siguiente:
   * <ul>
   * <li>El objecto no sea nulo
   * <li>El id no sea nulo
   * </ul>
   * 
   * @param baseTO Objeto a avalidar
   */
  public static void validateDelete( BaseTO baseTO )
  {
    validateNotNull( baseTO );
    validateIdNotNull( baseTO );
  }

  private static void validateNotNull( BaseTO baseTO )
  {
    if( baseTO == null )
    {
      BusinessException e = new BusinessException( DATOS_INCORRECTOS );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( DATOS_INCORRECTOS_NULL );
      throw e;
    }
  }

  private static void validateIdNotNull( BaseTO baseTO )
  {
    if( baseTO.getId() == null )
    {
      BusinessException e = new BusinessException( DATOS_INCORRECTOS );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( DATOS_INCORRECTOS_ID );
      throw e;
    }
  }

  private static void validateUser( BaseTO baseTO )
  {
    if( StringUtils.isBlank( baseTO.getUser() ) )
    {
      BusinessException e = new BusinessException( DATOS_INCORRECTOS );
      e.getError().setId( 400L );
      e.getError().setBadRequest( true );
      e.getError().setDescription( DATOS_INCORRECTOS_USER );
      throw e;
    }
  }
}
