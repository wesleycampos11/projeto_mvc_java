package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioDAO;



public class ExcluirConta extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idUsuario = Integer.parseInt(request.getParameter("id"));

		UsuarioDAO udao = new UsuarioDAO();

		udao.removeById(idUsuario);

		response.sendRedirect("delete-success-profile.html");
		
	}



}
