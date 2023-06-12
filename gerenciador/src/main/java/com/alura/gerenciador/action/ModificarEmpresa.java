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

public class ModificarEmpresa implements Action {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String paramNombre = request.getParameter("nombre");
		String paramFecha = request.getParameter("fecha");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Date fechaAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fechaAbertura = sdf.parse(paramFecha);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB db = new DB();
		Empresa empresa = db.buscarEmpresaPorId(id);
		empresa.setNombre(paramNombre);
		empresa.setFechaAbertura(fechaAbertura);

		return "redirect:ListaEmpresas";
	}

}
