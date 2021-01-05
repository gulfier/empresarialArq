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
import mx.com.prosa.poc.service.AplicacionesService;
import mx.com.prosa.poc.to.AplicacionTO;
import mx.com.prosa.poc.to.Response;

/**
 * Controlador para el CRUD de las Aplicaciones
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@RestController
@RequestMapping("/v1/aplicacion")
@BusinessExceptionInterceptor
@CrossOrigin
public class AplicacionController 
{
	
	@Autowired
	AplicacionesService aplicacionesService;

  /**
   * Guarda un Servicio de TI
   * 
   * @param request
   * @return
   */
  // TODO agregar informacion de swagger
  @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<AplicacionTO>> save( @RequestBody AplicacionTO request )
  {
	  aplicacionesService.save(request);
	  
	    Response<AplicacionTO> response = new Response<>();
	    response.setCode( HttpStatus.CREATED.value() );
	    response.setMessage( HttpStatus.CREATED.name() );
	    response.setResponse( request );

	    return new ResponseEntity<>( response, HttpStatus.CREATED );
	  
  }




}
