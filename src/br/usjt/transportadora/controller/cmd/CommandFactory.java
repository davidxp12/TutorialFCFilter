package br.usjt.transportadora.controller.cmd;

public class CommandFactory {

	public static Command obterCommand(String operacao) throws Exception {

		if ("consultar".equals(operacao)) {
			return new CommandPesquisarVeiculo();
			
		} else if ("incluir".equals(operacao)) {
			return new CommandIncluirVeiculo();

		} else if ("salvarInclusao".equals(operacao)) {
			return new CommandSavarInclusaoVeiculo();
			
		} else {
			throw new Exception("Não existe command implementado para a operação informada");
		}
	}
}
