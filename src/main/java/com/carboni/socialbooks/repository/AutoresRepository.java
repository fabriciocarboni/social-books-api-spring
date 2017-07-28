package com.carboni.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carboni.socialbooks.domain.Autor;


//Toda vez que cria-se uma Entidade anotada com @Entity, deve-se criar uma interface
//Na hroa de extender, informaro tipo do JpaRepository, neste caso é o Autor e infomrar o Serializable que é o tipo do 
//identificador (chave unica) desta tabela. Neste cas é um Long

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
