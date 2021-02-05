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

import mx.com.prosa.poc.service.IpsService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.IpTO;
import mx.com.prosa.poc.to.Response;

// TODO: Auto-generated Javadoc
/**
 * Controlador para el CRUD de las base de datos.
 *
 * @author Gulfie Leonel L.
 */
@RestController
@RequestMapping("/v1/ip")
@CrossOrigin
public class IpsController extends AbstractBaseController {

	/** The ips service. */
	@Autowired
	IpsService ipsService;

	/**
	 * Guarda las bases de datos existentes.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	// TODO agregar informacion de swagger
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<IpTO>> save(@RequestBody IpTO request) {
		ipsService.save(request);

		Response<IpTO> response = new Response<>();
		response.setCode(HttpStatus.CREATED.value());
		response.setMessage(HttpStatus.CREATED.name());
		response.setResponse(request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	/**
	 * Hello docker.
	 *
	 * @return the string
	 */
	@RequestMapping("/helli")
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Edits the patch.
	 *
	 * @param request the request
	 * @param id the id
	 * @return the response entity
	 */
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<IpTO>> editPatch(@RequestBody IpTO request, @PathVariable(value = "id") Long id) {
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.ipsService.edit(request);

		Response<IpTO> response = new Response<>();
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

		IpTO request = new IpTO();
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());
		request.setId(id);

		this.ipsService.delete(id);

		Response<BaseTO> response = new Response<>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage(HttpStatus.OK.name());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
