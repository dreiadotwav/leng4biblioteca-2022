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

import com.biblioteca.entidad.Ciudades;
import com.biblioteca.session.CiudadSession;

@Path("/ciudad")
public class CiudadRest {
	
	@EJB
	CiudadSession cs;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("ciudad", cs.consultarCiudades());
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
			retorno.put("ciudad", cs.buscarporCodigo(codigo));
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
			retorno.put("ciudad", cs.consultarCiudadesPorDescripcion(descripcion));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Ciudades incluir(Ciudades ciudad) {
		return cs.incluir(ciudad);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	public Ciudades editar(Ciudades ciudad) {
		return cs.editar(ciudad);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Ciudades actualizar(Ciudades ciudad) {
		return cs.actualizar(ciudad);
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") Integer codigo) {
		cs.eliminar(codigo);
	}
}
