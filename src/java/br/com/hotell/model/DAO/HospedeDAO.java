package br.com.hotell.model.DAO;

import br.com.hotell.conn.Conexao;
import br.com.hotell.model.OB.Hospede;
import br.com.hotell.model.OB.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HospedeDAO {

    public static boolean incluirhospede(Hospede h) {
        int pessoaID = 0;

        if ((pessoaID = PessoaDAO.incluirPessoa(h)) > 0) {
            Conexao.getInstancia();
            String sql = "INSERT INTO hospede (profissao,Pessoa_id) VALUES (?,?);";
            try {
                PreparedStatement ps = Conexao.getPreparedStatement(sql);
                ps.setString(1, h.getProfissao());
                ps.setInt(2, pessoaID);
                ps.executeUpdate();
                Conexao.fecharConexao();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    public static boolean alterarHospede(Hospede h) {
        try {
            PessoaDAO.alterarPessoa(h);

            Conexao.getInstancia();

            String sql = "UPDATE hospede SET profissao = ? where id = ? ; ";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);
            ps.setString(1, h.getProfissao());
            ps.setInt(2, h.getId());
            ps.executeUpdate();

            Conexao.fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Hospede consultarHospede(Hospede h) {
        if (h == null) {
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLL");
            return null;
        }
        Hospede f1 = new Hospede();
        Hospede aux = new Hospede();
        String sql = "SELECT * FROM hospede WHERE ";
        try {
            Pessoa p = new Pessoa();
            Conexao.getInstancia();
            PreparedStatement ps;
            if (h.getId() == 0) {
                sql += "Pessoa_id = ?;";
                //recupera os dados da tabela pessoa referentes ao hospede
                p = PessoaDAO.consultarPessoa(h.getRg());
                ps = Conexao.getPreparedStatement(sql);
                ps.setInt(1, p.getPessoaId());
            } else {
                sql += "id = ?;";
                ps = Conexao.getPreparedStatement(sql);
                ps.setInt(1, h.getId());
                //recupera os dados da tabela pessoa referentes ao hospede
                p = PessoaDAO.consultarPessoa(h.getId());
            }
            System.out.println(sql + h.getId() + " -- " + h.getRg());
            ResultSet rs = ps.executeQuery();

            rs.next();

            aux.setId(rs.getInt("id"));
            aux.setPessoaId(p.getPessoaId());
            aux.setProfissao(rs.getString("profissao"));
            aux.setPessoaId(rs.getInt("Pessoa_id"));
            Conexao.fecharConexao();

            aux.setNome(p.getNome());
            aux.setSobrenome(p.getSobrenome());
            aux.setCpf(p.getCpf());
            aux.setRg(p.getRg());
            aux.setSexo(p.getSexo());
            aux.setEndereco(p.getEndereco());
            aux.setTelefone(p.getTelefone());
            aux.setEmail(p.getEmail());
            f1 = aux;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("pppppppppppppppppppppppppp");
        System.out.println("pppppppppppppppppppppppppp   " + f1.getId());
        return f1;
    }

    public static boolean excluirHospede(Hospede h) {
        try {
            Conexao.getInstancia();

            String sql = "DELETE FROM hospede WHERE id = ?;";

            PreparedStatement ps = Conexao.getPreparedStatement(sql);

            ps.setInt(1, h.getId());
            ps.executeUpdate();
            Conexao.fecharConexao();

            //Exclui os dados do hospede da tabela pessoa
            PessoaDAO.exlcuirPessoa(h);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
