package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Funcionario;
import br.com.hotell.model.OB.Pessoa;
import br.com.hotell.model.OB.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raphael
 */
public class UsuarioDAO {

    public static boolean incluirUsuario(Usuario u) {
        int pessoaID = 0;

        try {

            if ((pessoaID = PessoaDAO.incluirPessoa(u)) > 0) {

                Conexao.getInstancia();

                String sql = "INSERT INTO funcionario (salario,perfil,Pessoa_id) VALUES (?,?,?);";
                try {

                    PreparedStatement ps = Conexao.getPreparedStatement(sql);
                    ps.setFloat(1, u.getSalario());
                    ps.setInt(2, u.getPerfil());
                    ps.setInt(3, pessoaID);
                    ps.executeUpdate();

                    Conexao.fecharConexao();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            return false;
        }

    }

    public static boolean alterarUsuario(Usuario u) {
        Usuario f1 = new Usuario();
        try {
            PessoaDAO.alterarPessoa(u);

            Conexao.getInstancia();

            String sql = "UPDATE funcionario SET salario = ?, perfil = ? where id = ? ; ";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setFloat(1, u.getSalario());
            ps.setInt(2, u.getPerfil());
            ps.setInt(3, u.getId());
            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean exlcuirUsuario(Usuario u) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM funcionario WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, u.getId());
            ps.executeUpdate();
            Conexao.fecharConexao();

            //Exclui os dados do funcionario da tabela pessoa
            PessoaDAO.exlcuirPessoa(u);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Usuario consultarUsuario(Usuario u) {
        Usuario f1 = new Usuario();
        Usuario aux = new Usuario();
        try {
            Pessoa p = new Pessoa();

            String sql = "SELECT * FROM funcionario WHERE id = ?;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(1, u.getId());

            ResultSet rs = ps.executeQuery();

            rs.next();

            aux.setId(rs.getInt("id"));
            aux.setSalario(rs.getFloat("salario"));
            aux.setPerfil(rs.getInt("perfil"));
            aux.setPessoaId(rs.getInt("Pessoa_id"));
            aux.setLogin(u.getLogin());
            aux.setSenha(u.getSenha());
            Conexao.fecharConexao();

            //recupera os dados da tabela pessoa referentes ao funcionario
            p = PessoaDAO.consultarPessoa(aux.getPessoaId());

            aux.setNome(p.getNome());
            aux.setSobrenome(p.getSobrenome());
            aux.setCpf(p.getCpf());
            aux.setRg(p.getRg());
            aux.setSexo(p.getSexo());
            aux.setEndereco(p.getEndereco());
            aux.setTelefone(p.getTelefone());
            f1 = aux;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }

    public static boolean autenticar(Usuario u) {
        try {
            Conexao.getInstancia();
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? ;";
            PreparedStatement preparedStatement = Conexao.getPreparedStatement(sql);
            preparedStatement.setString(1, u.getLogin());
            preparedStatement.setString(2, u.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                u.setId(resultSet.getInt("id"));
                u.setFuncionarioID(resultSet.getInt("funcionario_id"));
                Funcionario f = FuncionarioDAO.consultarFuncionario(u);
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
