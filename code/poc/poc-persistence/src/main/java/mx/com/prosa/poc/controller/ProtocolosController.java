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
import mx.com.prosa.poc.service.ProtocolosService;
import mx.com.prosa.poc.to.ProtocoloTO;
import mx.com.prosa.poc.to.Response;

/**
 * Controlador para el CRUD de las base de datos
 * 
 * @author Gulfie Leonel L.
 */
@RestController
@RequestMapping("/v1/protocolo")
@BusinessExceptionInterceptor
@CrossOrigin
public class ProtocolosController 
{
	
	@Autowired
	ProtocolosService protocolosService ;

  /**
   * Guarda las bases de datos existentes
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<ProtocoloTO>> save( @RequestBody ProtocoloTO request )
  {
	  protocolosService.save(request);
	  
	    Response<ProtocoloTO> response = new Response<>();
	    response.setCode( HttpStatus.CREATED.value() );
	    response.setMessage( HttpStatus.CREATED.name() );
	    response.setResponse( request );

	    return new ResponseEntity<>( response, HttpStatus.CREATED );
	  
  }




}
