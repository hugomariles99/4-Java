package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;

public class CategoriaDAO {

private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		//Categoria pasa a managed por el select
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}
}
