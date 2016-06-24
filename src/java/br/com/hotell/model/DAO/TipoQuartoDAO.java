package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.TipoDeQuarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TipoQuartoDAO {

    public static boolean incluirTipoDeQuarto(TipoDeQuarto q) {
        try {
            Conexao.getInstancia();
            String sql = "INSERT INTO tipo_quarto (descricao,valor_base) VALUES(?,?);";
            PreparedStatement pStatement = Conexao.getPreparedStatement(sql);
            pStatement.setString(1, q.getDescricao());
            pStatement.setFloat(2, q.getValorBase());

            pStatement.executeUpdate();
            ResultSet rs = pStatement.getGeneratedKeys();
            rs.next();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TipoQuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean alterarTipoDeQuarto(TipoDeQuarto q) {
        try {
            Conexao.getInstancia();

            String sql = "UPDATE tipo_quarto SET descricao = ?, valor_base = ? WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setString(1, q.getDescricao());
            ps.setFloat(2, q.getValorBase());

            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean exlcuirTipoDeQuarto(int id) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM tipo_quarto WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static TipoDeQuarto consultarTipoDeQuarto(TipoDeQuarto q) {
        TipoDeQuarto p = new TipoDeQuarto();
        try {

            String sql = "SELECT * FROM tipo_quarto WHERE id = ?;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(1, q.getId());

            ResultSet rs = ps.executeQuery();

            rs.next();
            TipoDeQuarto p1 = new TipoDeQuarto();
            p1.setId(rs.getInt("id"));
            p1.setDescricao(rs.getString("descricao"));
            p1.setNome(rs.getString("nome"));
            p1.setValorBase(rs.getFloat("valor_base"));

            Conexao.fecharConexao();
            p = p1;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    public static ArrayList<TipoDeQuarto> listarTipoDeQuarto() {
        ArrayList<TipoDeQuarto> tdqs = new ArrayList<>();
        try {

            String sql = "SELECT * FROM tipo_quarto;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                TipoDeQuarto p1 = new TipoDeQuarto();
                p1.setId(rs.getInt("id"));
                p1.setDescricao(rs.getString("descricao"));
                p1.setNome(rs.getString("nome"));
                p1.setValorBase(rs.getFloat("valor_base"));
                tdqs.add(p1);
            }

            Conexao.fecharConexao();

        } catch (SQLException ex) {
            Logger.getLogger(TipoDeQuarto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return tdqs;

    }

}
