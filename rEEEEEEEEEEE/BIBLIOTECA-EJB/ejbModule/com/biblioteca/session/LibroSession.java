package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Libros;

@Stateless
public class LibroSession {
	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;
	
	public List<Libros> consultarLibros() {
		String jpql = "SELECT a FROM Libros a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Libros> libro = q.getResultList();

		return libro;
	}
	
	public List<Libros> consultarLibrosPorDescripcion(String descripcion){
		String jpql = "select a from Libros a where upper (a.descripcion) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + descripcion.toUpperCase() + "%");
		List<Libros> libros = q.getResultList();
		
		return libros;
	}

	// Busqueda
	public Libros buscarporCodigo(Integer codigo) {
		Libros libro = em.find(Libros.class, codigo);
		return libro;
	}
	
	// Añadir
	public Libros incluir(Libros libro) {
		libro.setCodigo(null);
		em.persist(libro); // insertar
		em.refresh(libro); // consulta el dato insertado
		return libro;
	}

	// Editar
	public Libros editar(Libros libro) {
		libro = em.merge(libro);
		return libro;
	}

	// Incluye o edita un libro dependiendo de si existe o no
	public Libros actualizar(Libros libro) {
		Libros libroActualizado = null;
		Libros libroBuscar = buscarporCodigo(libro.getCodigo());
		if (libroBuscar == null) {
			libroActualizado = incluir(libro);
		} else {
			libroActualizado = editar(libro);
		}
		return libroActualizado;
	}

	// Eliminar
	public void eliminar(Integer codigo) {
		// Falta validar que pasa si se quiere eliminar un codigo no existente
		Libros libroBuscar = em.find(Libros.class, codigo);
		em.remove(libroBuscar);
	}
}
