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
import mx.com.prosa.poc.service.TblIpXServidoresService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.IpXServidoresEdithTO;
import mx.com.prosa.poc.to.Response;
import mx.com.prosa.poc.to.TblIpXServidoresTO;

@RestController
@RequestMapping("/v1/ipxserver")
@BusinessExceptionInterceptor
@CrossOrigin
public class IpXServidoresController extends AbstractBaseController {
	@Autowired
	TblIpXServidoresService ipXServidoresService;

	/**
	 * Guarda las bases de datos existentes
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<TblIpXServidoresTO>> save(@RequestBody TblIpXServidoresTO request) {
		ipXServidoresService.save(request);

		Response<TblIpXServidoresTO> response = new Response<>();
		response.setCode(HttpStatus.CREATED.value());
		response.setMessage(HttpStatus.CREATED.name());
		response.setResponse(request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	/**
	 * Edits the patch.
	 *
	 * @param request the request
	 * @param id the id
	 * @return the response entity
	 */
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<TblIpXServidoresTO>> editPatch(@RequestBody IpXServidoresEdithTO request,
			@PathVariable(value = "id") Long id) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.ipXServidoresService.edit(request);

		Response<TblIpXServidoresTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());
		response.setResponse(request.getUpdate());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<BaseTO>> delete(@RequestBody TblIpXServidoresTO request) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());

		this.ipXServidoresService.delete(request);

		Response<BaseTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Hello docker.
	 *
	 * @return the string
	 */
	@RequestMapping("/hello")
	public String helloDocker() {
		return "Hello Docker!";
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	@Override
	protected String[] getParameters() {
		return null;
	}
}
