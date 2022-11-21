<%-- 
    Document   : add
    Created on : 20 de nov de 2022, 22:36:13
    Author     : Thiago
--%>

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
                <h1>Adicionar - EducaCiencia</h1>
                <form action="Controlador">
                    <!--                 Email: <br>
                                        <input class="form-control" type="text" name="txtEmail"><br>-->
                    Nome: <br>
                    <input class="form-control" type="text" name="txtNome"><br>
                    Endereco: <br>
                    <input class="form-control" type="text" name="txtEndereco"><br>
                    Cidade: <br>
                    <input class="form-control" type="text" name="txtCidade"><br>                    
                    Selecione o estado: <br>
                    <select class="form-select" id="estado" name="estado">                        
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                        <option value="EX">Estrangeiro</option>
                    </select>
                    <br>
<!--                    <input class="form-control" type="text" name="txtEstado"><br>-->
                    Email: <br>
                    <input class="form-control" type="text" name="txtEmail"><br>               

                    <input class="btn btn-primary" type="submit" name="accion" value="Adicionar">
                    <a href="Controlador?accion=listar">Voltar para Lista</a>
                </form>
            </div>

        </div>
    </body>
</html>
