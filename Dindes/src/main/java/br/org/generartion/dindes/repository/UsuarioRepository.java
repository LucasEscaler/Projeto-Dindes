package br.org.generartion.dindes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generartion.dindes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
