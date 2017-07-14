package com.carboni.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carboni.socialbooks.domain.Book;
import com.carboni.socialbooks.repository.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksResources {
	
	@Autowired
	private BooksRepository booksRepository;
	

	@GetMapping
	public List<Book> list() {
		return booksRepository.findAll(); //Spring Data does this implementation
		//return Arrays.asList(books); // o proprio spring atraves do @RequestController ja retorna em formato json
	}
	
	
	@PostMapping //by default either get and post method are pointing to /books declared at @RequestMethod("/books")
	public void save(@RequestBody Book book) { //get information by post and put it into Book object
		booksRepository.save(book);
	}
	
	@GetMapping("/{id}")
	public Book search(@PathVariable("id") Long id) { //Through @PathVariable I can get the variable /{id} and pass it as parameter to this method.
		return booksRepository.findOne(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		booksRepository.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody Book book, @PathVariable("id") Long id)  {
		book.setId(id); //assures that the resource is being updated is the resource in the URI not in the body
		booksRepository.save(book);
		// if id exists, updated it, if not create it. That's why is used setId(id)
	}
	
	
}
