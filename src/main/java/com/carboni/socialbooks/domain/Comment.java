package com.carboni.socialbooks.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String texto;
	private String usuario;
	private Date data;
	
	
	/*
	 * É para avisar ao Hibernate para não retornar os dados dessa propriedade junto com as outras.
		Daí ele só retorna os dados dela quando a propriedade for utilizada. Ele usa técnicas de Proxy para isso. Basicamente, é a API de reflexão do Java.
		Essa propriedade é, por padrão, EAGER, exceto nas listas que ela é LAZY.
	 * */
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "BOOK_ID")
	@JsonIgnore //para nao colocar a informacao do livro nos comentarios. Para não listar os livros dentro de um comentario em virtude do join entre comment e book
	private Book book;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	

}
