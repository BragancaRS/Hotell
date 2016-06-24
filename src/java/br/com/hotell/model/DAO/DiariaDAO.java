package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Diaria;
import br.com.hotell.model.OB.Funcionario;
import br.com.hotell.model.OB.Hospede;
import br.com.hotell.model.OB.Quarto;
import br.com.hotell.model.OB.TipoDeQuarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

            String sql = "INSERT INTO diaria (data_entrada,quarto_id,funcionario_id,hospede_id) VALUES(?,?,?,?);";
            PreparedStatement pStatement = Conexao.getPreparedStatement(sql);
            pStatement.setDate(1, startDate);
            pStatement.setInt(2, d.getQuarto().getId());
            pStatement.setInt(3, d.getFuncionario().getId());
            pStatement.setInt(4, d.getHospede().getId());

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

    public static boolean alterarDiaria(Diaria d, int tipo) {
        String sql = "UPDATE diaria ";

        try {

            Conexao.getInstancia();
            PreparedStatement ps;
            switch (tipo) {
                case 1:
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                    sql += "SET data_fechamento = ? WHERE id = ?;";
                    ps = Conexao.getPreparedStatement(sql);
                    ps.setDate(1, startDate);
                    ps.setInt(1, d.getId());
                    ps.executeUpdate();
                    break;
                case 2:
                    sql += "SET  quarto_id = ? WHERE id = ?;";
                    ps = Conexao.getPreparedStatement(sql);
                    ps.setInt(1, d.getQuarto().getId());
                    ps.setInt(2, d.getId());
                    ps.executeUpdate();
                    break;

            }

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean excluirDiaria(Diaria d) {
        return false;
    }

    public static Diaria consultarDiaria(Diaria d) {
        return new Diaria();
    }

    public static ArrayList<Diaria> listarDiarias() {
        ArrayList<Diaria> diarias = new ArrayList<>();
        try {

            String sql = "SELECT * FROM diaria;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Diaria d = new Diaria();
                TipoDeQuarto tdq = new TipoDeQuarto();
                Hospede h = new Hospede();
                Funcionario f = new Funcionario();
                Quarto q = new Quarto();
                d.setDataEntrada(rs.getString("data_entrada"));
                d.setId(rs.getInt("id"));
                d.setDataFeachamento(rs.getString("data_fechamento"));

                h.setId(Integer.valueOf(rs.getString("hospede_id")));
                h = HospedeDAO.consultarHospede(h);
                System.out.println(h.getNome() + "' -- " + h.getId());
                f.setId(Integer.valueOf(rs.getString("funcionario_id")));
                f = FuncionarioDAO.consultarFuncionario(f);

                q.setId(Integer.valueOf(rs.getString("quarto_id")));
                q = QuartoDAO.consultarQuarto(rs.getString("quarto_id"));

                tdq.setId(q.getTipo());
                tdq = TipoQuartoDAO.consultarTipoDeQuarto(tdq);
                System.out.println(tdq.getValorBase());
                d.setValor(tdq.getValorBase());
                d.setFuncionario(f);
                d.setHospede(h);
                d.setQuarto(q);
                diarias.add(d);
            }

            Conexao.fecharConexao();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diarias;

    }
}
