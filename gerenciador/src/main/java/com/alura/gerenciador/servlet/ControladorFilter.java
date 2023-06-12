package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.action.Action;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAction = request.getParameter("action");

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

	}

}
