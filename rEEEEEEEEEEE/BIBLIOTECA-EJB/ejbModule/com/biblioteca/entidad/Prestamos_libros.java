package com.biblioteca.entidad;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestamos_libros")
public class Prestamos_libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pli_secuencia")
	private Integer secuencia;
	@ManyToOne
	@JoinColumn (name = "pli_prestamo")
	private Prestamos prestamo;
	@ManyToOne
	@JoinColumn (name = "pli_libro")
	private Libros libro;
	@Column (name = "pli_estado")
	private Integer estado;
	@Column (name = "pli_dias")
	private Integer dias;
	@Column (name = "pli_valor")
	private Integer valor;
	@Column (name = "pli_fecha_devolucion")
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

	public Prestamos getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamos prestamo) {
		this.prestamo = prestamo;
	}

	public Libros getLibro() {
		return libro;
	}

	public void setLibro(Libros libro) {
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
