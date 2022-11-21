<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Pessoa"%>
<%@page import="ModeloDAO.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP EducaCiencia</title>
    </head>
    <body>
        <div class="container">
            <h1>EducaCiencia</h1>
            <a class="btn btn-primary" href="Controlador?accion=add">Adicionar</a>
            <a class="btn btn-primary" href="index.jsp">Voltar</a>            
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>                       
                        <th class="text-center">NOME</th>
                        <th class="text-center">ENDERECO</th>
                        <th class="text-center">CIDADE</th>
                        <th class="text-center">ESTADO</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">AÇÃO</th>
                    </tr>
                </thead>
                <%
                    PessoaDAO dao = new PessoaDAO();
                    List<Pessoa> list = dao.listar();
                    Iterator<Pessoa> iter = list.iterator();
                    Pessoa a = null;
                    while (iter.hasNext()) {
                        a = iter.next();
                %>
                <tbody>
                    <tr class="table-dark">
                        <td class="text-center"><%= a.getId()%></td>
                        <td><%= a.getNome()%></td>
                        <td class="text-center"><%= a.getEndereco()%></td>
                        <td class="text-center"><%= a.getCidade()%></td>
                        <td class="text-center"><%= a.getEstado()%></td>
                        <td class="text-center"><%= a.getEmail()%></td>
                        <td class="text-center">
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= a.getId()%>">Remover</a>
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= a.getId()%>">Editar</a>                            
                        </td>                        
                    </tr>
                    <%}%>
                </tbody>
            </table>


    </body>
</html>
