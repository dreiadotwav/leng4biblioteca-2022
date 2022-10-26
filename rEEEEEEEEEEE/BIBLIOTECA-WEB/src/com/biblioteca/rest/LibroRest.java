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

import com.biblioteca.entidad.Libros;
import com.biblioteca.session.LibroSession;

@Path("/libro")
public class LibroRest {
	
	@EJB
	LibroSession ls;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("libro", ls.consultarLibros());
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-codigo")
	public Map<String, Object> buscarporCodigo(@QueryParam("codigo") Integer codigo) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("libro", ls.buscarporCodigo(codigo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-descripcion")
	public Map<String, Object> consultarPorDescripcion(@QueryParam("descripcion") String descripcion) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("libro", ls.consultarLibrosPorDescripcion(descripcion));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Libros incluir(Libros libro) {
		return ls.incluir(libro);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	public Libros editar(Libros libro) {
		return ls.editar(libro);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Libros actualizar(Libros libro) {
		return ls.actualizar(libro);
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") Integer codigo) {
		ls.eliminar(codigo);
	}
}
