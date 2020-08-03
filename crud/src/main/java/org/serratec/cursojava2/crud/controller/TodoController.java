package org.serratec.cursojava2.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.serratec.cursojava2.crud.domain.Todo;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/todo"})
@Scope("session")
public class TodoController {

	private List<Todo> cache;
	private int nextId = 0;
	public TodoController() {
		cache = new ArrayList<Todo>();
		cache.add(new Todo(1, "baixar apostila", "Baixar a apostila mais recente", true));
		cache.add(new Todo(2, "baixar eclipse", "Baixar a versão mais atual do eclipse", false));
		cache.add(new Todo(3, "baixar jdk", "Baixar a versão 8 do java developer kit", false));
		cache.add(new Todo(4, "instalar jdk", "Descompactar o arquivo e configurar o path e java_path no windows", false));
		cache.add(new Todo(5, "testar eclipse", "Descompactar o eclipse e verificar se ele encontra o java", false));
		nextId=6;
		
	}
	
	
	@GetMapping
	public List<Todo> getTodos(@RequestParam Map<String,String> allParams){
		return cache
				.stream()
				.filter(o -> 
					Boolean.valueOf(allParams.getOrDefault("completada", o.getCompletada().toString())).equals(o.getCompletada()) &&
					allParams.getOrDefault("titulo", o.getTitulo()).equals(o.getTitulo()) &&
					allParams.getOrDefault("descricao", o.getDescricao()).equals(o.getDescricao())
						).collect(Collectors.toList());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable Integer id) {
			return cache.stream()
				.filter(o -> o.getId().equals(id))
				.findFirst()
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<Todo> postTodo(@RequestBody Todo todo) {
		Integer id = nextId ++;
		todo.setId(id);
		cache.add(todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(todo);
	}

	@PatchMapping(path="/{id}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<Todo>  patchTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		return putTodo(id, todo);
	}
	
	@PutMapping(path="/{id}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<Todo>  putTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		return cache.stream()
				.filter(o -> o.getId().equals(id))
				.findFirst()
				.map(record -> {
					if (todo.getTitulo()!=null)
						record.setTitulo(todo.getTitulo());
					if (todo.getDescricao()!=null)
						record.setDescricao(todo.getDescricao());
					if (todo.getCompletada()!=null)
						record.setCompletada(todo.getCompletada());
					return ResponseEntity.ok().body(record);
				})
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return cache.stream()
				.filter(o -> o.getId().equals(id))
				.findFirst()
				.map(record -> {
					cache.remove(record);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
