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
import mx.com.prosa.poc.service.NivelCifradoService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.NivelCifradoTO;
import mx.com.prosa.poc.to.Response;

/**
 * Controlador para el CRUD de las base de datos
 * 
 * @author Gulfie Leonel L.
 */
@RestController
@RequestMapping("/v1/nivelCifrado")
@BusinessExceptionInterceptor
@CrossOrigin
public class NivelCifradoController extends AbstractBaseController {

	@Autowired
	NivelCifradoService NivelCifradoService;

	/**
	 * Guarda las bases de datos existentes
	 * 
	 * @param request
	 * @return
	 */
	// TODO agregar informacion de swagger
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<NivelCifradoTO>> save(@RequestBody NivelCifradoTO request) {
		NivelCifradoService.save(request);

		Response<NivelCifradoTO> response = new Response<>();
		response.setCode(HttpStatus.CREATED.value());
		response.setMessage(HttpStatus.CREATED.name());
		response.setResponse(request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<NivelCifradoTO>> editPatch(@RequestBody NivelCifradoTO request,
			@PathVariable(value = "id") Long id) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.NivelCifradoService.edit(request);

		Response<NivelCifradoTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());
		response.setResponse(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<BaseTO>> delete(@PathVariable(value = "id") Long id) {

		NivelCifradoTO request = new NivelCifradoTO();
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.NivelCifradoService.delete(id);

		Response<BaseTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	protected String[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
