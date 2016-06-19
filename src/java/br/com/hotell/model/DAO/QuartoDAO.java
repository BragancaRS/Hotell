package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuartoDAO {

    public static boolean incluirQuarto(Quarto q) {
        try {
            Conexao.getInstancia();
            String sql = "INSERT INTO quarto (numero,tipo_quarto_id) VALUES(?,?);";
            PreparedStatement pStatement = Conexao.getPreparedStatement(sql);
            pStatement.setInt(1, q.getTipo());
            pStatement.setString(2, q.getNumero());

            pStatement.executeUpdate();
            ResultSet rs = pStatement.getGeneratedKeys();
            rs.next();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean alterarQuarto(Quarto q) {
        try {
            Conexao.getInstancia();

            String sql = "UPDATE quarto SET numero = ?, tipo_quarto_id = ? WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setString(1, q.getNumero());

            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean exlcuirQuarto(Quarto q) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM quarto WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, q.getId());
            ps.executeUpdate();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Quarto consultarQuarto(String numero) {
        Quarto p = new Quarto();
        try {

            String sql = "SELECT * FROM Quarto WHERE numero = ?;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setString(1, numero);

            ResultSet rs = ps.executeQuery();

            rs.next();
            Quarto p1 = new Quarto();
            p1.setId(rs.getInt("id"));
            p1.setNumero(rs.getString("numero"));
            p1.setTipo(rs.getInt("tipo_quarto_id"));

            Conexao.fecharConexao();
            p = p1;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

}
