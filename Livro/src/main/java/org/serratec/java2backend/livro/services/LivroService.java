package org.serratec.java2backend.livro.services;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.livro.entidade.Autor;
import org.serratec.java2backend.livro.entidade.Livro;
import org.serratec.java2backend.livro.repositorio.AutorRepository;
import org.serratec.java2backend.livro.repositorio.CategoriaRepository;
import org.serratec.java2backend.livro.repositorio.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("singleton")
public class LivroService {
	

	@Autowired
	private LivroRepository livroRepository;
	
	
	public List<Livro> buscaPorAutor(String autor) {
		return livroRepository.findByAutor(autor);
	}
	
	@Transactional(readOnly = true)
	public List<Livro> buscaTodos(String atributo){
		return livroRepository.findByIdComCategoria(Sort.by(atributo));
	}
	
	private Livro findById(Integer id) throws DataNotFoundException {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		if (optionalLivro.isPresent()) {
			return optionalLivro.get();
		}
		throw new DataNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Livro buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	AutorRepository autorRepository;
	CategoriaRepository categoriaRepository;
	
	@Transactional
	public Livro insere(Livro livro) {
//		for(Autor autor: livro.getAutores()) {
//			if (!autorRepository.existsById(autor.getId())) {
//				throw new AutorInvalidoException();
//			}
//		}
//		if (!categoriaRepository.existsById(livro.getCategoria().getId()))
//			throw new CategoriaInvalidaException();
		return livroRepository.save(livro);
	}

	@Transactional
	public Livro atualiza(Integer id, Livro livroNovo ) throws DataNotFoundException {
		Livro livro = findById(id);
		livro.setAutores(livroNovo.getAutores());
		livro.setCategoria(livroNovo.getCategoria());
		livro.setDataPublicacao(livroNovo.getDataPublicacao());
		livro.setTitulo(livroNovo.getTitulo());
		return livroRepository.save(livro);
	}
	
	@Transactional
	public void apagaLivro(Integer id) throws DataNotFoundException {
		Livro livro = findById(id);
		livroRepository.delete(livro);
	}

}
