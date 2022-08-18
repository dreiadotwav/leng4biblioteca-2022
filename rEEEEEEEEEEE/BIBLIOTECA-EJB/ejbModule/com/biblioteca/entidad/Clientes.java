package com.biblioteca.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "codigo")
		private Integer codigo;
		@Column (name = "nombre")
		private String nombre;
		@Column (name = "ciudad")
		private Integer ciudad;
		@Column (name = "direccion")
		private String direccion;
		@Column (name = "obs")
		private String obs;
		
		public Clientes() {
			super();
		}
		
		public Integer getCodigo() {
			return codigo;
		}
		
		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getCiudad() {
			return ciudad;
		}

		public void setCiudad(Integer ciudad) {
			this.ciudad = ciudad;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getObs() {
			return obs;
		}

		public void setObs(String obs) {
			this.obs = obs;
		}
		
		
	}
