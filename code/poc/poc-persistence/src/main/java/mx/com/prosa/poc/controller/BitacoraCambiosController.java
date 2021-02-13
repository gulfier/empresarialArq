package mx.com.prosa.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.prosa.poc.controller.aspect.BusinessExceptionInterceptor;
import mx.com.prosa.poc.service.BitacoraCambiosService;
import mx.com.prosa.poc.to.BaseTO;
import mx.com.prosa.poc.to.BitacoraCambiosTO;
import mx.com.prosa.poc.to.ConsoleResponseTO;
import mx.com.prosa.poc.to.ITServiceTO;
import mx.com.prosa.poc.to.PagingRequestTO;
import mx.com.prosa.poc.to.PagingResponseTO;
import mx.com.prosa.poc.to.Response;

/**
 * Controlador para el CRUD de Sitios.
 *
 * @author Jorge Ortega Hernández <jorgeortega30@live.com.mx>
 */
@RestController
@RequestMapping("/v1/CambiosAutorizar")
@BusinessExceptionInterceptor
@CrossOrigin
public class BitacoraCambiosController extends AbstractBaseController {

	/** The bitacora cambios service. */
	@Autowired
	private BitacoraCambiosService bitacoraCambiosService;

	/** The Constant QUERY_PARAM_NAME. */
	private static final String QUERY_PARAM_NAME = "name";
	
	/** The Constant QUERY_PARAM_CODE. */
	private static final String QUERY_PARAM_CODE = "code";
	
	/** The Constant QUERY_PARAMS. */
	private static final String[] QUERY_PARAMS = new String[] { QUERY_PARAM_NAME, QUERY_PARAM_CODE };

	/**
	 * Obtiene la consulta de los sitios.
	 *
	 * @return the response entity
	 */
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Response<ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>>>> findAll(
			@RequestHeader(value = "page", required = false) Integer page,
			@RequestHeader(value = "size", required = false) Integer size) {

		PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
		super.processPaging(request);
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());

		ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>> responseConsole;

		responseConsole = bitacoraCambiosService.findAll(request,page,size);
		System.out.println(responseConsole.getChanges().getSize());

		Response<ConsoleResponseTO<PagingResponseTO<BitacoraCambiosTO>>> body = new Response<>();
		body.setResponse(responseConsole);
		body.setCode(HttpStatus.OK.value());
		body.setMessage(HttpStatus.OK.name());
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	/**
	 * Find all.
	 *
	 * @param type the type
	 * @param initDate the init date
	 * @param endDate the end date
	 * @param page the page
	 * @param size the size
	 * @return the response entity
	 */
	@GetMapping(path = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Response<PagingResponseTO<BitacoraCambiosTO>>> findAll(
			@RequestHeader(value = "type", required = false) String type,
			@RequestHeader(value = "initDate", required = false) Long initDate,
			@RequestHeader(value = "endDate", required = false) Long endDate,
			@RequestHeader(value = "page", required = false) Integer page,
			@RequestHeader(value = "size", required = false) Integer size) {

		PagingRequestTO<BitacoraCambiosTO> request = new PagingRequestTO<>();
		super.processPaging(request);
		request.setIp(super.getIpAddress());
		request.setUser(super.getUser());

		PagingResponseTO<BitacoraCambiosTO> history;
		history = bitacoraCambiosService.getHistory(request, size, page, type, initDate, endDate);

		Response<PagingResponseTO<BitacoraCambiosTO>> body = new Response<>();
		body.setResponse(history);
		body.setCode(HttpStatus.OK.value());
		body.setMessage(HttpStatus.OK.name());
		return new ResponseEntity<>(body, HttpStatus.OK);
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

		this.bitacoraCambiosService.delete(id);

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
		return QUERY_PARAMS;
	}

}
