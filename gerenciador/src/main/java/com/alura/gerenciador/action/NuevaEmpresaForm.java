package com.alura.gerenciador.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresaForm implements Action{

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		return "forward:formNuevaEmpresa.jsp";
	}
}
