package ar.edu.ucc.pa.service.controller;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.ucc.pa.service.dto.UsuarioDto;
import ar.edu.ucc.pa.service.exceptions.BadRequestException;
import ar.edu.ucc.pa.service.service.UsuarioService;

@Controller
public class UsuarioController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(
			value = "/user/search", 
			method = RequestMethod.GET, 
			produces = "application/json")
	public ResponseEntity<?> 
	searchUser(@RequestParam(name = "id", required = true) Long id)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.DAY_OF_YEAR, -2); 
	    Date fechaMenor = calendar.getTime();
	    
		Date fechaActual = Calendar.getInstance().getTime();
		
		log.info("Fecha: " + fechaActual);
		log.info("Fecha Menor: " + fechaMenor);
		
		if (fechaActual.compareTo(fechaMenor)> 0){
			throw new BadRequestException("0001", "Fecha Menor a la Actual");
		}
		
		
		log.info("/user/search?id=" + id);
		UsuarioDto dto = usuarioService.buscarPorId(id);

		return new ResponseEntity(dto, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user/{userId}", 
	method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> 
	getUser(@PathVariable("userId") Long userId) throws Exception {

		UsuarioDto dto = usuarioService.buscarPorId(userId);

		return new ResponseEntity(dto, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user", 
	method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearUsuario(
			@RequestBody UsuarioDto usuario) throws Exception {

		usuarioService.agregarUsuario(usuario);

		return new ResponseEntity(usuario, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/user", 
	method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDto usuario) throws Exception {

		usuarioService.actualizarUsuario(usuario);

		return new ResponseEntity(usuario, HttpStatus.OK);
	}

}
