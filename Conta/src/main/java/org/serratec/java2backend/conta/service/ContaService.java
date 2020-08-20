package org.serratec.java2backend.conta.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.conta.entidade.Conta;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	
	private List<Conta> lista = new ArrayList<>();
	
	public ContaService() {
		lista.add(new Conta("001", "Joao", 123.40));
		lista.add(new Conta("002", "Antonio", 1259.45));
		lista.add(new Conta("003", "Maria", 234.56));
		lista.add(new Conta("004", "Antonieta", 4536.23));
	}
	
	public Conta adicionar(Conta conta) {
		lista.add(conta);
		return conta;
	}

	private Conta findByNumero(String numero) throws ContaNotFoundException {
		for(Conta conta:lista) {
			if (conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		throw new ContaNotFoundException(numero);
	}
	
	public List<Conta> buscarTodas(){
		return lista;
	}
	
	public Conta buscaContaPorNumero(String numero) throws ContaNotFoundException {
		return findByNumero(numero);
	}
	
	
	public Conta atualizaConta(String numero, Conta novaConta) throws ContaNotFoundException {
		Conta conta = findByNumero(numero);
		conta.setNome(novaConta.getNome());
		return conta;
	}
	
	public Conta deposito(String numero, Double valor) throws SaldoInsuficienteException, ContaNotFoundException{
		Conta conta = findByNumero(numero);
		conta.deposito(valor);
		return conta;
	}


	public Conta saque(String numero, Double valor) throws ContaNotFoundException, SaldoInsuficienteException {
		Conta conta = findByNumero(numero);
		if (valor>conta.getSaldo()) {
			throw new SaldoInsuficienteException(valor);
		}
		conta.saque(valor);
		return conta;
	}

	public void apagar(String numero) throws ContaNotFoundException {
		Conta conta = findByNumero(numero);
		lista.remove(conta);
		
	}
}
