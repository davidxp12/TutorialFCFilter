package br.usjt.transportadora.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.transportadora.controller.cmd.Command;
import br.usjt.transportadora.controller.cmd.CommandFactory;
import br.usjt.transportadora.model.Veiculo;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 // coloca uma lista vazia na sessao
		 //
		 request.getSession().setAttribute("listaVeiculos",
		 new ArrayList<Veiculo>());
		 request.getRequestDispatcher("consulta.jsp").forward(request,
		 response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//
		// Verifica a acao do usuario.
		//

		String operacao = request.getParameter("operacao");

		try {
			Command cmd = CommandFactory.obterCommand(operacao);
			String paginaDestino = cmd.executar(request, response);

			request.getRequestDispatcher(paginaDestino).forward(request,response);

		} catch (Exception e) {
			// tratamento de erro
			//
			trataErro(request, response, e);
		}

	}

	/**
	 * Metodo auxiliar para selecionar objeto Veiculo da sessao do usuario.
	 * 
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */

	/**
	 * Metodo auxiliar para tratamento de erros
	 * 
	 * @param request
	 * @param response
	 * @param e
	 * @throws ServletException
	 * @throws IOException
	 */
	private void trataErro(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		// envia para pagina de erro
		//
		request.getSession().setAttribute("erro", e.toString());
		request.getRequestDispatcher("erro.jsp").forward(request, response);
	}
}
