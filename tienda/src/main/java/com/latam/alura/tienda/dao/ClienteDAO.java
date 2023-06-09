package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Cliente;

public class ClienteDAO {

	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void guardar(Cliente Cliente) {
		this.em.persist(Cliente);
	}

	public Cliente consultaPorId(Long id) {
		return em.find(Cliente.class, id);
	}

	public List<Cliente> consultarTodos() {
		String jpql = "SELECT p FROM Cliente p";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public List<Cliente> consultaPorNombre(String nombre) {
		String jpql = "SELECT p FROM Cliente p WHERE p.nombre =:nombre";
		return em.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
	}

	public List<Cliente> consultaPorNombreDeCategoria(String nombre) {
		String jpql = "SELECT p FROM Cliente p WHERE p.categoria.nombre =:nombre";
		return em.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
	}

	public BigDecimal consultaPrecioPorNombreDeCliente(String nombre) {
		String jpql = "SELECT p.precio FROM Cliente p WHERE p.nombre =:nombre";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
