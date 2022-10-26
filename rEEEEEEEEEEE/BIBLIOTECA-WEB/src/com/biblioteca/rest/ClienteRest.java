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

import com.biblioteca.entidad.Clientes;
import com.biblioteca.session.ClienteSession;

@Path("/cliente")
public class ClienteRest {
	@EJB
	ClienteSession cs;
	
	//Consultar de gobi
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.consultarClientes());
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
			retorno.put("cliente", cs.buscarporCodigo(codigo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-nombre")
	public Map<String, Object> consultarPorNombre(@QueryParam("nombre") String nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.consultarClientesPorNombre(nombre));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Clientes incluir(Clientes cliente) {
		return cs.incluir(cliente);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	public Clientes editar(Clientes cliente) {
		return cs.editar(cliente);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Clientes actualizar(Clientes cliente) {
		return cs.actualizar(cliente);
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") Integer codigo) {
		cs.eliminar(codigo);
	}
}
