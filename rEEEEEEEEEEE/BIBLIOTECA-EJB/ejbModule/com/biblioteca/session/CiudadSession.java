package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Ciudades;

@Stateless
public class CiudadSession {
	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;
	
	public List<Ciudades> consultarCiudades() {
		String jpql = "SELECT a FROM Ciudades a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Ciudades> ciudad = q.getResultList();

		return ciudad;
	}
	
	public List<Ciudades> consultarCiudadesPorDescripcion(String descripcion){
		String jpql = "select a from Ciudades a where upper (a.descripcion) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + descripcion.toUpperCase() + "%");
		List<Ciudades> ciudades = q.getResultList();
		
		return ciudades;
	}

	// Busqueda
	public Ciudades buscarporCodigo(Integer codigo) {
		Ciudades ciudad = em.find(Ciudades.class, codigo);
		return ciudad;
	}
	
	// Añadir
	public Ciudades incluir(Ciudades ciudad) {
		ciudad.setCodigo(null);
		em.persist(ciudad); // insertar
		em.refresh(ciudad); // consulta el dato insertado
		return ciudad;
	}

	// Editar
	public Ciudades editar(Ciudades ciudad) {
		ciudad = em.merge(ciudad);
		return ciudad;
	}

	// Incluye o edita un ciudad dependiendo de si existe o no
	public Ciudades actualizar(Ciudades ciudad) {
		Ciudades ciudadActualizado = null;
		Ciudades ciudadBuscar = buscarporCodigo(ciudad.getCodigo());
		if (ciudadBuscar == null) {
			ciudadActualizado = incluir(ciudad);
		} else {
			ciudadActualizado = editar(ciudad);
		}
		return ciudadActualizado;
	}

	// Eliminar
	public void eliminar(Integer codigo) {
		// Falta validar que pasa si se quiere eliminar un codigo no existente
		Ciudades ciudadBuscar = em.find(Ciudades.class, codigo);
		em.remove(ciudadBuscar);
	}
}
