package br.com.hotell.control;

import br.com.hotell.model.DAO.FuncionarioDAO;
import br.com.hotell.model.OB.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author raphael
 */
@ManagedBean
@javax.faces.bean.RequestScoped
public class FuncionarioController {

    Funcionario f = new Funcionario();

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }

    public String cadastrar() {
        if (FuncionarioDAO.incluirFuncionario(f)) {
            return "sucessoCadastrar";
        }
        return "fracassoCadastrar";
    }

    public String consultar() {
        Funcionario aux = new Funcionario();

        aux = FuncionarioDAO.consultarFuncionario(f);

        if (aux.getPessoaId() > 0) {
            f = aux;
            
            return "sucessoConsultar " + aux.getPessoaId() + " " + f.getNome();
        }
        return "fracassoConsultar";
    }

    public String alterar() {
        if (FuncionarioDAO.alterarFuncionario(f) && f.getId() > 0) {
            return "sucessoAlterar";
        }
        return "fracassoAlterar";
    }
    
    public String excluir() {
        if (FuncionarioDAO.exlcuirFuncionario(f)) {
            return "sucessoExcluir";
        }
        return "fracassoExcluir";
    }

}
