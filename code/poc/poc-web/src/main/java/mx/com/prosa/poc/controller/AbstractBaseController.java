package mx.com.prosa.poc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mx.com.prosa.poc.service.SecurityService;
import mx.com.prosa.poc.to.BusinessException;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.util.Jwt;

/**
 * Clase base de los controladores, provee las herramientas para sacar informacion
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
public abstract class AbstractBaseController
{

  protected static final String SCOPE = "api/persistence";

  private static final String UNAUTHORIZED = "Unauthorized";
  private static final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";
  private static final int DEFAULT_PAGE = 0;
  private static final int DEFAULT_SIZE = 10;
  private static final String PAGE = "page";
  private static final String SIZE = "size";
  private static final String SORT_BY = "sortBy";
  private static final String DIRECTION = "direction";

  @Autowired
  private SecurityService securityService;

  /**
   * Devuelve la instancia del {@link javax.servlet.http.HttpServletRequest}
   * 
   * @return
   */
  protected HttpServletRequest getRequest()
  {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

  /**
   * Devuelve el valor de un header
   * 
   * @param name El nombre del header
   * @return
   */
  protected String getHeader( String name )
  {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    return request.getHeader( name );
  }

  /**
   * Devuelve el valor del parametro
   * 
   * @param name
   * @return
   */
  protected String getParameter( String name )
  {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    return request.getParameter( name );
  }

  /**
   * Valida si existe un parametro
   * 
   * @param name
   * @return
   */
  protected boolean parameterExists( String name )
  {
    return StringUtils.isNotBlank( getParameter( name ) );
  }

  /**
   * Valida que exista un header
   * 
   * @param name
   * @return
   */
  protected boolean headerExists( String name )
  {
    return StringUtils.isNotBlank( getHeader( name ) );
  }

  /**
   * Obtienen los parametros del controlador
   * 
   * @return
   */
  protected abstract String[] getParameters();

  /**
   * Valida si es consulta por parametros
   * 
   * @return
   */
  protected boolean isQuery()
  {
    boolean isQuery = false;

    for( String parameter : getParameters() )
    {
      isQuery = parameterExists( parameter );
      if( isQuery )
      {
        break;
      }
    }

    return isQuery;
  }

  /**
   * Procesa el paginado
   * 
   * @param request
   */
  protected void processPaging( PagingRequestTO<?> request )
  {
    if( request != null )
    {
      extractPage( request );
      extractSize( request );
      extractSortBy( request );
      extractDirection( request );
    }
  }

  private void extractPage( PagingRequestTO<?> request )
  {
    if( StringUtils.isNotBlank( this.getParameter( PAGE ) ) )
    {
      int page = NumberUtils.toInt( this.getParameter( PAGE ) );
      if( page < 0 )
      {
        page = DEFAULT_PAGE;
      }
      request.setPage( page );
    }
    else
    {
      request.setPage( DEFAULT_PAGE );
    }
  }

  private void extractSize( PagingRequestTO<?> request )
  {
    if( StringUtils.isNotBlank( this.getParameter( SIZE ) ) )
    {
      int size = NumberUtils.toInt( this.getParameter( SIZE ) );
      if( size == 0 )
      {
        size = DEFAULT_SIZE;
      }
      request.setSize( size );
    }
    else
    {
      request.setSize( DEFAULT_SIZE );
    }
  }

  private void extractSortBy( PagingRequestTO<?> request )
  {
    if( StringUtils.isNotBlank( this.getParameter( SORT_BY ) ) )
    {
      request.setSortBy( this.getParameter( SORT_BY ) );
    }
  }

  private void extractDirection( PagingRequestTO<?> request )
  {
    if( StringUtils.isNotBlank( this.getParameter( DIRECTION ) ) )
    {
      this.getParameter( DIRECTION );
      if( this.getParameter( DIRECTION ).equals( PagingRequestTO.Direction.ASC.name() ) )
      {
        request.setDirection( PagingRequestTO.Direction.ASC );
      }
      else if( this.getParameter( DIRECTION ).equals( PagingRequestTO.Direction.DESC.name() ) )
      {
        request.setDirection( PagingRequestTO.Direction.DESC );
      }
      else
      {
        request.setDirection( PagingRequestTO.Direction.ASC );
      }

    }
  }

  /**
   * Obtiene la direccion IP de la peticion
   * 
   * @return
   */
  protected String getIpAddress()
  {
    HttpServletRequest request = getRequest();

    String ipAddress = request.getHeader( HEADER_X_FORWARDED_FOR );
    if( ipAddress == null )
    {
      ipAddress = request.getRemoteAddr();
    }
    return ipAddress;
  }

  /**
   * Extrae el usuario del header Authorization que corresponde a un JWT
   * 
   * @return
   */
  protected String getUser()
  {
    String authorization = getAuthorization();
    validate( authorization );

    return securityService.getUser( authorization );
  }

  private String getAuthorization()
  {
    String authorization = null;
    if( headerExists( HttpHeaders.AUTHORIZATION ) )
    {
      authorization = getHeader( HttpHeaders.AUTHORIZATION );
    }
    else
    {
      BusinessException e = new BusinessException( UNAUTHORIZED );
      e.getError().setId( 401L );
      e.getError().setUnauthorized( true );
      e.getError().setDescription( UNAUTHORIZED );
      throw e;
    }
    return authorization;
  }

  /**
   * Valida que tenga las credenciales
   */
  protected void validate()
  {
    String authorization = getAuthorization();
    validate( authorization );
  }

  private void validate( String authorization )
  {
    Jwt claims = new Jwt();
    claims.setScope( SCOPE );

    securityService.validate( authorization, claims );
  }

}
