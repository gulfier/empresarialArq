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
import mx.com.prosa.poc.service.ServerService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.ServerTO;

/**
 * Controlador para el CRUD de Servidores
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@RestController
@RequestMapping("/v1/servers")
@BusinessExceptionInterceptor
public class ServerController extends AbstractBaseController
{

  @Autowired
  private ServerService serverService;

  private static final String QUERY_PARAM_NAME = "name";
  private static final String QUERY_PARAM_CODE = "code";
  private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

  /**
   * Obtiene la consulta de los servidores
   * 
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<PagingResponseTO<ServerTO>>> findAll()
  {
    PagingRequestTO<ServerTO> request = new PagingRequestTO<>();
    super.processPaging( request );
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    PagingResponseTO<ServerTO> pagingResponseTO = null;

    if( isQuery() )
    {
      request.setSearch( getSearch() );
      pagingResponseTO = serverService.findByExample( request );
    }
    else
    {
      pagingResponseTO = serverService.findAll( request );
    }

    Response<PagingResponseTO<ServerTO>> body = new Response<>();
    body.setResponse( pagingResponseTO );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );
    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un servidor por id
   * 
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ServerTO>> getById( @PathVariable(value = "id") Long id )
  {
    super.validate();

    ServerTO site = this.serverService.findById( id );

    Response<ServerTO> body = new Response<>();
    body.setResponse( site );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un servidor por codigo
   * 
   * @param code
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ServerTO>> getByCode( @PathVariable(value = "code") String code )
  {
    super.validate();

    ServerTO server = this.serverService.findByCode( code );

    Response<ServerTO> body = new Response<>();

    body.setResponse( server );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Guarda un servidor
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ServerTO>> save( @RequestBody ServerTO request )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    this.serverService.save( request );

    Response<ServerTO> response = new Response<>();
    response.setCode( HttpStatus.CREATED.value() );
    response.setMessage( HttpStatus.CREATED.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.CREATED );
  }

  /**
   * Edita un servidor
   * 
   * @param request
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ServerTO>> edit( @RequestBody ServerTO request, @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.serverService.edit( request, false );

    Response<ServerTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Edita un servidor parcialmente
   * 
   * @param request
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ServerTO>> editPatch( @RequestBody ServerTO request,
      @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.serverService.edit( request, true );

    Response<ServerTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Elimina un servidor
   * 
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<BaseTO>> delete( @PathVariable(value = "id") Long id )
  {

    ServerTO request = new ServerTO();
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.serverService.delete( request );

    Response<BaseTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  private ServerTO getSearch()
  {
    ServerTO search = new ServerTO();
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

  /**
   * {@inheritDoc}
   */
  @Override
  protected String[] getParameters()
  {
    return QUERY_PARAMS;
  }

}
