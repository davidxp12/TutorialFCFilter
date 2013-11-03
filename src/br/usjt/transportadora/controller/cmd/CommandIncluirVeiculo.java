package br.usjt.transportadora.controller.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandIncluirVeiculo extends Command {

	public String executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setAttribute("operacao", "incluir");
		return "inclusao.jsp";
		
	}
}
