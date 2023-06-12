package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAction = request.getParameter("action");
//
//		HttpSession session = request.getSession();
//		Boolean notLogged = (session.getAttribute("loginUsuario") == null);
//		
//		Boolean protectedAction = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));
//		
//		if (notLogged && protectedAction) {
//			response.sendRedirect("entrada?action=LoginForm");
//			return;
//		}

		String nombreDeClase = "com.alura.gerenciador.action." + paramAction;

		String nombre;
		try {
			Class clase = Class.forName(nombreDeClase);
			Action action = (Action) clase.newInstance();
			nombre = action.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			throw new ServletException(e);
		}

		String[] tipoDireccion = nombre.split(":");

		if (tipoDireccion[0].equals("forward")) {
			RequestDispatcher rDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoDireccion[1]);
			rDispatcher.forward(request, response);
		} else {
			response.sendRedirect("entrada?action=" + tipoDireccion[1]);
		}

		/*
		 * if (paramAction.equals("ListaEmpresas")) {
		 * 
		 * ListaEmpresas action = new ListaEmpresas(); nombre = action.ejecutar(request,
		 * response);
		 * 
		 * } else if (paramAction.equals("MostrarEmpresa")) {
		 * 
		 * MostrarEmpresa action = new MostrarEmpresa(); nombre =
		 * action.ejecutar(request, response);
		 * 
		 * } else if (paramAction.equals("EliminarEmpresa")) {
		 * 
		 * EliminarEmpresa action = new EliminarEmpresa(); nombre =
		 * action.ejecutar(request, response);
		 * 
		 * } else if (paramAction.equals("ModificarEmpresa")) {
		 * 
		 * ModificarEmpresa action = new ModificarEmpresa(); nombre =
		 * action.ejecutar(request, response);
		 * 
		 * } else if (paramAction.equals("NuevaEmpresa")) {
		 * 
		 * NuevaEmpresa action = new NuevaEmpresa(); nombre = action.ejecutar(request,
		 * response);
		 * 
		 * } else if (paramAction.equals("NuevaEmpresaForm")) {
		 * 
		 * NuevaEmpresaForm action = new NuevaEmpresaForm(); nombre =
		 * action.ejecutar(request, response);
		 * 
		 * }
		 */

	}

}
