package org.serratec.java2backend.livro.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2backend.livro.entidade.Autor;
import org.serratec.java2backend.livro.entidade.Categoria;
import org.serratec.java2backend.livro.services.AutorService;
import org.serratec.java2backend.livro.services.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public List<Autor> buscaTodos(){
		return autorService.buscarTodas();
	}
	@GetMapping("/{id}")
	public Autor buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return autorService.buscarPorId(id);
	}
	
	
	@PostMapping
	public Autor insere(@Valid @RequestBody Autor autor ) {
		return autorService.salvar(autor);
	}
	
	@PutMapping("/{id}")
	public Autor atualiza(@PathVariable Integer id, @Valid @RequestBody Autor autor) throws DataNotFoundException {
		return autorService.atualizar(id, autor);
	}
	
	@DeleteMapping("/id")
	public void atualiza(@PathVariable Integer id) throws DataNotFoundException {
		autorService.apagar(id);
	}
	
}
