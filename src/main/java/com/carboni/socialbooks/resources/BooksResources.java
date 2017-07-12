package com.carboni.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carboni.socialbooks.domain.Book;
import com.carboni.socialbooks.repository.BooksRepository;

@RestController
public class BooksResources {
	
	@Autowired
	private BooksRepository booksRepository;
	

	@GetMapping("/books")
	public List<Book> list() {
		
		return booksRepository.findAll(); //Spring Data does this implementation
		
		
		//return Arrays.asList(books); // o proprio spring atraves do @RequestController ja retorna em formato json
	}
}
