package org.serratec.java2backend.livro.repositorio;

import org.serratec.java2backend.livro.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	
}
