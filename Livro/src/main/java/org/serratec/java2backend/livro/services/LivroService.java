package org.serratec.java2backend.livro.services;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.livro.LivroRepository;
import org.serratec.java2backend.livro.entidade.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> buscaTodos(String atributo){
		return livroRepository.findAll(Sort.by(atributo));
	}
	
	private Livro findById(Integer id) throws LivroNotFoundException {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		if (optionalLivro.isPresent()) {
			return optionalLivro.get();
		}
		throw new LivroNotFoundException(id);
	}
	
	public Livro buscaPorId(Integer id) throws LivroNotFoundException {
		return findById(id);
	}
	
	public Livro insere(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro atualiza(Integer id, Livro livroNovo ) throws LivroNotFoundException {
		Livro livro = findById(id);
		livro.setAutor(livroNovo.getAutor());
		livro.setTipo(livroNovo.getTipo());
		livro.setDataPublicacao(livroNovo.getDataPublicacao());
		livro.setTitulo(livroNovo.getTitulo());
		return livroRepository.save(livro);
	}
	
	public void apagaLivro(Integer id) throws LivroNotFoundException {
		Livro livro = findById(id);
		livroRepository.delete(livro);
	}

}
