package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Prestamos;

@Stateless
public class PrestamoSession {
	
	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;
	
	public List<Prestamos> consultarPrestamos() {
		String jpql = "SELECT a FROM Prestamos a ORDER BY a.numero";

		Query q = em.createQuery(jpql);
		List<Prestamos> prestamo = q.getResultList();

		return prestamo;
	}
	
	public List<Prestamos> consultarPrestamosPorNombre(Integer cliente){
		String jpql = "select a from Prestamos a where upper (a.cliente) like :n order by a.numero";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + cliente + "%");
		List<Prestamos> prestamos = q.getResultList();
		
		return prestamos;
	}

	// Busqueda
	public Prestamos buscarporNumero(Integer numero) {
		Prestamos prestamo = em.find(Prestamos.class, numero);
		return prestamo;
	}
	
	// Añadir
	public Prestamos incluir(Prestamos prestamo) {
		prestamo.setNumero(null);
		em.persist(prestamo); // insertar
		em.refresh(prestamo); // consulta el dato insertado
		return prestamo;
	}

	// Editar
	public Prestamos editar(Prestamos prestamo) {
		prestamo = em.merge(prestamo);
		return prestamo;
	}

	// Incluye o edita un prestamo dependiendo de si existe o no
	public Prestamos actualizar(Prestamos prestamo) {
		Prestamos prestamoActualizado = null;
		Prestamos prestamoBuscar = buscarporNumero(prestamo.getNumero());
		if (prestamoBuscar == null) {
			prestamoActualizado = incluir(prestamo);
		} else {
			prestamoActualizado = editar(prestamo);
		}
		return prestamoActualizado;
	}

	// Eliminar
	public void eliminar(Integer numero) {
		// Falta validar que pasa si se quiere eliminar un numero no existente
		Prestamos prestamoBuscar = em.find(Prestamos.class, numero);
		em.remove(prestamoBuscar);
	}
}
