package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Mappeando la clase producto con la clase de la base de datos
@Entity
//Indica cuando el nombre de la clase de java tiene diferente nombre
// a la tabla de la base de datos
@Table(name = "productos")
@NamedQuery(name = "Producto.consultaDePrecio", query = "SELECT p.precio FROM Producto p WHERE p.nombre =:nombre")
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {

	// Indica cual es la columna de ID
	@Id
	// Indica que el valor de ID es auto generado, y la estrategia utilizada
	// por la base de datos
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @Column(name="nombres")
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now();

	// Muchos productos tienen una categoria
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
