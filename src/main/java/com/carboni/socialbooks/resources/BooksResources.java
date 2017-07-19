package com.carboni.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carboni.socialbooks.domain.Book;
import com.carboni.socialbooks.repository.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksResources {
	
	@Autowired
	private BooksRepository booksRepository;
	

	@GetMapping
	public ResponseEntity<List<Book>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findAll()); //Spring Data does this implementation
		//return Arrays.asList(books); // o proprio spring atraves do @RequestController ja retorna em formato json
	}
	
	//## Handling http response
	//# Best practice: Every time you create a resource make it returns 201 code (resource created) and inform taht URI where that resouce can be retrieved
	@PostMapping //by default either get and post method are pointing to /books declared at @RequestMethod("/books")
	public ResponseEntity<Void> save(@RequestBody Book book) { //get information by post and put it into Book object
		book = booksRepository.save(book);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(book.getId()).toUri();
		// Add an URI return to inform requester which resource has been created to this save
		// This is important to let the resquester know how to access the resource
		
		return ResponseEntity.created(uri).build(); //Using .build create response with uri that has been created
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> search(@PathVariable("id") Long id) { //Through @PathVariable I can get the variable /{id} and pass it as parameter to this method.
		//ResponseEntity encapsulates object return(book), and make possible to treat http response
		Book book = booksRepository.findOne(id);
		
		if (book == null) {
			return ResponseEntity.notFound().build(); //return 404 notfound and .build() to construct the body
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(book); //return status http 200 OK and put book object in the response body
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		try {
			booksRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody Book book, @PathVariable("id") Long id)  {
		book.setId(id); //assures that the resource is being updated is the resource in the URI not in the body
		booksRepository.save(book);
		// if id exists, updated it, if not create it. That's why is used setId(id)
	}
	
	
}
