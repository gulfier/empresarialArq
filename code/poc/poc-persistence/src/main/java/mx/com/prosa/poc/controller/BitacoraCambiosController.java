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
import mx.com.prosa.poc.service.BitacoraCambiosService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.BitacoraCambiosTO;

/**
 * Controlador para el CRUD de Sitios
 * 
 * @author Guillermo Segura Olivera <guillermo.segura@axity.com>
 */
@RestController
@RequestMapping("/v1/CambiosAutorizar")
@BusinessExceptionInterceptor
public class BitacoraCambiosController extends AbstractBaseController
{

  @Autowired
  private BitacoraCambiosService bitacoraCambiosService;

  private static final String QUERY_PARAM_NAME = "name";
  private static final String QUERY_PARAM_CODE = "code";
  private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

  /**
   * Obtiene la consulta de los sitios
   * 
   * @return
   */
  // TODO agregar informacion de swagger
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Response<PagingResponseTO<BitacoraCambiosTO>>> findAll()
  {
	  
    PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
    super.processPaging( request );
    request.setIp( super.getIpAddress() );
    request.setUser( super.getUser() );
    
    boolean as = isQuery();
    System.out.println("SSS__________________" + as);

    PagingResponseTO<BitacoraCambiosTO> pagingResponseTO = null;

      pagingResponseTO = bitacoraCambiosService.findAll( request );
      System.out.println(pagingResponseTO.getSize());
    

    Response<PagingResponseTO<BitacoraCambiosTO>> body = new Response<>();
    body.setResponse( pagingResponseTO );
    body.setCode( HttpStatus.OK.value() );
    body.setMessage( HttpStatus.OK.name() );
    return new ResponseEntity<>( body, HttpStatus.OK );
  }

@Override
protected String[] getParameters() {
	// TODO Auto-generated method stub
	 return QUERY_PARAMS;
}

  





}
