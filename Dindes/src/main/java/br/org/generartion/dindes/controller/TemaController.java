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

import br.org.generartion.dindes.model.Tema;
import br.org.generartion.dindes.repository.TemaRepository;
import br.org.generartion.dindes.service.TemaService;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@Autowired
	private TemaService temaService;
	
	@GetMapping
	ResponseEntity<List<Tema>> GetAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeTema/{nomeTema}")
	public ResponseEntity<List<Tema>> GetByNomeTema(@PathVariable String nomeTema){
		return ResponseEntity.ok(repository.findAllByNomeTemaContainingIgnoreCase(nomeTema));
	}
	
	@PostMapping
	public ResponseEntity<Tema> postTema (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	

	@PutMapping
	public ResponseEntity<Tema> putTema (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/trendtopics")
	public ResponseEntity<List<Tema>> getTrendTopics() {
		
		return ResponseEntity.ok(temaService.trendTopics());
	
	}
}
