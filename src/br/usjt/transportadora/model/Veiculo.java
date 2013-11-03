package br.usjt.transportadora.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.transportadora.model.dao.DaoFactory;
import br.usjt.transportadora.model.dao.DaoFactoryDinamico;
import br.usjt.transportadora.model.dao.VeiculoDao;

/**
 * 
 * @author Rogério A. Rondini
 * 
 */
public class Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4759387624081920553L;

	private Long id;
	private String marca = "";
	private String modelo = "";
	private String categoria = "";
	private int ano;
	private String placa = "";
	private String chassi = "";
	private String estadoGeral = "";
	private String regiaoEntrega = "";
	private String tipoMercadoria = "";
	private int quantidadeMaxima;

	public Long getId() {
		if (id == null) {
			return new Long(0);
		} else {
			return id;
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getEstadoGeral() {
		return estadoGeral;
	}

	public void setEstadoGeral(String estadoGeral) {
		this.estadoGeral = estadoGeral;
	}

	public String getRegiaoEntrega() {
		return regiaoEntrega;
	}

	public void setRegiaoEntrega(String regiaoEntrega) {
		this.regiaoEntrega = regiaoEntrega;
	}

	public String getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public int getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(int quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	/**
	 * Inclusão de veículos na base de dados
	 * 
	 * @throws Exception
	 */
	public void incluir() throws Exception {

		VeiculoDao dao = DaoFactory.obterVeiculoDao();
		// completar com metodo de inclusao
	}

	/**
	 * Efetua alteracao dos dados do Veiculo
	 */
	public void alterar() {

		// EXERCÍCIO
		// FINALIZAR A ALTERAÇÃO
	}

	/**
	 * Efetua a exclusão do veiculo
	 */
	public void excluir() {
		// EXERCÍCIO
		// FINALIZAR A EXCLUSÃO
	}

	/**
	 * Metodo para pesquisa de veiculos baseada nos dados de filtro apresentados
	 * na tela de consulta
	 * 
	 * @return Lista de objetos Veiculo
	 * 
	 * @throws Exception
	 */
	public List<Veiculo> pesquisar() throws Exception {
		VeiculoDao dao = DaoFactory.obterVeiculoDao();
		return dao.pesquisarVeiculo(
				chassi, 
				placa, 
				modelo, 
				estadoGeral,
				regiaoEntrega);
	}

}
