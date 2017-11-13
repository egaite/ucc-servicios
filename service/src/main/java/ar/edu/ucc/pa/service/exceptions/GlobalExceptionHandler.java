package ar.edu.ucc.pa.service.exceptions;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequest(BadRequestException badRequestException) {
		log.error("Error", badRequestException);
		return new ResponseEntity(new ResponseErrorStatus(
				badRequestException.getCodigo(),
				badRequestException.getMensaje()), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<?> badRequest(ParseException exception) {
		log.error("Error", exception);
		return new ResponseEntity(new ResponseErrorStatus("02000","Opsss! Error de Parseo"), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> badRequest(NullPointerException exception) {
		log.error("Error", exception);
		return new ResponseEntity(new ResponseErrorStatus("02001","Opsss! Error de Null Pointer"), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> badRequest(HttpRequestMethodNotSupportedException exception) {
		log.error("Error", exception);
		return new ResponseEntity(new ResponseErrorStatus("02000","Opsss! Error de Hhttp"), HttpStatus.BAD_REQUEST);
	}
}
