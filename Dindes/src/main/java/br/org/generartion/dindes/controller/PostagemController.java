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

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	ResponseEntity<List<Postagem>> GetAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> GetByTexto(@PathVariable String Texto){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(Texto));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem Postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem Postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	} 

}
