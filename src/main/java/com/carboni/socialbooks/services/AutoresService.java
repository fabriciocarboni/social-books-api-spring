package com.carboni.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carboni.socialbooks.domain.Autor;
import com.carboni.socialbooks.repository.AutoresRepository;
import com.carboni.socialbooks.services.exceptions.AuthorExistentException;
import com.carboni.socialbooks.services.exceptions.AuthorNotFoundException;

@Service //é o esteoreotipo que o spring usa para saber que esta é uma camada de serviço 
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	//lista todos os autores
	public List<Autor> list() { //listar autores
		return autoresRepository.findAll();
	}
	
	public Autor save(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.findOne(autor.getId());
			
			if(a != null) {
				throw new AuthorExistentException("Author alread exists.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor search(Long id) {
		Autor autor = autoresRepository.findOne(id);
		
		if(autor == null) {
			throw new AuthorNotFoundException("Author could not be found.");
		}
		return autor;
	}

}
