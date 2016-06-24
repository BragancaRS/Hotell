package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Diaria;
import br.com.hotell.model.OB.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

            String sql = "SELECT * FROM quarto WHERE id = ?;";

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

    public static ArrayList<Quarto> listarQuartos() {
        ArrayList<Quarto> quartos = new ArrayList();
        try {

            String sql = "SELECT * FROM quarto;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Quarto p1 = new Quarto();
                p1.setId(rs.getInt("id"));
                p1.setNumero(rs.getString("numero"));
                p1.setTipo(rs.getInt("tipo_quarto_id"));
                quartos.add(p1);
            }

            Conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quartos;
    }

    public static ArrayList<Quarto> listarQuartosDisponiveis() {
        ArrayList<Quarto> quartos = new ArrayList();
        ArrayList<Diaria> diarias = new ArrayList<>();
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();

        quartos = QuartoDAO.listarQuartos();
        diarias = DiariaDAO.listarDiarias();
        boolean quartoDisponivel = true;
        for (int i = 0; i < quartos.size(); i++) {
            for (int j = 0; j < diarias.size(); j++) {
                if (quartos.get(i).getId() == diarias.get(j).getQuarto().getId()) {
                    if (diarias.get(j).getDataFeachamento() == null) {
                        quartoDisponivel = false;

                    }
                }
            }
            if (quartoDisponivel == true) {
                quartosDisponiveis.add(quartos.get(i));

            }
            quartoDisponivel = true;
        }

        return quartosDisponiveis;
    }

}
