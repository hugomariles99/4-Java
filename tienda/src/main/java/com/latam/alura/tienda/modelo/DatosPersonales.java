package com.latam.alura.tienda.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DatosPersonales implements Serializable{

	private String nombre;
	private String dni;

	public DatosPersonales() {
		super();
	}

	public DatosPersonales(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
