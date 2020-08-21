package org.serratec.java2backend.livro.services;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.livro.entidade.Categoria;
import org.serratec.java2backend.livro.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodas(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}

	private Categoria findById(Integer id) throws DataNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isPresent()) {
			return categoria.get();
		} else {
			throw new DataNotFoundException(id);
		}
	}
	
	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria atualizar(Integer id, Categoria categoriaNova) throws DataNotFoundException {
		Categoria categoria = findById(id);
		categoria.setNome(categoriaNova.getNome());
		return categoriaRepository.save(categoria);
	}
	
	public void apagar(Integer id) throws DataNotFoundException {
		Categoria categoria = findById(id);
		categoriaRepository.delete(categoria);
	}

}
