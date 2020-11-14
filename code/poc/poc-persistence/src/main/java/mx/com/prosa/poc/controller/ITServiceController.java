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
import mx.com.prosa.poc.service.ITServiceService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.Response;

/**
 * Controlador para el CRUD de Servicios de TI
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@RestController
@RequestMapping("/v1/it-services")
@BusinessExceptionInterceptor
public class ITServiceController extends AbstractBaseController
{

  @Autowired
  private ITServiceService itService;

  private static final String QUERY_PARAM_NAME = "name";
  private static final String QUERY_PARAM_CODE = "code";
  private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

  /**
   * Obtiene la consulta de los Servicios de TI
   * 
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<PagingResponseTO<ITServiceTO>>> findAll()
  {
    PagingRequestTO<ITServiceTO> request = new PagingRequestTO<>();
    super.processPaging( request );
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    PagingResponseTO<ITServiceTO> pagingResponseTO = null;

    if( isQuery() )
    {
      request.setSearch( getSearch() );
      pagingResponseTO = itService.findByExample( request );
    }
    else
    {
      pagingResponseTO = itService.findAll( request );
    }

    Response<PagingResponseTO<ITServiceTO>> body = new Response<>();
    body.setResponse( pagingResponseTO );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );
    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un Servicio de TI por id
   * 
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ITServiceTO>> getById( @PathVariable(value = "id") Long id )
  {
    super.validate();

    ITServiceTO itService = this.itService.findById( id );

    Response<ITServiceTO> body = new Response<>();
    body.setResponse( itService );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Obtiene un Servicio de TI por codigo
   * 
   * @param code
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ITServiceTO>> getByCode( @PathVariable(value = "code") String code )
  {
    super.validate();

    ITServiceTO itService = this.itService.findByCode( code );

    Response<ITServiceTO> body = new Response<>();

    body.setResponse( itService );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( body, HttpStatus.OK );
  }

  /**
   * Guarda un Servicio de TI
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ITServiceTO>> save( @RequestBody ITServiceTO request )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );

    this.itService.save( request );

    Response<ITServiceTO> response = new Response<>();
    response.setCode( HttpStatus.CREATED.value() );
    response.setMessage( HttpStatus.CREATED.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.CREATED );
  }

  /**
   * Edita un Servicio de TI
   * 
   * @param request
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ITServiceTO>> edit( @RequestBody ITServiceTO request,
      @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.itService.edit( request, false );

    Response<ITServiceTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Edita un Servicio de TI parcialmente
   * 
   * @param request
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ITServiceTO>> editPatch( @RequestBody ITServiceTO request,
      @PathVariable(value = "id") Long id )
  {
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.itService.edit( request, true );

    Response<ITServiceTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( request );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * Elimina un Servicio de TI
   * 
   * @param id
   * @return
   */
  // TODO agregar informacion de swagger
  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<BaseTO>> delete( @PathVariable(value = "id") Long id )
  {

    ITServiceTO request = new ITServiceTO();
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    request.setId( id );

    this.itService.delete( request );

    Response<BaseTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  private ITServiceTO getSearch()
  {
    ITServiceTO search = new ITServiceTO();
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
