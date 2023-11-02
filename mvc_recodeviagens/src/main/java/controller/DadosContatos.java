package controller;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import model.Contato;
import model.ContatoDAO;

import java.io.IOException;
import java.util.Date;




public class DadosContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DadosContatos() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// criando o objeto contato 
		Contato c =  new Contato();
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String assunto = request.getParameter("assunto");
		String comentario = request.getParameter("comentario");
	
		
		// guardando os dados do formulario do objeto
		c.setNome(nome);
		c.setEmail(email);
		c.setTelefone(telefone);
		c.setAssunto(assunto);
		c.setComentario(comentario);
		c.setDataCadastro(new Date());
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ContatoDAO cdao = new ContatoDAO();		
		cdao.save(c);
		
		request.setAttribute("Contato", c);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		RequestDispatcher rd = request.getRequestDispatcher("success2.html");
		rd.forward(request, response);
		
	}

}