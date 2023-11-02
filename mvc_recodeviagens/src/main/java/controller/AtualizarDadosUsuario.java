package controller;

import java.io.IOException; 
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;


public class AtualizarDadosUsuario extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * int idUsuario = Integer.parseInt(request.getParameter("id"));
		 * 
		 * UsuarioDAO u = new UsuarioDAO(); Usuario usuarioSelecionado =
		 * u.getUsuarioById(idUsuario);
		 * 
		 * request.setAttribute("usuario", usuarioSelecionado);
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("/infocadastrais.jsp");
		 * 
		 * rd.forward(request, response);
		 */

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuarioAtualizado = new Usuario();

		usuarioAtualizado.setNome(request.getParameter("nome"));
		usuarioAtualizado.setTelefone(request.getParameter("tel"));
		usuarioAtualizado.setEmail(request.getParameter("email"));
		usuarioAtualizado.setSenha(request.getParameter("senha"));
		usuarioAtualizado.setDataAtualizacaoCadastro(new Date());

		usuarioAtualizado.setId(Integer.parseInt(request.getParameter("id")));

		UsuarioDAO u = new UsuarioDAO();
		u.update(usuarioAtualizado);

		// A VARIÁVEL ERRO RECEBE O VALOR DAS ASPAS
		request.setAttribute("sucesso",
				"Dados atualizados com sucesso! As informações atualizadas" + " aparecerão no próximo acesso/login.");
		RequestDispatcher rd = request.getRequestDispatcher("infocadastrais.jsp");
		rd.forward(request, response); // ENCAMINHA P/ PAGE

		// response.sendRedirect("infocadastrais.jsp");

	}

}
