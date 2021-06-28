package br.org.generartion.dindes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generartion.dindes.model.Postagem;
import br.org.generartion.dindes.repository.PostagemRepository;
import br.org.generartion.dindes.service.PostagemService;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	// injeção da classe Service
	
	@Autowired
	private PostagemService postagemService;
	
	// metodo que mostra todas as postagens
	@GetMapping
	ResponseEntity<List<Postagem>> GetAllPostagem (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	//metodo traz uma postagem por id
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetByIdPostagem(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// metodo que busca postagens por texto
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> GetByTexto(@PathVariable String texto){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
	}
	
	// metodo que posta as postagens 
	@PostMapping
	public ResponseEntity<Postagem> postPostagem (@RequestBody Postagem texto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(texto));
	}

	// metodo que altera as postagens
	@PutMapping
	public ResponseEntity<Postagem> putPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	// metodo que deleta uma postagem
	@DeleteMapping("/{id}")
	public void deletePostagem (@PathVariable long id) {
		repository.deleteById(id);
	} 
	
	// metodo para curtir postagens
	@PutMapping("/curtir/{id}")
	public ResponseEntity<Postagem> putCurtirPostagemId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.curtir(id));
	}
	
	// metodo para descurtir uma postagem
	@PutMapping("/descurtir/{id}")
	public ResponseEntity<Postagem> putDescurtirPostagemId (@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.descurtir(id));
	
	}

}
