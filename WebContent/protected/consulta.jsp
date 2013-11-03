<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<%@page import="br.usjt.transportadora.model.Veiculo"%>
<%@page import="java.util.ArrayList"%>
<html>

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

	<script language="JavaScript">
		function executar(form,operacao){
//			var resposta = confirm("Confirma operação? ");
//			alert(resposta);
//			if (resposta == true){
				form.operacao.value = operacao;
				form.submit();
//			}
		}
	</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Veículos</title>
	</head>

	<body>
	
	<form  action="fc" method="POST">
		<input type="hidden" name="operacao" value="consultar">
		
		<table>
			<tbody>
				<tr>
					<td><label>Chassi</label></td>
					<td><input type="text" maxlength="20" size="20" tabindex="0" name="chassi"></td>
				</tr>
				<tr>
					<td><label>Placa</label></td>
					<td><input type="text" maxlength="7" size="10" tabindex="1" name="placa"></td>
				</tr>
				<tr>
					<td><label>Modelo</label></td>
					<td><input type="text" maxlength="30" size="30" tabindex="2" name="modelo"></td>
				</tr>
				<tr>
					<td><label>Estado Geral</label></td>
					<td><input type="text" maxlength="10" size="10" tabindex="2" name="estadoGeral"></td>
				</tr>				
				<tr>
					<td><label>Região Entrega</label></td>
					<td><input type="text" maxlength="40" size="40" tabindex="2" name="regiaoEntrega"></td>
				</tr>				
				<tr>
					<td colspan="2">
						<INPUT TYPE="submit" NAME="pesquisar" Value="Pesquisar" >
						<button type="reset" name="limpar">Limpar</button>
					</td>
				</tr>
			</tbody>
		</table>

		<table class="tableDados">
		  <tr align="center" class="trHeader">
		    <td width="10px" class="tdDados">&nbsp;</td>
		    <td width="20px" class="tdDados">ID</td>
		    <td width="20px" class="tdDados">Chassi</td>
		    <td width="20px" class="tdDados">Placa</td>
		    <td width="50px" class="tdDados">Modelo</td>
		    <td width="50px" class="tdDados">Estado Geral</td>
		    <td width="70px" class="tdDados">Região Entrega</td>
		    
		  </tr>
		  <%
		    List retorno = (ArrayList)request.getSession().getAttribute("listaVeiculos");
		  	for(Iterator<Veiculo> it = retorno.iterator(); it.hasNext(); ) {
		  		Veiculo c = (Veiculo)it.next();
		  %>
			  <tr align="center">
			    <td width="10px" class="tdDados">
			    	<input type="radio" name="item" 
			    			checked="checked" 
			    			value="<%=c.getId()%>"></td>
			    <td width="20px" class="tdDados"><%=c.getId()%></td>
			    <td width="20px" class="tdDados"><%=c.getChassi()%></td>
			    <td width="20px" class="tdDados"><%=c.getPlaca()%></td>
			    <td width="50px" class="tdDados"><%=c.getModelo()%></td>
			    <td width="50px" class="tdDados"><%=c.getEstadoGeral()%></td>
			    <td width="70px" class="tdDados"><%=c.getRegiaoEntrega()%></td>
			  </tr>
		  <%
		  	}
		  %>  
			<tr>
	   		<td colspan="13">
	   			<INPUT TYPE="button" NAME="incluir" Value="Incluir" 
	   				onclick="executar(this.form,'incluir')">
				<INPUT TYPE="button" NAME="alterar" Value="Alterar" 
					onclick="executar(this.form,'alterar')">
				<INPUT TYPE="button" NAME="detalhar" Value="Detalhar" 
					onclick="executar(this.form,'detalhar')">
			</td>
			</tr>		    	  
		</table>
	</form>
	</body>
</html>
