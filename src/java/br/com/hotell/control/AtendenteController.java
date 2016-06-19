package br.com.hotell.control;

import br.com.hotell.model.DAO.HospedeDAO;
import br.com.hotell.model.OB.Atendente;
import br.com.hotell.model.OB.Diaria;
import br.com.hotell.model.OB.Hospede;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 *
 * @author raphael
 */
@ManagedBean
@SessionScoped
public class AtendenteController {

    Atendente a = new Atendente();

    public Atendente getA() {
        return a;
    }

    public void setA(Atendente a) {
        this.a = a;
    }

    public Diaria incluirDiaria(Diaria d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Hospede consultarDiaria(int id, Hospede h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Diaria finalizarDiaria(Diaria d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Diaria alterarDiaria(Diaria d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String incluirHospede(Hospede h) {
        if (HospedeDAO.incluirhospede(h)) {
            return "sucesso";
        }
        return "fracasso";
    }

    public Hospede removerHospede(Hospede h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Hospede alterarHospede(Hospede h) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String consultarHospede(int id, String cpf, String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
