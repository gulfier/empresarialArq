package mx.com.prosa.poc.controller.aspect;

import java.io.Serializable;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.ErrorTO;
import mx.com.prosa.poc.to.Response;

/**
 * Aspecto para interceptar excepciones tanto de negocio como de runtime
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@Aspect
@Configuration
public class ControllerAspect
{
  private static final Logger LOG = LoggerFactory.getLogger( ControllerAspect.class );
  /**
   * Intercepta las llamadas que tengan la anotacion
   * {@link mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor}
   * 
   * @param joinPoint
   * @return
   * @throws Throwable
   */
  @SuppressWarnings("unchecked")
  @Around(value = "within (@mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor *)")
  public ResponseEntity<Serializable> execute( ProceedingJoinPoint joinPoint ) throws Throwable
  {
    ResponseEntity<Serializable> response;
    try
    {
      response = (ResponseEntity<Serializable>) joinPoint.proceed();
    }
    catch( BusinessException e )
    {
      LOG.error( e.getMessage(), e );
      if( e.getError().isBadRequest() )
      {
        response = new ResponseEntity<>( createResponse( e.getMessage(), e.getError() ), HttpStatus.BAD_REQUEST );
      }
      else if( e.getError().isNotFound() )
      {
        response = new ResponseEntity<>( createResponse( e.getMessage(), e.getError() ), HttpStatus.NOT_FOUND );
      }
      else if( e.getError().isUnauthorized() )
      {
        response = new ResponseEntity<>( createResponse( HttpStatus.UNAUTHORIZED.getReasonPhrase(), e.getError() ),
            HttpStatus.UNAUTHORIZED );
      }
      else if( e.getError().isForbidden() )
      {
        response = new ResponseEntity<>( createResponse( HttpStatus.FORBIDDEN.getReasonPhrase(), e.getError() ),
            HttpStatus.FORBIDDEN );
      }
      else
      {
        response = new ResponseEntity<>( createResponse( e.getMessage(), e.getError() ),
            HttpStatus.INTERNAL_SERVER_ERROR );
      }
    }
    catch( Throwable e )
    {
      ErrorTO error = new ErrorTO();
      error.setId( 0L );
      error.setName( "Unknown error" );
      error.setDescription( e.getMessage() );
      // TODO ver si se quita el trace
      error.setTrace( ExceptionUtils.getStackTrace( e ) );

      LOG.error( e.getMessage(), e );

      response = new ResponseEntity<>( createResponse( error.getName(), error ), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    return response;
  }

  private Response<ErrorTO> createResponse( String message, ErrorTO errorTO )
  {
    Response<ErrorTO> response = new Response<>();
    response.setCode( errorTO.getId().intValue() );
    response.setMessage( message );
    response.setInformation( errorTO );
    return response;
  }
}
