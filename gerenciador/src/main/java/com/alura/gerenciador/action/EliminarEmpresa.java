package com.alura.gerenciador.action;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa implements Action {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		DB db = new DB();
		db.eliminarEmpresa(id);

		return "redirect:ListaEmpresas";
	}

}
