package org.serratec.cursojava2.crud.domain;

public class Todo {

	
	
	private Integer id;
	private String titulo;
	private String descricao;
	private Boolean completada;
	
	
	
	public Todo(Integer id, String titulo, String descricao, Boolean completada) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.completada = completada;
	}
	
	
	public Todo() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getCompletada() {
		return completada;
	}
	public void setCompletada(Boolean completada) {
		this.completada = completada;
	}
	
}
