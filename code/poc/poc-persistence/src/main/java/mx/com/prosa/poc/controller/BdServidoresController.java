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
import mx.com.prosa.poc.service.BdServidoresService;
import mx.com.prosa.poc.to.BdServidoresTO;
import mx.com.prosa.poc.to.Response;

@RestController
@RequestMapping("/v1/bdservidores")
@BusinessExceptionInterceptor
@CrossOrigin
public class BdServidoresController extends AbstractBaseController {

	@Autowired
	private BdServidoresService bdServidoresService; 

	/**
	 * Save.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<BdServidoresTO>> save(  @RequestBody BdServidoresTO request) {

		request.setIp( super.getIpAddress() );
	    request.setUser( super.getUser() );
	    
	    this.bdServidoresService.save( request );

	    Response<BdServidoresTO> response = new Response<>();
	    response.setCode( HttpStatus.CREATED.value() );
	    response.setMessage( HttpStatus.CREATED.name() );
	    response.setResponse( request );

	    return new ResponseEntity<>( response, HttpStatus.CREATED );
	}
	
	@Override
	protected String[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
