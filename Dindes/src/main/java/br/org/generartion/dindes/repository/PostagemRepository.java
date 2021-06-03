package br.org.generartion.dindes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.generartion.dindes.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByTextoContainingIgnoreCase (String texto);

}
