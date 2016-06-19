/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotell.control;

import br.com.hotell.model.DAO.HospedeDAO;
import br.com.hotell.model.OB.Hospede;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author raphael
 */
@ManagedBean
@SessionScoped
public class HospedeController {

    Hospede h = new Hospede();

    public Hospede getH() {
        return h;
    }

    public void setH(Hospede h) {
        this.h = h;
    }

    public String incluirHospede() {
        if (HospedeDAO.incluirhospede(h) == true) {
            return "sucessoIncluir";
        }
        return "fracassoIncluir";
    }

    public void consultarHospede() {
        Hospede aux = new Hospede();
        aux = HospedeDAO.consultarHospede(h);
        if (aux.getId() > 0) {
            this.h = aux;
            System.out.println("dfsdçdfsdflç,");
        }
        return;
    }

    public String alterarHospede() {
        if (HospedeDAO.alterarHospede(h) == true) {
            return "sucessoAlterar";
        }
        return "fracassoAlterar";
    }

    public String excluir() {
        if (HospedeDAO.excluirHospede(h) == true) {
            return "sucessoExcluir";
        }
        return "fracassoExcluir";
    }
}
