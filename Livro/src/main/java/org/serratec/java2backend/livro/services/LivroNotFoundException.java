package org.serratec.java2backend.livro.services;

public class LivroNotFoundException extends Exception {

	private Integer id;
	public LivroNotFoundException(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

}
