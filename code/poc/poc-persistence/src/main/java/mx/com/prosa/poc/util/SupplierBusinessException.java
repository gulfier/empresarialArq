package mx.com.prosa.poc.util;

import java.util.function.Supplier;

import mx.com.prosa.poc.to.BusinessException;

/**
 * Utileria para generar excepciones
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public final class SupplierBusinessException
{
  private static final String SITE_NOT_FOUND_MESSAGE = "Site not found";

  private static final String SERVER_NOT_FOUND_MESSAGE = "Server not found";

  private static final String IT_SERVICE_NOT_FOUND_MESSAGE = "IT Service not found";

  private static final String APPLICATION_NOT_FOUND_MESSAGE = "Application not found";
  
  private static final String ACTOR_NOT_FOUND_MESSAGE = "Actor not found";
  
  private static final String DATA_BASE_NOT_FOUND_MESSAGE = "Data Base not found";
  
  private static final String BRAND_NOT_FOUND_MESSAGE = "Brand not found";
  
  private static final String LOCATION_NOT_FOUND_MESSAGE = "Location not found";
  
  private static final String SOFTWARE_NOT_FOUND_MESSAGE = "Software not found";
  
  private static final String IP_NOT_FOUND_MESSAGE = "IP not found";
  
  private static final String APP_NOT_FOUND_MESSAGE = "Aplication not found";
  
  private static final String TABLE_NOT_FOUND_MESSAGE = "Table not found";
  
  private static final String RED_PART_NOT_FOUND_MESSAGE = "Segmento not found";
  
  private static final String PROTOCOL_NOT_FOUND_MESSAGE = "Segmento not found";
  
  private static final String LEVEL_SECURITY_NOT_FOUND_MESSAGE = "Level security not found";

  private SupplierBusinessException()
  {
    // Se ofusca el constructor
  }
  
  public static final Supplier<BusinessException> LEVEL_SECURITY_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( LEVEL_SECURITY_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( LEVEL_SECURITY_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> PROTOCOL_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( PROTOCOL_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( PROTOCOL_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> RED_PART_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( RED_PART_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( RED_PART_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> TABLE_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( TABLE_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( TABLE_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> APP_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( APP_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( APP_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> IP_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( IP_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( IP_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> SOFTWARE_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( SOFTWARE_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( SOFTWARE_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> LOCATION_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( LOCATION_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( LOCATION_NOT_FOUND_MESSAGE );
		return e;
  };
  
  public static final Supplier<BusinessException> BRAND_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( BRAND_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( BRAND_NOT_FOUND_MESSAGE );
		return e;
  };

  public static final Supplier<BusinessException> DATA_BASE_NOT_FOUND = () -> {
		BusinessException e = new BusinessException( DATA_BASE_NOT_FOUND_MESSAGE );
		e.getError().setId( 404L );
		e.getError().setNotFound( true );
		e.getError().setDescription( DATA_BASE_NOT_FOUND_MESSAGE );
		return e;
	  };
  
  public static final Supplier<BusinessException> ACTOR_NOT_FOUND = () -> {
	BusinessException e = new BusinessException( ACTOR_NOT_FOUND_MESSAGE );
	e.getError().setId( 404L );
	e.getError().setNotFound( true );
	e.getError().setDescription( ACTOR_NOT_FOUND_MESSAGE );
	return e;
  };
  
  public static final Supplier<BusinessException> APPLICATION_NOT_FOUND = () -> {
    BusinessException e = new BusinessException( APPLICATION_NOT_FOUND_MESSAGE );
    e.getError().setId( 404L );
    e.getError().setNotFound( true );
    e.getError().setDescription( APPLICATION_NOT_FOUND_MESSAGE );
    return e;
  };

  public static final Supplier<BusinessException> IT_SERVICE_NOT_FOUND = () -> {
    BusinessException e = new BusinessException( IT_SERVICE_NOT_FOUND_MESSAGE );
    e.getError().setId( 404L );
    e.getError().setNotFound( true );
    e.getError().setDescription( IT_SERVICE_NOT_FOUND_MESSAGE );
    return e;
  };

  public static final Supplier<BusinessException> SERVER_NOT_FOUND = () -> {
    BusinessException e = new BusinessException( SERVER_NOT_FOUND_MESSAGE );
    e.getError().setId( 404L );
    e.getError().setNotFound( true );
    e.getError().setDescription( SERVER_NOT_FOUND_MESSAGE );
    return e;
  };

  public static final Supplier<BusinessException> SITE_NOT_FOUND = () -> {
    BusinessException e = new BusinessException( SITE_NOT_FOUND_MESSAGE );
    e.getError().setId( 404L );
    e.getError().setNotFound( true );
    e.getError().setDescription( SITE_NOT_FOUND_MESSAGE );
    return e;
  };
}
