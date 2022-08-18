package com.biblioteca.entidad;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prestamos_libros")
public class Prestamos_libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "secuencia")
	private Integer secuencia;
	@Column (name = "prestamo")
	private Integer prestamo;
	@Column (name = "libro")
	private Integer libro;
	@Column (name = "estado")
	private Integer estado;
	@Column (name = "dias")
	private Integer dias;
	@Column (name = "valor")
	private Integer valor;
	@Column (name = "fecha_devolucion")
	private Date fecha_devolucion;
	
	public Prestamos_libros() {
		super();
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Integer getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Integer prestamo) {
		this.prestamo = prestamo;
	}

	public Integer getLibro() {
		return libro;
	}

	public void setLibro(Integer libro) {
		this.libro = libro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	
}
