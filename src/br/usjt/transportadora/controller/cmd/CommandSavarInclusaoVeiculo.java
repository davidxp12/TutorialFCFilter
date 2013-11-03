package br.usjt.transportadora.controller.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.transportadora.model.Veiculo;

public class CommandSavarInclusaoVeiculo extends Command {

	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//
		// Usuario clicou no botao Salvar da tela de Inclusao
		//
		// cria instancia de objeto Veiculo
		// chama metodo incluir para gravar no banco de dados
		//
		Veiculo v = new Veiculo();
		v.setMarca(request.getParameter("marca"));
		v.setModelo(request.getParameter("modelo"));
		v.setCategoria(request.getParameter("categoria"));
		v.setAno(Integer.parseInt(request.getParameter("ano")));
		v.setPlaca(request.getParameter("placa"));
		v.setChassi(request.getParameter("chassi"));
		v.setEstadoGeral(request.getParameter("estadoGeral"));
		v.setRegiaoEntrega(request.getParameter("regiaoEntrega"));
		v.setTipoMercadoria(request.getParameter("tipoMercadoria"));
		v.setQuantidadeMaxima(Integer.parseInt(request
				.getParameter("quantidadeMaxima")));

		v.incluir();

		// limpa lista de veiculos da sessao
		//
		request.getSession().setAttribute("listaVeiculos", new ArrayList());

		return "consulta.jsp";
	}
}
