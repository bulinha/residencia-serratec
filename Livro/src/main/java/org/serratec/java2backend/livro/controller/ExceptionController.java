package org.serratec.java2backend.livro.controller;

import org.serratec.java2backend.livro.services.LivroNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(LivroNotFoundException.class)
	public ResponseEntity<String> trataLivroNotFound(LivroNotFoundException e) {
		return ResponseEntity
				.notFound()
				.header("error-code", "LIVRO_NOT_FOUND")
				.header("error-value", String.valueOf(e.getId()))
				.build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> trataValidacao(MethodArgumentNotValidException e){
		
		
		return ResponseEntity
				.badRequest()
				.header("error-code", "REGISTRO_INVAIDO")
				.header("error-message", e.getMessage())
				.build();
		
	}

}
