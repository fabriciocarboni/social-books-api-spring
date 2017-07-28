package com.carboni.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carboni.socialbooks.domain.Autor;
import com.carboni.socialbooks.repository.AutoresRepository;

@Service //é o esteoreotipo que o spring usa para saber que esta é uma camada de serviço 
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	//lista todos os autores
	public List<Autor> list() { //listar autores
		return autoresRepository.findAll();
	}

}
