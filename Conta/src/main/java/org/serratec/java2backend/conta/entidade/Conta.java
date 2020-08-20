package org.serratec.java2backend.conta.entidade;

public class Conta {
	
	private String numero;
	private String nome;
	private Double saldo;
	
	
	
	public Conta() {
		super();
	}
	public Conta(String numero, String nome, Double saldo) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public void saque(Double valor) {
		this.saldo = saldo - valor;
	}
	public void deposito(Double valor) {
		this.saldo = saldo + valor;
	}
	

}
