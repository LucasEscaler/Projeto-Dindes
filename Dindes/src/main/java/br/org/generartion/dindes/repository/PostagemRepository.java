package br.org.generartion.dindes.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generartion.dindes.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);

	public Optional<Postagem> findFirstByTextoIgnoreCase(String texto);

	@Query(value = "select count(tema_id) from tb_postagem where tema_id = :id", nativeQuery = true)
	public int countPosts(@Param("id") long id);

}
