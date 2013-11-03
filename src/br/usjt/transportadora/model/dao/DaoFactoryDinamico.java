package br.usjt.transportadora.model.dao;

import java.util.Properties;

/**
 * Exemplo de implementacao de Factory com carga dinamica de classes.
 * 
 * BENEFICIO: Remove totalmente a dependencia entre Factory e Implementacoes de
 * DAO. Observem que nao existe import de classes
 * 
 * @author Rogerio A. Rondini
 * 
 */
public class DaoFactoryDinamico {

	private static Properties p = null;

	private static String C_CHAVE_VEICULO = "dao.veiculo.impl";

	public static VeiculoDao obterVeiculoDao(){

		return (VeiculoDao) obtemDao(C_CHAVE_VEICULO);
	}


	private static Object obtemDao(String chave) {
		try {
			// carrega arquivo de configuracao de DAOs caso ainda nao tenha sido
			// carregado
			//
			if (p == null) {
				p = new Properties();
				
				p.load(DaoFactoryDinamico.class.getResourceAsStream("dao.properties"));
			}

			// obtem a configuracao
			//
			String daoImpl = p.getProperty(chave);

			// carrega DAO dinamicamente
			//
			Class c = DaoFactoryDinamico.class.getClassLoader().loadClass(daoImpl);
			return c.newInstance();

		} catch (Exception e) {
			// lancando RuntimeException para nao precisar de tratamento
			// Nesse momento, ainda nao foi apresentado em sala de aula o modelo
			// de tratamento de erros do java.

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
