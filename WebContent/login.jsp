<%-- 
    Document   : index
    Created on : Sep 2, 2013, 4:11:07 PM
    Author     : rogerio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação</title>
    </head>
    <body>
        <form method="post" action="login">
            <h1>Informe seu nome de usuário e senha!!</h1>
            <p><b>Usuário:</b><input type="text" name="j_username"/></p>
            <p><b>Senha:</b><input type="password" name="j_password"/></p>
            <p><input type="submit" name="go"/></p>
        </form>
    </body>
</html>
