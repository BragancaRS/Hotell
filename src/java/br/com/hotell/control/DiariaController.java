package br.com.hotell.control;

import br.com.hotell.model.DAO.DiariaDAO;
import br.com.hotell.model.OB.Diaria;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class DiariaController {

    Diaria d = new Diaria();

    public Diaria getD() {
        return d;
    }

    public void setD(Diaria d) {
        this.d = d;
    }

    public void incluirDiaria() {
        DiariaDAO.incluirDiaria(d);
    }

    public void alterarDiaria() {
        DiariaDAO.alterarDiaria(d);
    }

    public void exluirDiaria() {
        DiariaDAO.excluirDiaria(d);
    }

    public void consultarDiaria() {
        DiariaDAO.consultarDiaria(d);
    }

}
