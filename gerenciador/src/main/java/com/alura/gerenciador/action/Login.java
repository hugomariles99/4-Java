package com.alura.gerenciador.action;

import java.io.IOException;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Action {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String paramLogin = request.getParameter("login");
		String paramContrasena = request.getParameter("contrasena");

		DB db = new DB();
		Usuario usuario = db.existeUsuario(paramLogin, paramContrasena);

		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUsuario", usuario);
			return "redirect:ListaEmpresas";
		} else {
			return "redirect:LoginForm";
		}

	}

}
