package org.serratec.java2backend.conta.controller;

import java.util.List;

import org.serratec.java2backend.conta.entidade.Conta;
import org.serratec.java2backend.conta.service.ContaNotFoundException;
import org.serratec.java2backend.conta.service.ContaService;
import org.serratec.java2backend.conta.service.SaldoInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	
	
	@GetMapping
	public List<Conta> buscaTodas(){
		return contaService.buscarTodas();
	}

	@GetMapping("/{numero}")
	public Conta adiciona(@PathVariable String numero) throws ContaNotFoundException {
		return contaService.buscaContaPorNumero(numero);
	}
	
	@PostMapping()
	public Conta adiciona(Conta conta) {
		return contaService.adicionar(conta);
	}
	@PutMapping("/{id}")
	public Conta atualiza(@PathVariable String numero, @RequestBody Conta conta) throws ContaNotFoundException {
		return contaService.atualizaConta(numero, conta);
	}
	
	@PutMapping("/{numero}/saque")
	public Conta saque(@PathVariable String numero, @RequestParam Double valor) throws ContaNotFoundException, SaldoInsuficienteException {
		 return contaService.saque(numero,valor);
	}
	
	@PutMapping("/{numero}/deposito")
	public Conta deposito(@PathVariable String numero, @RequestParam Double valor) throws ContaNotFoundException, SaldoInsuficienteException {
		 return contaService.deposito(numero,valor);
	}
	
	@DeleteMapping("/{numero}")
	public void apagar(@PathVariable String numero) throws ContaNotFoundException {
		contaService.apagar(numero);
	}

	
}
