package com.crud.livraria.models;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigoLivro;
	
	private String titulo;
	private String autorNome;
	private String autorSobrenome;
	private String isbn;
	private String editora;
	private int edicao;
	private int numeroPaginas;
	private String imgPath;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public long getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(long codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutorNome() {
		return autorNome;
	}

	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}

	public String getAutorSobrenome() {
		return autorSobrenome;
	}

	public void setAutorSobrenome(String autorSobrenome) {
		this.autorSobrenome = autorSobrenome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

    public void salvarFoto(MultipartFile foto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarFoto'");
    }

	public String getImgPath() {
		return titulo;
	}

	public void setImgPath(String titulo) {
		this.titulo = titulo;
	}
}
