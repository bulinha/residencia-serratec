package org.serratec.java2backend.conta.controller;

import org.serratec.java2backend.conta.service.ContaNotFoundException;
import org.serratec.java2backend.conta.service.SaldoInsuficienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<String> trataContaNotFound(ContaNotFoundException e) {
		
		return ResponseEntity
				.notFound()
				.header("error_code", "CONTA_NOT_FOUND")
				.header("error_value", e.getNumero())
				.build();
	}
	
	public ResponseEntity<String> trataSaldoInsuficiente(SaldoInsuficienteException e){
		return ResponseEntity
				.badRequest()
				.header("error_code", "SALDO_INSUFICIENTE")
				.header("error_value", String.valueOf(e.getValor()))
				.build();
	}

}
