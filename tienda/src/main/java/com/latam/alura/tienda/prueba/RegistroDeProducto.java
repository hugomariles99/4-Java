package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorId(1l);
		System.out.println(producto.getNombre());
		
		BigDecimal precio =productoDAO.consultaPrecioPorNombreDeProductoNamedQuery("Xiaomi Redmi");
		System.out.println(precio);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Xiaomi Redmi", "Muy legal", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);

		em.getTransaction().commit();
	}

}

/////////////////////////////////////////////////////////////////
//Categoria celulares = new Categoria("CELULARES");
//
//EntityManager em = JPAUtils.getEntityManager();
//
//
//em.getTransaction().begin();
////Insert
//em.persist(celulares);
////Cambio de nombre
//celulares.setNombre("LIBROS");
//
////Update
//em.flush();
////Cambia de managed a detached
//em.clear();
//
////Cambia de detached a managed por el select de merge
//celulares = em.merge(celulares);
////Cambio de nombre
//celulares.setNombre("SOFTWARES");
//
////Update
//em.flush();
////Cambia de managed a detached
//em.clear();
//
////Cambia de detached a managed por el select de merge
//celulares = em.merge(celulares);
////Borra de la base de datos
//em.remove(celulares);
//em.flush();