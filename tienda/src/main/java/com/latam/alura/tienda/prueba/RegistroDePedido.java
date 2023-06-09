package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ClienteDAO;
import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.vo.RelatorioDeVenta;

public class RegistroDePedido {

	public static void main(String[] args) {
		registrarProducto();

		EntityManager em = JPAUtils.getEntityManager();

		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorId(1l);

		ClienteDAO clienteDAO = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);

		Cliente cliente = new Cliente("Juan", "k6757kjb");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5, producto, pedido));

		em.getTransaction().begin();

		clienteDAO.guardar(cliente);
		pedidoDAO.guardar(pedido);

		em.getTransaction().commit();

		BigDecimal valorTotal = pedidoDAO.valorTotalVendido();
		System.out.println("Valor total: $" + valorTotal);

		List<RelatorioDeVenta> relatorio = pedidoDAO.relatorioDeVentasVO();

		relatorio.forEach(System.out::println);
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
		em.close();
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