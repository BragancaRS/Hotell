package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Diaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class DiariaDAO {

    public static boolean incluirDiaria(Diaria d) {
        try {
            Conexao.getInstancia();
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String sql = "INSERT INTO diaria (data,valor,quarto_id,funcionario_id,hospede_id) VALUES(?,?,?,?,?);";
            PreparedStatement pStatement = Conexao.getPreparedStatement(sql);
            pStatement.setDate(1, startDate);
            pStatement.setString(2, String.valueOf(d.getValor()));
            pStatement.setInt(3, d.getQuarto());
            pStatement.setInt(4, d.getFuncionario().getId());
            pStatement.setInt(5, d.getHospede().getId());

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

    public static boolean alterarDiaria(Diaria d) {
        return false;
    }

    public static boolean excluirDiaria(Diaria d) {
        return false;
    }

    public static Diaria consultarDiaria(Diaria d) {
        return new Diaria();
    }

}
