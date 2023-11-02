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



public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CadastrarUsuario() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// criando o objeto contato 
		Usuario u =  new Usuario();
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
	
		
		// guardando os dados do formulario do objeto
		u.setNome(nome);
		u.setCpf(cpf);
		u.setEmail(email);
		u.setSenha(senha);
		u.setDataCadastro(new Date());
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		UsuarioDAO udao = new UsuarioDAO();		
		udao.save(u);
		
		request.setAttribute("Usuario", u);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		RequestDispatcher rd = request.getRequestDispatcher("success.html");
		rd.forward(request, response);
		
	}

}
