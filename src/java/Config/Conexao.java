package Config;

import java.sql.*;

public class Conexao {

    Connection con;

    private static final String DATABASE = "EducaJSP";
    private static final String PORT = "3306";
    private static final String HOST = "jdbc:mysql://localhost:" + "/" + DATABASE;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SSL = "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String URL = "jdbc:mysql://localhost:3306" + "/" + DATABASE + SSL;
    private static final String USR = "root";
    private static final String PWD = "";

    public void Conexao() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Banco de Dados => " + DATABASE);
            System.out.println("Host => " + HOST);
            System.out.println("Porta => " + PORT);
            System.out.println("Driver => " + DRIVER);
            System.out.println("URL  => " + URL);
            System.out.println("SSL  => " + SSL);
            System.out.println("Usuario => " + USR);
            System.out.println("Senha => " + PWD);
        } catch (Exception e) {
            System.err.println("Error = " + e);
            System.out.println("Erro de conexao com Banco de Dados - verificar se está ativo - Mysql ! " + e);
        }
    }

    public static void Desconectar(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
       
}
