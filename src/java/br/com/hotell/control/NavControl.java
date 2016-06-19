/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        return "/view/cadastro/hospede.xhtml";
    }
    
    public String excluirFuncionario() {
        return "/view/exclusao/Funcionario.xhtml";
    }
    public String alterarFuncionario() {
        return "/view/alteracao/Funcionario.xhtml";
    }
    
    public  String inicio(){
        return "/view/newjsf.xhtml";
    }
    
    

}
