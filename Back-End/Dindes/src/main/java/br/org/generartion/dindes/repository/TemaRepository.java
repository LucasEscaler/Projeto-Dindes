package br.org.generartion.dindes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generartion.dindes.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByNomeTemaContainingIgnoreCase (String nomeTema);

}
