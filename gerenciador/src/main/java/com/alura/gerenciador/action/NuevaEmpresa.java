package com.alura.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa implements Action {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String nombreEmpresa = request.getParameter("nombre");
		String fechaEmpresa = request.getParameter("fecha");

		Date fechaAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fechaAbertura = sdf.parse(fechaEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaAbertura(fechaAbertura);

		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);

		return "redirect:ListaEmpresas";
	}

}
