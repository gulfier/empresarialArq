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
  
  private static final String BRAND_NOT_FOUND_MESSAGE = "Marca not found";

  private SupplierBusinessException()
  {
    // Se ofusca el constructor
  }
  
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
