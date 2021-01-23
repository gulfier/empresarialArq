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
import mx.com.prosa.poc.service.ProtocolosService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.ProtocoloTO;
import mx.com.prosa.poc.to.Response;

// TODO: Auto-generated Javadoc
/**
 * Controlador para el CRUD de las base de datos.
 *
 * @author Gulfie Leonel L.
 */
@RestController
@RequestMapping("/v1/protocolo")
@BusinessExceptionInterceptor
@CrossOrigin
public class ProtocolosController extends AbstractBaseController {

	/** The protocolos service. */
	@Autowired
	ProtocolosService protocolosService;

	/**
	 * Guarda las bases de datos existentes.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	// TODO agregar informacion de swagger
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ProtocoloTO>> save(@RequestBody ProtocoloTO request) {
		protocolosService.save(request);

		Response<ProtocoloTO> response = new Response<>();
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
	public ResponseEntity<Response<ProtocoloTO>> editPatch(@RequestBody ProtocoloTO request,
			@PathVariable(value = "id") Long id) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.protocolosService.edit(request);

		Response<ProtocoloTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());
		response.setResponse(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<BaseTO>> delete(@PathVariable(value = "id") Long id) {

		ITServiceTO request = new ITServiceTO();
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.protocolosService.delete(id);

		Response<BaseTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());

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
