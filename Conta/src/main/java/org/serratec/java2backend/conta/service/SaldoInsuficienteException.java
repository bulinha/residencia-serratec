package org.serratec.java2backend.conta.service;

public class SaldoInsuficienteException extends Exception {

	private Double valor;

	public SaldoInsuficienteException(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}
	
	

}
