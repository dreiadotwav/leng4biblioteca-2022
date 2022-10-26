package com.biblioteca.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.biblioteca.entidad.Prestamos;
import com.biblioteca.session.PrestamoSession;

@Path("/prestamo")
public class PrestamoRest {
	
	@EJB
	PrestamoSession ps;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("prestamo", ps.consultarPrestamos());
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-numero")
	public Map<String, Object> buscarporNumero(@QueryParam("numero") Integer numero) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("prestamo", ps.buscarporNumero(numero));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-cliente")
	public Map<String, Object> consultarPorPrestamo(@QueryParam("prestamo") Integer prestamo) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("prestamo", ps.consultarPrestamosPorNombre(prestamo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Prestamos incluir(Prestamos prestamo) {
		return ps.incluir(prestamo);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	public Prestamos editar(Prestamos prestamo) {
		return ps.editar(prestamo);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Prestamos actualizar(Prestamos prestamo) {
		return ps.actualizar(prestamo);
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") Integer numero) {
		ps.eliminar(numero);
	}
}
