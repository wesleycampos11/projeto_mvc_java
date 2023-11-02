package controller;

import java.io.IOException; 
//import java.util.ArrayList;
//import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.UsuarioDAO;


public class Logar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PÁGINA PARA FAZER O LOGIN - A REQUISIÇÃO É ENCAMINHADA PARA ESTA PÁGINA

		// RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // CAMINHO
		// DO ARQUIVO DE LOGIN
		// rd.forward(request, response); // ENCAMINHA P/ PAGE

	}
	*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PROCESSA O LOGIN

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		// ACESSANDO A DAO
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario u = new Usuario();

		u = usuarioDAO.buscarUsuarioPorEmail(email);

		boolean logado = false;


		if(u != null && u.getSenha().equals(senha)) {
			
			logado = true;
									
		} 
		
		if (logado) {
			
			// SESSÃO PARA GUARDAR OS DADOS DO USUÁRIO
			HttpSession session = request.getSession();
			
			// ATRIBUTO = "USUÁRIOLOGADO" QUE RECEBE O VALOR DE U.
			session.setAttribute("usuarioLogado", u);
			
			 // SE LOGIN FOR TRUE, USUÁRIO LOGA 		
			RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
			rd.forward(request, response);

			
		} else {
			
			logado = false; 
			
			// A VARIÁVEL ERRO RECEBE O VALOR DAS ASPAS
			request.setAttribute("erro", "E-mail e/ou Senha incorretos");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response); // ENCAMINHA P/ PAGE
			
		}		
		




	}

}
