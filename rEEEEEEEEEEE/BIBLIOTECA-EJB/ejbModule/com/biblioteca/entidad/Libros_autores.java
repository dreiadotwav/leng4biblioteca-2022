package com.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros_autores")
public class Libros_autores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lau_autor")
	private Integer autor;
	@Column (name = "lau_libro")
	private Integer libro;
	
	public Libros_autores() {
		super();
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public Integer getLibro() {
		return libro;
	}

	public void setLibro(Integer libro) {
		this.libro = libro;
	}
	

}
