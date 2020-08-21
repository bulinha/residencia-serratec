package org.serratec.java2backend.livro.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2backend.livro.entidade.Categoria;
import org.serratec.java2backend.livro.entidade.Livro;
import org.serratec.java2backend.livro.services.CategoriaService;
import org.serratec.java2backend.livro.services.DataNotFoundException;
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
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> buscaTodos(){
		return categoriaService.buscarTodas();
	}
	@GetMapping("/{id}")
	public Categoria buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return categoriaService.buscarPorId(id);
	}
	
	
	@PostMapping
	public Categoria insere(@Valid @RequestBody Categoria categoria ) {
		return categoriaService.salvar(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualiza(@PathVariable Integer id, @Valid @RequestBody Categoria categoria ) throws DataNotFoundException {
		return categoriaService.atualizar(id, categoria);
	}
	
	@DeleteMapping("/id")
	public void atualiza(@PathVariable Integer id) throws DataNotFoundException {
		categoriaService.apagar(id);
	}
	
}
