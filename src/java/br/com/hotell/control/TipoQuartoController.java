
package br.com.hotell.control;

import br.com.hotell.model.DAO.TipoQuartoDAO;
import br.com.hotell.model.OB.TipoDeQuarto;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author raphael
 */
@ManagedBean
public class TipoQuartoController {
    
    TipoDeQuarto tdq = new TipoDeQuarto();

    public TipoDeQuarto getTdq() {
        return tdq;
    }

    public void setTdq(TipoDeQuarto tdq) {
        this.tdq = tdq;
    }
    
     public String cadastrar() {
        if (TipoQuartoDAO.incluirTipoDeQuarto(tdq)) {
            return "sucessocadastrar";
        }
        return "fracassocadastrar";
    }

    public String consultar() {
        TipoDeQuarto aux = new TipoDeQuarto();
        aux = TipoQuartoDAO.consultarTipoDeQuarto(tdq);
        if (aux.getId() > 0) {
            return "sucessoConsultar";
        }
        return "fracassoConsultar";
    }

    public String excluir() {
        if (TipoQuartoDAO.exlcuirTipoDeQuarto(tdq.getId())) {
            return "sucessoExcluir";
        }
        return "fracassoExcluir";
    }

    public String alterar() {
        if (TipoQuartoDAO.alterarTipoDeQuarto(tdq)) {
            return "sucessoAlterar";
        }
        return "fracassoAlterar";
    }
    
}
