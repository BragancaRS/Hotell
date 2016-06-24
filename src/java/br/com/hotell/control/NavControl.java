package br.com.hotell.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class NavControl {

    public String incluirHospede() {
        return "/view/cadastro/hospede.xhtml";
    }

    public String excluirHospede() {
        return "/view/exclusao/Hospede.xhtml";
    }

    public String alterarHospede() {
        return "/view/alteracao/Hospede.xhtml";
    }

    public String incluirFuncionario() {
        return "/view/cadastro/funcionario.xhtml";
    }

    public String excluirFuncionario() {
        return "/view/exclusao/Funcionario.xhtml";
    }

    public String alterarFuncionario() {
        return "/view/alteracao/Funcionario.xhtml";
    }

    public String incluirDiaria() {
        return "/view/cadastro/Diaria.xhtml";
    }

    public String alterarDiaria() {
        return "/view/alteracao/Diaria.xhtml";
    }

    public String cancelarDiaria() {
        return "/view/alteracao/Diaria.xhtml";
    }

    public String inicio() {
        return "/view/newjsf.xhtml";
    }

    public String finalizarDiaria() {
        return "/view/alteracao/Diaria.xhtml";
    }
    
     public String incluirTipoQuarto() {
        return "/view/cadastro/TipoQuarto.xhtml";
    }

    public String excluirTipoQuarto() {
        return "/view/exclusao/TipoQuarto.xhtml";
    }

    public String alterarTipoQuarto() {
        return "/view/alteracao/TipoQuarto.xhtml";
    }
    
      public String listarDiarias() {
        return "/view/consulta/listagemDiaria.xhtml";
    }

}
