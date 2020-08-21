package org.serratec.java2backend.livro.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.livro.entidade.Categoria;
import org.serratec.java2backend.livro.entidade.Livro;
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
	
	public LivroService(LivroRepository livroRepository, CategoriaRepository categoriaRepository) {
		this.livroRepository = livroRepository;
		this.categoriaRepository = categoriaRepository;
		Categoria ficcao = new Categoria("ficção");
		ficcao = categoriaRepository.save(ficcao);
		Categoria romance = new Categoria("romance");
		romance = categoriaRepository.save(romance);
		categoriaRepository.save(new Categoria("aventura"));
		categoriaRepository.save(new Categoria("direito"));
		categoriaRepository.save(new Categoria("ficção"));
		
		livroRepository.save(new Livro("star wars", "george lucas", new Date(1997,10,10, 0, 0, 0), ficcao));
		livroRepository.save(new Livro("core java", "sun micro systems", new Date(2007,10,10,0,0,0), romance));

	}
	
	private LivroRepository livroRepository;
	
	private CategoriaRepository categoriaRepository;
	
	
	public List<Livro> buscaPorAutor(String autor) {
		return livroRepository.findByAutor(autor);
	}
	
	@Transactional(readOnly = true)
	public List<Livro> buscaTodos(String atributo){
		
		List<Livro> lista = livroRepository.findAll(Sort.by(atributo));
		for(Livro livro : lista) {
			System.out.println(livro.getCategoria().getNome());
		}

		lista = livroRepository.findByIdComCategoria(Sort.by(atributo));
		for(Livro livro : lista) {
			System.out.println(livro.getCategoria().getNome());
		}
		
		return livroRepository.findByIdComCategoria(Sort.by(atributo));
	}
	
	private Livro findById(Integer id) throws LivroNotFoundException {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		if (optionalLivro.isPresent()) {
			return optionalLivro.get();
		}
		throw new LivroNotFoundException(id);
	}
	
	@Transactional(readOnly = true)
	public Livro buscaPorId(Integer id) throws LivroNotFoundException {
		return findById(id);
	}
	
	@Transactional
	public Livro insere(Livro livro) {
		return livroRepository.save(livro);
	}

	@Transactional
	public Livro atualiza(Integer id, Livro livroNovo ) throws LivroNotFoundException {
		Livro livro = findById(id);
		livro.setAutor(livroNovo.getAutor());
		livro.setCategoria(livroNovo.getCategoria());
		livro.setDataPublicacao(livroNovo.getDataPublicacao());
		livro.setTitulo(livroNovo.getTitulo());
		return livroRepository.save(livro);
	}
	
	@Transactional
	public void apagaLivro(Integer id) throws LivroNotFoundException {
		Livro livro = findById(id);
		livroRepository.delete(livro);
	}

}
