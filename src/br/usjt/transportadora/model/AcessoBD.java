package br.usjt.transportadora.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela conexão com banco de dados Postgresql
 * @author rogerio
 *
 */
public class AcessoBD {
	
	private static long ultimoID = 0;
	
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------

	/**
	 * Obtem conexao com banco de dados
	 */
	public Connection obtemConexao() throws SQLException{
		// string postgres: jdbc:postgresql://localhost:5432/<nome banco>
		// string mysql   : jdbc:mysql://<host>:<porta>/<nome banco>
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", 	//banco de dados 
				"postgres", 									//usuario
				"postgres");									//senha
	}
	
	/**
	 * Obtem o proximo Identificador 
	 * 
	 * @return
	 * @throws Exception
	 */
	public long obterProximoIdentificador() throws Exception{
		// quando o sistema e carregado pela primeira vez, obtemos
		// o proximo ID com uma consulta ao banco de dados
		//
		if(ultimoID == 0) {
			ultimoID = obterUltimoIDdoBD();
		}
		// sempre incrementa o ID antes de retornar
		//
		ultimoID++;
		
		return ultimoID;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private int obterUltimoIDdoBD() throws Exception {

		String sql = "SELECT max(id) FROM veiculo";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = obtemConexao();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs != null && rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		
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
}
