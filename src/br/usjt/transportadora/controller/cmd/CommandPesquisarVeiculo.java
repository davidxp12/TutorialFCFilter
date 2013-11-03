package br.usjt.transportadora.controller.cmd;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.transportadora.model.Veiculo;

public class CommandPesquisarVeiculo extends Command {

	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//
		// Usuario clicou no botao 'pesquisar'
		//
		// Define parametros de busca e executa metodo pesquisar
		// da classe Veiculo
		//
		Veiculo v = new Veiculo();
		v.setChassi(request.getParameter("chassi"));
		v.setPlaca(request.getParameter("placa"));
		v.setModelo(request.getParameter("modelo"));
		v.setEstadoGeral(request.getParameter("estadoGeral"));
		v.setRegiaoEntrega(request.getParameter("regiaoEntrega"));

		List<Veiculo> retorno = new ArrayList<Veiculo>();
		retorno = v.pesquisar();

		// coloca o resultado na pesquisa na sessão Web
		//
		request.getSession().setAttribute("listaVeiculos", retorno);

		// retorna nome da pagina que sera redirecionado
		//
		return "consulta.jsp";
	}
}
