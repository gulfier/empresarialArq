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
import mx.com.prosa.poc.service.SoftwareComercialService;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.SoftwareComercialTO;

// TODO: Auto-generated Javadoc
/**
 * The Class SoftwareComercialController.
 */
@RestController
@RequestMapping("/v1/software")
@BusinessExceptionInterceptor
@CrossOrigin
public class SoftwareComercialController extends AbstractBaseController {

	/** The software comercial service. */
	@Autowired
	private SoftwareComercialService softwareComercialService;

	/**
	 * Save.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<SoftwareComercialTO>> save(  @RequestBody SoftwareComercialTO request) {

		request.setIp( super.getIpAddress() );
	    request.setUser( super.getUser() );
	    
	    this.softwareComercialService.save( request );

	    Response<SoftwareComercialTO> response = new Response<>();
	    response.setCode( HttpStatus.CREATED.value() );
	    response.setMessage( HttpStatus.CREATED.name() );
	    response.setResponse( request );

	    return new ResponseEntity<>( response, HttpStatus.CREATED );
	}
	
	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	@Override
	protected String[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
