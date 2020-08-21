package org.serratec.java2backend.livro.repositorio;

import java.util.List;

import org.serratec.java2backend.livro.entidade.Categoria;
import org.serratec.java2backend.livro.entidade.Livro;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
	//busca livro pelo autor passado como parametro
	List<Livro> findByAutor(String autor);
	
	
	@Query ("select L from Livro L join fetch L.categoria ")
	List<Livro> findByIdComCategoria(Sort sort);
	
	@Query("select L from Livro L where L.categoria = :categoria")
	List<Livro> findByCategoria(@Param("categoria") Categoria categoria);
	
	@Query("select L from Livro L join fetch L.categoria C where C.id = :id")
	List<Livro> findByCategoriaId(@Param("id") Integer categoria);

	//select L.*, C.* from Livro L join Categoria C on L.categoria_id = C.id where C.id = 10
	
	
	

}
