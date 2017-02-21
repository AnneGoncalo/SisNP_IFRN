<%-- 
    Document   : viewProjetos
    Created on : 21/02/2017, 17:16:52
    Author     : anne
--%>

<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Projetos</h1>
        <hr>
        <ol>
            <% for (Projeto p : projetos) {%>
            <li><a href="projeto?idProjeto=<%= p.getId()%>"><%= p.getTitulo()%></a></li>
            <% }%>
        </ol>
    </body>
</html>
