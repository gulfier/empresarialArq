package mx.com.prosa.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor;
import mx.com.prosa.poc.service.ActoresXAplicacionService;
import mx.com.prosa.poc.to.ActoresXAplicacionTO;
import mx.com.prosa.poc.to.ActoresXaplicacionEdithTO;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class ActoresXAplicacionController.
 */
@RestController
@RequestMapping("/v1/actores-x-application")
@BusinessExceptionInterceptor
@CrossOrigin
public class ActoresXAplicacionController extends AbstractBaseController {
	
	/** The ubicaciones service. */
	@Autowired
	private ActoresXAplicacionService actoresXAplicacionService;

	/**
	 * Save.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ActoresXAplicacionTO>> save(  @RequestBody ActoresXAplicacionTO request) {

		request.setIp( super.getIpAddress() );
	    request.setUser( super.getUser() );
	    
	    this.actoresXAplicacionService.save( request );

	    Response<ActoresXAplicacionTO> response = new Response<>();
	    response.setCode( HttpStatus.CREATED.value() );
	    response.setMessage( HttpStatus.CREATED.name() );
	    response.setResponse( request );

	    return new ResponseEntity<>( response, HttpStatus.CREATED );
	}
	
	/**
	 * Delete.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<BaseTO>> delete(@RequestBody ActoresXAplicacionTO request) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());

		this.actoresXAplicacionService.delete(request);

		Response<BaseTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Edits the patch.
	 *
	 * @param request the request
	 * @param id the id
	 * @return the response entity
	 */
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ActoresXAplicacionTO>> editPatch(@RequestBody ActoresXaplicacionEdithTO request,
			@PathVariable(value = "id") Long id) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.actoresXAplicacionService.edit(request);

		Response<ActoresXAplicacionTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());
		response.setResponse(request.getUpdate());

		return new ResponseEntity<>(response, HttpStatus.OK);
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