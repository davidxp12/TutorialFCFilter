package br.usjt.transportadora.model.dao;

import java.util.List;

import br.usjt.transportadora.model.Veiculo;

public interface VeiculoDao {
	
	public List<Veiculo> pesquisarVeiculo(String chassi, String placa, String modelo,
			String estadoGeral, String regiaoEntrega);

}
