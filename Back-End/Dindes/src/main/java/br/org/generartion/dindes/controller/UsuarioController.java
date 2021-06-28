package br.org.generartion.dindes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generartion.dindes.model.Usuario;
import br.org.generartion.dindes.model.UsuarioLogin;
import br.org.generartion.dindes.repository.UsuarioRepository;
import br.org.generartion.dindes.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

    @GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());				
	}
    
    @GetMapping("/nome/{nome}")
  	public ResponseEntity<List<Usuario>> findByNome(@PathVariable String nome){
  		return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));
  	}
    
    @GetMapping("/nomeUsuario/{usuario}")
  	public ResponseEntity<List<Usuario>> findByUsuario(@PathVariable String usuario){
  		return ResponseEntity.ok(usuarioRepository.findAllByUsuarioContainingIgnoreCase(usuario));
  	}

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Usuario>> Post(@RequestBody Usuario usuario) {
		
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(user);

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

	@PutMapping("/alterar")
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		Optional<Usuario> user = usuarioService.atualizarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
