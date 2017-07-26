package com.carboni.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carboni.socialbooks.domain.DetailsError;
import com.carboni.socialbooks.services.exceptions.BookNotFoundException;

@ControllerAdvice //This annotation allows spring to intercept all kind of exceptions in this program
public class ResourceExceptionHandler {
	
	// registrar handlers de exceção
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<DetailsError> handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		erro.setStatus(404l);
		erro.setTitle("The book could not be found");
		erro.setDeveloperMessage("http://erros.socialbooks.com/404"); //As a best practice we should have resources to show all errors available and how the client could handle it.
		erro.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity.notFound().build(); //Any exception caught by BookNotFoundException will return notFound
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}

}
