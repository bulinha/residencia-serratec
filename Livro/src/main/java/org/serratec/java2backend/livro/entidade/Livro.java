package org.serratec.java2backend.livro.entidade;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name="titulo", nullable = false, length=30)
	private String titulo;
	
	@NotNull
	@Column(name="data_publicacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;
	
	

	@ManyToMany( )
	@JoinTable(name = "livro_autor" , 
		joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
	private Set<Autor> autores;

	

	public Livro() {
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

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Set<Autor> getAutores() {
		return autores;
	}


	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}


	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
	

}
