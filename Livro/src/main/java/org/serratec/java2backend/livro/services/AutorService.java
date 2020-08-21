package org.serratec.java2backend.livro.services;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.livro.entidade.Autor;
import org.serratec.java2backend.livro.repositorio.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> buscarTodas(){
		return autorRepository.findAll();
	}
	
	public Autor buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}

	private Autor findById(Integer id) throws DataNotFoundException {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent()) {
			return autor.get();
		} else {
			throw new DataNotFoundException(id);
		}
	}
	
	public Autor salvar(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Autor atualizar(Integer id, Autor autorNova) throws DataNotFoundException {
		Autor autor = findById(id);
		autor.setNome(autorNova.getNome());
		return autorRepository.save(autor);
	}
	
	public void apagar(Integer id) throws DataNotFoundException {
		Autor autor = findById(id);
		autorRepository.delete(autor);
	}
	
	

}
