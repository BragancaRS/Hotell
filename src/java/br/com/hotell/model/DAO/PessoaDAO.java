package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class PessoaDAO {

    public static int incluirPessoa(Pessoa p) {
        int pessoaID = 0;
        Conexao.getInstancia();
        String sql = "INSERT INTO Pessoa (nome,sobrenome,data_cadastro,"
                + "cpf,rg,sexo,endereco,telefone,email) VALUES(?,?,?,?,?,?,?,?);";
        try {

            PreparedStatement pStatement = Conexao.getPreparedStatement(sql);

            pStatement.setString(1, p.getNome());
            pStatement.setString(2, p.getSobrenome());
            pStatement.setString(3, "hoje");
            pStatement.setString(4, p.getCpf());
            pStatement.setString(5, p.getRg());
            pStatement.setString(6, p.getSexo());
            pStatement.setString(7, p.getEndereco());
            pStatement.setString(8, p.getTelefone());
            pStatement.setString(9, p.getEmail());

            pStatement.executeUpdate();
            ResultSet rs = pStatement.getGeneratedKeys();
            rs.next();
            pessoaID = rs.getInt(1);
            Conexao.fecharConexao();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pessoaID;
    }

    public static boolean alterarPessoa(Pessoa p) {

        try {
            Conexao.getInstancia();

            String sql = "UPDATE Pessoa SET nome = ?, sobrenome = ?,"
                    + "cpf = ?, rg = ?, sexo = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setString(1, p.getNome());
            ps.setString(2, p.getSobrenome());
            ps.setString(3, p.getCpf());
            ps.setString(4, p.getRg());
            ps.setString(5, p.getSexo());
            ps.setString(6, p.getEndereco());
            ps.setString(7, p.getTelefone());
            ps.setString(8, p.getEmail());
            ps.setInt(9, p.getPessoaId());
            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean exlcuirPessoa(Pessoa p) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM Pessoa WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, p.getPessoaId());
            ps.executeUpdate();
            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Pessoa consultarPessoa(int idPessoa) {
        Pessoa p = new Pessoa();
        try {

            String sql = "SELECT * FROM Pessoa WHERE id = ?;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(1, idPessoa);

            ResultSet rs = ps.executeQuery();

            rs.next();
            Pessoa p1 = new Pessoa();
            p1.setNome(rs.getString("nome"));
            p1.setSobrenome(rs.getString("sobrenome"));
            p1.setCpf(rs.getString("cpf"));
            p1.setRg(rs.getString("rg"));
            p1.setSexo(rs.getString("sexo"));
            p1.setEndereco(rs.getString("endereco"));
            p1.setTelefone(rs.getString("telefone"));
            p1.setEmail(rs.getString("email"));

            Conexao.fecharConexao();
            p = p1;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

}
