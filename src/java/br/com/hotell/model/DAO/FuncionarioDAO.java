package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Funcionario;
import br.com.hotell.model.OB.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    public static boolean incluirFuncionario(Funcionario f) {
        int pessoaID = 0;

        if ((pessoaID = PessoaDAO.incluirPessoa(f)) > 0) {
            Conexao.getInstancia();

            String sql = "INSERT INTO funcionario (salario,perfil,Pessoa_id) VALUES (?,?,?);";
            try {

                PreparedStatement ps = Conexao.getPreparedStatement(sql);
                ps.setFloat(1, f.getSalario());
                ps.setInt(2, f.getPerfil());
                ps.setInt(3, pessoaID);
                ps.executeUpdate();

                Conexao.fecharConexao();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;

    }

    public static boolean alterarFuncionario(Funcionario f) {
        Funcionario f1 = new Funcionario();
        try {
            if (PessoaDAO.alterarPessoa(f) == false) {
                return false;
            }

            Conexao.getInstancia();

            String sql = "UPDATE funcionario SET salario = ?, perfil = ? where id = ? ; ";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setFloat(1, f.getSalario());
            ps.setInt(2, f.getPerfil());
            ps.setInt(3, f.getId());
            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean exlcuirFuncionario(Funcionario f) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM funcionario WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, f.getId());
            ps.executeUpdate();
            Conexao.fecharConexao();

            //Exclui os dados do funcionario da tabela pessoa
            PessoaDAO.exlcuirPessoa(f);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Funcionario consultarFuncionario(Funcionario f) {
        Funcionario f1 = new Funcionario();
        Funcionario aux = new Funcionario();
        try {
            Pessoa p = new Pessoa();

            String sql = "SELECT * FROM funcionario WHERE id = ?;";

            Conexao.getInstancia();
            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setInt(1, f.getId());

            ResultSet rs = ps.executeQuery();

            rs.next();

            aux.setId(rs.getInt("id"));
            aux.setSalario(rs.getFloat("salario"));
            aux.setPerfil(rs.getInt("perfil"));
            aux.setPessoaId(rs.getInt("Pessoa_id"));
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
            Logger.getLogger(FuncionarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return f1;
    }
}
