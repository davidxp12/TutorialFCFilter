package br.usjt.transportadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.transportadora.model.AcessoBD;
import br.usjt.transportadora.model.Veiculo;

public class VeiculoPostgresDaoImpl implements VeiculoDao{

	public List<Veiculo> pesquisarVeiculo(String chassi, String placa,
			String modelo, String estadoGeral, String regiaoEntrega) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Veiculo> resultado = new ArrayList<Veiculo>();
		
		try {
			String sql = "select * from veiculo ";
			sql = sql + this.montaClausulawWhere(chassi,placa,modelo,estadoGeral,regiaoEntrega);
			AcessoBD bd = new AcessoBD();
			con = bd.obtemConexao();
			stmt = con.prepareStatement(sql);
	
			int indice = 1;
			if (chassi != null)
				stmt.setString(indice++, "%" + chassi + "%");
			if (placa != null)
				stmt.setString(indice++, "%" + placa + "%");
			if (modelo != null)
				stmt.setString(indice++, "%" + modelo + "%");
			if (estadoGeral != null)
				stmt.setString(indice++, "%" + estadoGeral + "%");
			if (regiaoEntrega != null)
				stmt.setString(indice++, "%" + regiaoEntrega + "%");
	
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Veiculo v = new Veiculo();
				v.setId(rs.getLong("id"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setCategoria(rs.getString("categoria"));
				v.setAno(rs.getInt("ano"));
				v.setPlaca(rs.getString("placa"));
				v.setChassi(rs.getString("chassi"));
				v.setEstadoGeral(rs.getString("estadoGeral"));
				v.setRegiaoEntrega(rs.getString("regiaoEntrega"));
				v.setTipoMercadoria(rs.getString("tipoMercadoria"));
				v.setQuantidadeMaxima(rs.getInt("quantidadeMaxima"));
				resultado.add(v);
			}
	
			return resultado;
		} catch(SQLException sq) {
			sq.printStackTrace();
			return new ArrayList<Veiculo>();
			
		} finally {
			// IMPORTANTE UTILIZACAO DO FINALLY PARA GARANTIR O FECHAMENTO
			// DA CONEXAO COM O BANCO DE DADOS.
	
			// fecha o resultset
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha o statement
			//
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					//
				}
			}
			// fecha a conexao
			//
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					//
				}
			}
		}		
	}
	
	private String montaClausulawWhere(String chassi, String placa,
			String modelo, String estadoGeral, String regiaoEntrega) {
		String where = "";
		if (chassi != null || placa != null || modelo != null 
				|| estadoGeral != null || regiaoEntrega != null)
			where = " where ";

		if (chassi != null) {
			where = where + "chassi like  ? and ";
		}
		if (placa != null) {
			where = where + "placa like ? and ";
		}
		if (modelo != null) {
			where = where + "modelo like ? and ";
		}
		if (estadoGeral != null) {
			where = where + "estadoGeral like ? and ";
		}
		if (regiaoEntrega != null) {
			where = where + "regiaoEntrega like ? ";
		}

		if (where.endsWith("and ")) {
			return where.substring(0, where.length() - 4);
		} else {
			return where;
		}
	}	
}
