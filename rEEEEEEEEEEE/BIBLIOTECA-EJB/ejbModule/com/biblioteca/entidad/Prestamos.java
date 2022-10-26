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
@Table(name = "prestamos")
public class Prestamos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pre_numero")
	private Integer numero;
	@ManyToOne
	@JoinColumn (name = "pre_cliente")
	private Clientes cliente;
	@ManyToOne
	@JoinColumn (name = "pre_usuario")
	private Usuarios usuario;
	@Column (name = "pre_fecha")
	private Date fecha;
	@Column (name = "pre_obs")
	private String obs;
	@Column (name = "pre_situacion")
	private Integer situacion;
	@Column (name = "pre_total")
	private Integer total;
	
	public Prestamos() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getSituacion() {
		return situacion;
	}

	public void setSituacion(Integer situacion) {
		this.situacion = situacion;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	

}
