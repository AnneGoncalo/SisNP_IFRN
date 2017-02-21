<%-- 
    Document   : cadastrarProjeto
    Created on : 21/02/2017, 15:50:21
    Author     : anne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Projeto</h1>
        <form method="POST" action="CadastrarProjeto">
            Titulo: <input type="text" name="titulo" />
            Descrição: <input type="text" name="descricao"/>
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
