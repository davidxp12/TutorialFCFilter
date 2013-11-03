<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%@page import="br.usjt.transportadora.model.Veiculo"%><html>
	<style type="text/css">
	label {
		font-family: arial, helvetica, sans-serif;
		font-size: 13;
	}
	input {
		font-style: normal;
		font-family: sans-serif;
		border-style: solid;
	}
	.tableDados {
		table-layout: auto;
		border-collapse: collapse;
		border-color: #0000FF;
		border-width: 0;
		border-style: solid;
		font-size: 12;
		font-style: normal;
		font-family: sans-serif;
		width: 800px;	
	}
	.tdDados {
		border-color: #0000FF;
		border-width: 1;
		border-style: solid;
		empty-cells: show;	
	}
	.trHeader{
		border-color: #0000FF;
		background-color: #FFC0CB;
		border-width: 1;
		border-style: solid;
	}
	button {
		border-style: groove;
		border-color: #8B6914;
		font-style: normal;
	}
	</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Veículos</title>
</head>
<body>
	<jsp:useBean id="veiculoss" class="br.usjt.transportadora.model.Veiculo" scope="session"/>

	<form action="fc" method="POST">
		<input type="hidden" name="operacao" value="salvarAlteracao">
		<table>
			<tbody>
				<tr>
					<td colspan="2"><label><b>Alteração</b></label></td>
				</tr>
			
				<tr>
					<td><label>Id</label></td>
					<td><input readonly="true" type="text" maxlength="5" size="5" tabindex="1" name="id"
						value="<jsp:getProperty name='veiculoss' property='id' />"></td>
				</tr>			
				<tr>
					<td><label>Chassi</label></td>
					<td>
					 <input readonly="true" type="text" maxlength="20" size="20" tabindex="2" name="chassi" 
					 	value="<jsp:getProperty name='veiculoss' property='chassi' />"></td>
				</tr>
				<tr>
					<td><label>Placa</label></td>
					<td><input readonly="true" type="text" maxlength="7" size="10" tabindex="3" name="placa"
						value="<jsp:getProperty name='veiculoss' property='placa' />"></td>
				</tr>
				<tr>
					<td><label>Marca</label></td>
					<td><input readonly="true" type="text" maxlength="40" size="40" tabindex="4" name="marca"
						value="<jsp:getProperty name='veiculoss' property='marca' />"></td>
				</tr>
				<tr>
					<td><label>Modelo</label></td>
					<td><input readonly="true" type="text" maxlength="30" size="30" tabindex="5" name="modelo"
						value="<jsp:getProperty name='veiculoss' property='modelo' />"></td>
				</tr>
				<tr>
					<td><label>Ano</label></td>
					<td>
						<input readonly="true" type="text" maxlength="4" size="4" tabindex="6" name="ano"
						value="<jsp:getProperty name='veiculoss' property='ano' />">
					</td>
				</tr>				
				<tr>
					<td><label>Categoria</label></td>
					<td><input readonly="true" type="text" maxlength="15" size="15" tabindex="6" name="categoria"
						value="<jsp:getProperty name='veiculoss' property='categoria' />"></td>
				</tr>				
				<tr>
					<td><label>Estado Geral</label></td>
					<td>
						<select name="estadoGeral">
							<% 
								if("NOVO".equals(veiculoss.getEstadoGeral())){ 
							%>
									<option selected="selected" id="NOVO">NOVO</option>
							<%  } else { %>
									<option id="NOVO">NOVO</option>
							<%  } %>
							<% 
								if("BOM".equals(veiculoss.getEstadoGeral())){ 
							%>
									<option selected="selected" id="BOM">BOM</option>
							<%  } else { %>
									<option id="BOM">BOM</option>
							<%  } %>
							<% 
								if("REGULAR".equals(veiculoss.getEstadoGeral())){ 
							%>
									<option selected="selected" id="REGULAR">REGULAR</option>
							<%  } else { %>
									<option id="REGULAR">REGULAR</option>
							<%  } %>
							<% 
								if("RUIM".equals(veiculoss.getEstadoGeral())){ 
							%>
									<option selected="selected" id="RUIM">RUIM</option>
							<%  } else { %>
									<option id="RUIM">RUIM</option>
							<%  } %>
						</select>
					</td>
				</tr>				
				<tr>
					<td><label>Tipo Mercadoria</label></td>
					<td><input type="text" maxlength="20" size="20" tabindex="10" name="tipoMercadoria"
						value="<jsp:getProperty name='veiculoss' property='tipoMercadoria'/>"></td>
				</tr>
				<tr>
					<td><label>Quantidade Máxima</label></td>
					<td><input type="text" maxlength="10" size="10" tabindex="11" name="quantidadeMaxima"
						value="<jsp:getProperty name='veiculoss' property='quantidadeMaxima'/>"></td>
				</tr>				
				<tr>
					<td><label>Região Entrega</label></td>
					<td><input type="text" maxlength="40" size="40" tabindex="12" name="regiaoEntrega"
						value="<jsp:getProperty name='veiculoss' property='regiaoEntrega'/>"></td>
				</tr>				
				<tr>
					<td colspan="2">
						<button type="submit" name="salvar" tabindex="13">Salvar</button>
						<button type="reset" name="limpar" tabindex="14">Limpar</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>