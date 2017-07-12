package com.carboni.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carboni.socialbooks.domain.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{
	

}
