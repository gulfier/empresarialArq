package mx.com.prosa.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor;
import mx.com.prosa.poc.service.ConsoleService;
import mx.com.prosa.poc.to.CredentialTO;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.TokenTO;

/**
 * Controlador para el CRUD de las Aplicaciones
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@RestController
@RequestMapping("/v1/web")
//@BusinessExceptionInterceptor
@CrossOrigin
public class WebApplicationController extends AbstractBaseController
{

  @Autowired
  private ConsoleService consoleService;

  private static final String QUERY_PARAM_NAME = "name";
  private static final String QUERY_PARAM_CODE = "code";
  private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

  /**
   * Obtener token
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<TokenTO>> login( @RequestBody CredentialTO request )
  {
//    request.setIp( super.getIpAddress() );
//    request.setUser( super.getUser() );

    TokenTO token = this.consoleService.createToken( request );

    Response<TokenTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( token );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }
  
  /**
   * Obtener token
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<TokenTO>> search( @RequestBody CredentialTO request )
  {
//    request.setIp( super.getIpAddress() );
//    request.setUser( super.getUser() );

    TokenTO token = this.consoleService.createToken( request );

    Response<TokenTO> response = new Response<>();
    response.setCode( HttpStatus.OK.value() );
    response.setMessage( HttpStatus.OK.name() );
    response.setResponse( token );

    return new ResponseEntity<>( response, HttpStatus.OK );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String[] getParameters()
  {
    return QUERY_PARAMS;
  }

  
	/**
	 * Hello docker.
	 *
	 * @return the string
	 */
	@RequestMapping("/helloweb")
	public String helloDocker() {
		return "Hello Docker!";
	}
}
