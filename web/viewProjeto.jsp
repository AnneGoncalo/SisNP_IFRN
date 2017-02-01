<%@page import="sisnp.ifrn.br.dominio.Atividade"%>
<%@page import="sisnp.ifrn.br.dominio.Noticia"%>
<%@page import="sisnp.ifrn.br.dominio.Meta"%>
<%@page import="sisnp.ifrn.br.dominio.Usuario"%>
<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Projeto projeto = (Projeto) request.getAttribute("projeto");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto</title>
    </head>
    <body>
        <h1> <%= projeto.getTitulo()%></h1>
        <hr/>
        <h3>Descrição</h3>
        <p><%= projeto.getDescricao()%></p>

        <h3>Equipe</h3>
        <ul>
            <%
                for (Usuario u : projeto.getEquipe()) {
            %>
            <li>
                <%= u.getNome()%>
            </li>
            <%
                }
            %>
        </ul>

        <h3>Metas</h3>
        <ul>
            <%
                for (Meta m : projeto.getMetas()) {
            %>
            <li>
                <%= m.getTitulo()%>
                <ol>
                    <% for (Atividade a : m.getAtividades()) { %>
                    <li> <%= a.getDescricao() %> </li>
                    <p>Inicio: <%= a.getInicio() %> </p>
                    <p>Duração estimada: <%= a.getDuracaoEstimada() %> </p>
                    <p>Situação: <%= a.getEstado() %> </p>
                    <p>Autor: <%= a.getAutor().getNome() %> </p>
                    <p>Responsavel: <%= a.getResponsavel().getNome() %> </p>
                    <% } %>
                </ol>
            </li>
            <%
                }
            %>
        </ul>

        <h3>Notícias</h3>
        <ul>
            <%
                for (Noticia n : projeto.getNoticias()) {
            %>
            <li> <%= n.getTitulo()%> </li>
            <p> Por: <%= n.getAutor().getNome() %> </p>
            <p> Em: <%= n.getData() %> </p>
            <p> <%= n.getTexto() %> </p>
            <%
                }
            %>
        </ul>
        
    </body>
</html>
