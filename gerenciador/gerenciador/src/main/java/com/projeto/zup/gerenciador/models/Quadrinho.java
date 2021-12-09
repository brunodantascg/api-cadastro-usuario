package com.projeto.zup.gerenciador.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quadrinho {

	@GeneratedValue
	@Id
	private int comicId;
	
	@Column(name = "titulo", nullable=false)
	private String titulo;
		
	@Column(name = "preco", nullable=false)
	private Float preco;
	
	@Column(name = "autores", nullable=false)
	private String autores;
	
	@Column(name = "isbn", nullable=false, unique=true)
	private int isbn;

	@Column(name = "descricao", nullable=false)
	private String descricao;
	
	public Quadrinho() {
		
	}

	public Quadrinho(int id, String titulo, Float preco, String autores, int isbn, String descricao) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.isbn = isbn;
		this.descricao = descricao;
	}

	public int getComicId() {
		return comicId;
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
