package org.serratec.java2backend.livro.services;

public class DataNotFoundException extends Exception {

	private Integer id;
	public DataNotFoundException(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

}
