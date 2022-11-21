package ModeloDAO;

import Config.Conexao;
import Interfaces.CRUD;
import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements CRUD {

    Conexao cn = new Conexao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Pessoa a = new Pessoa();

    public PessoaDAO() {
        super();
        con = this.cn.getConnection();
    }

    @Override
    public List listar() {
        cn.Conexao();
        ArrayList<Pessoa> list = new ArrayList<>();
        String sql = "select * from pessoa";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa a = new Pessoa();
                a.setId(rs.getInt("Id"));
                a.setNome(rs.getString("Nome"));
                a.setEndereco(rs.getString("Endereco"));
                a.setCidade(rs.getString("Cidade"));
                a.setEstado(rs.getString("Estado"));
                a.setEmail(rs.getString("Email"));
                list.add(a);
            }
        } catch (SQLException e) {
        } finally {
            cn.Desconectar(con);
        }
        return list;
    }

    @Override
    public Pessoa list(int id) {
        cn.Conexao();
        String sql = "select * from pessoa where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("Id"));
                a.setNome(rs.getString("Nome"));
                a.setEndereco(rs.getString("Endereco"));
                a.setCidade(rs.getString("Cidade"));
                a.setEstado(rs.getString("Estado"));
                a.setEmail(rs.getString("Email"));
            }
        } catch (SQLException e) {
        } finally {
            cn.Desconectar(con);
        }
        return a;
    }

    @Override
    public boolean add(Pessoa a) {
        cn.Conexao();
        String sql = "insert into Pessoa(Nome,Endereco,Cidade,Estado,Email) values('"
                + a.getNome() + "','"
                + a.getEndereco() + "','"
                + a.getCidade() + "','"
                + a.getEstado() + "','"
                + a.getEmail() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            cn.Desconectar(con);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        cn.Conexao();
        String sql = "delete from pessoa where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            cn.Desconectar(con);
        }
        return false;
    }

    @Override
    public boolean edit(Pessoa a) {
        cn.Conexao();
        String sql = "update pessoa set "
                + "nome='" + a.getNome()
                + "',endereco = '" + a.getEndereco()
                + "',cidade = '" + a.getCidade()
                + "',estado = '" + a.getEstado()
                + "',email = '" + a.getEmail()
                + "'where id=" + a.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {            
            cn.Desconectar(con);
        }
        return false;
    }

}
