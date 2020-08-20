package org.serratec.java2backend.livro.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2backend.livro.entidade.Livro;
import org.serratec.java2backend.livro.services.LivroNotFoundException;
import org.serratec.java2backend.livro.services.LivroService;
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
@RequestMapping("/livro")
public class LivroController {

	
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public List<Livro> buscaTodos(@RequestParam(defaultValue = "id") String ordem){
		return livroService.buscaTodos(ordem);
	}
	@GetMapping("/{id}")
	public Livro buscaPorId(@PathVariable Integer id) throws LivroNotFoundException {
		return livroService.buscaPorId(id);
	}
	
	@PostMapping
	public Livro insere(@Valid @RequestBody Livro livro ) {
		return livroService.insere(livro);
	}
	
	@PutMapping("/{id}")
	public Livro atualiza(@PathVariable Integer id, @Valid @RequestBody Livro livro ) throws LivroNotFoundException {
		return livroService.atualiza(id, livro);
	}
	
	@DeleteMapping("/id")
	public void atualiza(@PathVariable Integer id) throws LivroNotFoundException {
		livroService.apagaLivro(id);
	}
	
}