package controller;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;



@WebServlet("/Destinos")
public class ListarDestinos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destino> destinos = new ArrayList<Destino>();
		DestinoDAO dest = new DestinoDAO();		
		destinos = dest.getDestinos();		
		request.setAttribute("listaDestinos", destinos);
		
		// REDIRECIONA PARA PÁGINA CADASTRO COM A LISTA ATUALIZADA
		// TAMBÉM POSSO FAZER UMA PAG DE CADASTRO SEM LISTAR OS DADOS E OUTRA PÁG PARA CADASTRO E EXIBIÇÃO DA LISTA.
		RequestDispatcher rd = request.getRequestDispatcher("comprarpassagem.jsp");
		rd.forward(request, response);
		
		
	}

}
