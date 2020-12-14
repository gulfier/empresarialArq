package mx.com.prosa.poc.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import mx.com.prosa.poc.to.BaseTO;
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
@CrossOrigin
public class ServerController extends AbstractBaseController
{


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
	  return null;
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
	  return null;
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
	  return null;
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
	  return null;
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
	  return null;
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
	  return null;
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

	  return null;
  }

  private ServerTO getSearch()
  {
	  return null;
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
