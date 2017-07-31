package com.carboni.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carboni.socialbooks.domain.Autor;
import com.carboni.socialbooks.services.AutoresService;

@RestController
@RequestMapping("/authors") //Quando se define que o resource ou endpoing é definido no nome da classe, é  necessario utilizar @RequestMapping e não GetMapping 
public class AutoresResources {
	
	@Autowired
	private AutoresService autoresService; //injeta o serviço. O Serviço contém a regra de negocio (camada de serviço)
	
	@GetMapping
	private ResponseEntity<List<Autor>> list() {
		List<Autor> autores = autoresService.list();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
		// para retorno de todos os autores, é necessário construir um body passando como parametro o metodo que os lista.
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Autor autor) {
		autor = autoresService.save(autor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> search(@PathVariable("id") Long id) {
		Autor autor = autoresService.search(id);
		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}

}
