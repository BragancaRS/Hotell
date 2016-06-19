/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotell.control;

import br.com.hotell.model.DAO.QuartoDAO;
import br.com.hotell.model.OB.Quarto;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author raphael
 */
@ManagedBean
public class QuartoController {

    Quarto q = new Quarto();

    public Quarto getQ() {
        return q;
    }

    public void setQ(Quarto q) {
        this.q = q;
    }

    public String cadastrar() {
        if (QuartoDAO.incluirQuarto(q)) {
            return "sucessocadastrar";
        }
        return "fracassocadastrar";
    }

    public String consultar() {
        Quarto aux = new Quarto();
        aux = QuartoDAO.consultarQuarto(q.getNumero());
        if (aux.getId() > 0) {
            return "sucessoConsultar";
        }
        return "fracassoConsultar";
    }

    public String excluir() {
        if (QuartoDAO.exlcuirQuarto(q)) {
            return "sucessoExcluir";
        }
        return "fracassoExcluir";
    }

    public String alterar() {
        if (QuartoDAO.alterarQuarto(q)) {
            return "sucessoAlterar";
        }
        return "fracassoAlterar";
    }

}
