package mx.com.prosa.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor;
import mx.com.prosa.poc.service.SiteService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.SiteTO;

@RestController
@RequestMapping("/v1")
@BusinessExceptionInterceptor
public class SiteController extends AbstractBaseController
{

  @Autowired
  private SiteService siteService;

  private static final String QUERY_PARAM_NAME = "name";
  private static final String QUERY_PARAM_CODE = "code";
  private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

  /**
   * Obtiene la consulta de los sitios
   * 
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "/sites", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<PagingResponseTO<SiteTO>>> findAll()
  {
    PagingRequestTO<SiteTO> request = new PagingRequestTO<>();
    super.processPaging( request );
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    PagingResponseTO<SiteTO> pagingResponseTO = null;

    if( isQuery() )
    {
      request.setSearch( getSearch() );
      pagingResponseTO = siteService.findByExample( request );
    }
    else
    {
      pagingResponseTO = siteService.findAll( request );
    }

    Response<PagingResponseTO<SiteTO>> body = new Response<>();
    body.setResponse( pagingResponseTO );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );
    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un sitio por id
   * 
   * @param id
   * @return
   */
  @GetMapping(path = "/sites/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<SiteTO>> getById( @PathVariable(value = "id") Long id )
  {
    super.validate();

    SiteTO site = this.siteService.findById( id );

    Response<SiteTO> body = new Response<>();
    body.setResponse( site );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un sitio por codigo
   * 
   * @param code
   * @return
   */
  @GetMapping(path = "/sites/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<SiteTO>> getById( @PathVariable(value = "code") String code )
  {
    super.validate();

    SiteTO site = this.siteService.findByCode( code );

    Response<SiteTO> body = new Response<>();

    body.setResponse( site );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Guarda un sitio
   * 
   * @param request
   * @return
   */
  @PostMapping(path = "/sites", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<SiteTO>> save( @RequestBody SiteTO request )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    this.siteService.save( request );

    Response<SiteTO> response = new Response<>();
    response.setCode( HttpStatus.CREATED.value() );
    response.setMessage( HttpStatus.CREATED.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.CREATED );
  }

  /**
   * Edita un sitio
   * 
   * @param request
   * @param id
   * @return
   */
  @PutMapping(path = "/sites/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<SiteTO>> edit( @RequestBody SiteTO request, @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.siteService.edit( request, false );

    Response<SiteTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Edita un sitio parcialmente
   * 
   * @param request
   * @param id
   * @return
   */
  @PatchMapping(path = "/sites/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<SiteTO>> editPatch( @RequestBody SiteTO request, @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.siteService.edit( request, true );

    Response<SiteTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Elimina un sitio
   * 
   * @param id
   * @return
   */
  @DeleteMapping(path = "/sites/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<BaseTO>> delete( @PathVariable(value = "id") Long id )
  {

    SiteTO request = new SiteTO();
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.siteService.delete( request );

    Response<BaseTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  private SiteTO getSearch()
  {
    SiteTO search = new SiteTO();
    if( parameterExists( QUERY_PARAM_NAME ) )
    {
      search.setName( getParameter( QUERY_PARAM_NAME ) );
    }
    if( parameterExists( QUERY_PARAM_CODE ) )
    {
      search.setName( getParameter( QUERY_PARAM_CODE ) );
    }
    return search;
  }

  @Override
  protected String[] getParameters()
  {
    return QUERY_PARAMS;
  }

}
