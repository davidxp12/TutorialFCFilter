package br.usjt.transportadora.controller.cmd;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.transportadora.model.Veiculo;

public abstract class Command {

	public abstract String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	/**
	 * Metodo para selecionar veiculo na lista de pesquisa.
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	protected Veiculo selecionarVeiculo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Veiculo> retorno = null;

		Veiculo veiculoSelecionado = null;

		//
		// Verificacao para garantir que usuario selecionou
		// um item na lista de Veiculos
		//
		if (request.getParameter("item") != null) {
			List<Veiculo> veiculos = 
				(List) request.getSession().getAttribute("listaVeiculos");
			Long l = Long.parseLong(request.getParameter("item"));
			for (Iterator<Veiculo> it = veiculos.iterator(); it.hasNext();) {
				veiculoSelecionado = (Veiculo) it.next();
				if (veiculoSelecionado.getId().equals(l)) {
					break;
				}
			}
			request.getSession().setAttribute("veiculoss", veiculoSelecionado);
		}

		return veiculoSelecionado;
	}
	
}
