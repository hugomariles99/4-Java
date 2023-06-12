package com.alura.gerenciador.action;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresa implements Action {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		DB db = new DB();
		Empresa empresa = db.buscarEmpresaPorId(id);

		request.setAttribute("empresa", empresa);

		return "forward:formModificarEmpresa.jsp";
	}

}
