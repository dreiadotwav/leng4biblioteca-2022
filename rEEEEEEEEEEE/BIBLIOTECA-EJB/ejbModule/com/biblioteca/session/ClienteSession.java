package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Clientes;

@Stateless
public class ClienteSession {
	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;
	
	public List<Clientes> consultarClientes() {
		String jpql = "SELECT a FROM Clientes a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Clientes> cliente = q.getResultList();

		return cliente;
	}
	
	public List<Clientes> consultarClientesPorNombre(String nombre){
		String jpql = "select a from Clientes a where upper (a.nombre) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + nombre.toUpperCase() + "%");
		List<Clientes> clientes = q.getResultList();
		
		return clientes;
	}

	// Busqueda
	public Clientes buscarporCodigo(Integer codigo) {
		Clientes cliente = em.find(Clientes.class, codigo);
		return cliente;
	}
	
	// Añadir
	public Clientes incluir(Clientes cliente) {
		cliente.setCodigo(null);
		em.persist(cliente); // insertar
		em.refresh(cliente); // consulta el dato insertado
		return cliente;
	}

	// Editar
	public Clientes editar(Clientes cliente) {
		cliente = em.merge(cliente);
		return cliente;
	}

	// Incluye o edita un cliente dependiendo de si existe o no
	public Clientes actualizar(Clientes cliente) {
		Clientes clienteActualizado = null;
		Clientes clienteBuscar = buscarporCodigo(cliente.getCodigo());
		if (clienteBuscar == null) {
			clienteActualizado = incluir(cliente);
		} else {
			clienteActualizado = editar(cliente);
		}
		return clienteActualizado;
	}

	// Eliminar
	public void eliminar(Integer codigo) {
		// Falta validar que pasa si se quiere eliminar un codigo no existente
		Clientes clienteBuscar = em.find(Clientes.class, codigo);
		em.remove(clienteBuscar);
	}
}
