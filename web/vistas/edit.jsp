<%-- 
    Document   : edit
    Created on : 21 de nov de 2022, 10:12:51
    Author     : Thiago
--%>

<%@page import="Modelo.Pessoa"%>
<%@page import="ModeloDAO.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP EducaCiencia</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    PessoaDAO dao = new PessoaDAO();
                    int id = Integer.parseInt((String) request.getAttribute("id-a"));
                    Pessoa a = (Pessoa)dao.list(id);
                %>
                <h1>Modificar - EducaCiencia</h1>
                <form action="Controlador">                    
                    Nome: <br>                    
                    <input class="form-control" type="text" name="txtNome" value="<%= a.getNome()%>"><br>
                    Endereco: <br>
                    <input class="form-control" type="text" name="txtEndereco" value="<%= a.getEndereco()%>"><br>
                    Cidade: <br>
                    <input class="form-control" type="text" name="txtCidade"  value="<%= a.getCidade()%>"><br>                    
                    Estado: <br>                    
                    <input class="form-control" type="text" name="txtEstado" value="<%= a.getEstado()%>"><br>
                    Email: <br>
                    <input class="form-control" type="text" name="txtEmail" value="<%= a.getEmail()%>"><br>               
                    
                    <input  type="hidden" name="txtId" value="<%= a.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Atualizar"> 
                    <a href="Controlador?accion=listar">Voltar</a>
                </form>
            </div>

        </div>
    </body>
</html>
