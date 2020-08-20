package org.serratec.java2backend.conta.service;

public class ContaNotFoundException extends Exception {

		private String numero;
		public ContaNotFoundException(String numero) {
			this.numero = numero;
		}
		public String getNumero() {
			return numero;
		}
}
