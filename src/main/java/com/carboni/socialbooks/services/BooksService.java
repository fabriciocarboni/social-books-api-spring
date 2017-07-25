package com.carboni.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carboni.socialbooks.domain.Book;
import com.carboni.socialbooks.repository.BooksRepository;
import com.carboni.socialbooks.services.exceptions.BookNotFoundException;

@Service //Tell to spring that this class is a service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Book> list() {
		return booksRepository.findAll();
	}
	
	public Book search(long id) {
		Book book = booksRepository.findOne(id);
		
		if(book == null) {
			throw new BookNotFoundException("The book could not be found");
		}
		return book;
	}
	
	
	public Book save(Book book) {
		book.setId(null); //Garante que está criando uma instancia nova e nao vai atualizar nenuma. O save faz o merge, se tiver uma instancia com o id ele update
		return booksRepository.save(book);
	}
	
	public void delete(Long id) {
		try {
			booksRepository.delete(id);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("The book could not be found");
		}
	}
	
	public void update(Book book){
		this.checkBookExistence(book);
		booksRepository.save(book);
	}
	
	private void checkBookExistence(Book book){
		this.search(book.getId());
	}
	
}
