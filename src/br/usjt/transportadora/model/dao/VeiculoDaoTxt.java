package br.usjt.transportadora.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.usjt.transportadora.model.Veiculo;

public class VeiculoDaoTxt implements VeiculoDao{
	
	@Override
	public List<Veiculo> pesquisarVeiculo(String chassi, String placa,
			String modelo, String estadoGeral, String regiaoEntrega) {
		Veiculo v = new Veiculo();
		v.setAno(2000);
		v.setCategoria("txt");
		v.setChassi("txt");
		v.setEstadoGeral("BOM");
		v.setId(new Long(200));
		v.setMarca("TXT");

		ArrayList l = new ArrayList<Veiculo>();
		l.add(v);
		
		return l;
	}

}
