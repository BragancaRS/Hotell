package br.com.hotell.control;

import br.com.hotell.model.DAO.DiariaDAO;
import br.com.hotell.model.DAO.HospedeDAO;
import br.com.hotell.model.DAO.QuartoDAO;
import br.com.hotell.model.DAO.TipoQuartoDAO;
import br.com.hotell.model.OB.Diaria;
import br.com.hotell.model.OB.Hospede;
import br.com.hotell.model.OB.Quarto;
import br.com.hotell.model.OB.TipoDeQuarto;
import br.com.hotell.model.OB.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class DiariaController {

    Diaria d = new Diaria();
    String rg = "";
    ArrayList<Diaria> diarias = new ArrayList<>();
    Float valorDiaria = 0.0f;
    TipoDeQuarto tipoDeQuarto = new TipoDeQuarto();
    ArrayList<SelectItem> quartos = new ArrayList<>();
    ArrayList<TipoDeQuarto> tdqs = TipoQuartoDAO.listarTipoDeQuarto();
    ArrayList<ArrayList<Quarto>> quartosDisponiveis = getQuartosDisponiveis();

    public Diaria getD() {
        return d;
    }

    public void setD(Diaria d) {
        this.d = d;
    }

    public void incluirDiaria() {
        d.getHospede().setRg(rg);
        d.setHospede(HospedeDAO.consultarHospede(d.getHospede()));
        System.out.println("HOOOOOOOOOOOOOOOOOOOOOO " + d.getHospede().getId() + " -- -- -- -- ---     -----------------------dsfsdfsss");
        if (quartosDisponiveis.isEmpty()) {
            System.out.println("66666666666666666666666666666666666");
            System.out.println("66666666666666666666666666666666666");
            return;
        }
        if (quartosDisponiveis.get(tipoDeQuarto.getId()).isEmpty()) {
            System.out.println("88888888888888888888888888888888888");
            System.out.println("88888888888888888888888888888888888");
            return;
            
        }
        d.setQuarto(quartosDisponiveis.get(tipoDeQuarto.getId()).get(0));
        DiariaDAO.incluirDiaria(d);
        d = DiariaDAO.consultarDiaria(d);

    }

    public void alterarDiaria() {
        DiariaDAO.alterarDiaria(d, 2);
    }

    public void exluirDiaria() {
        DiariaDAO.excluirDiaria(d);
    }

    public void consultarDiaria() {
        DiariaDAO.consultarDiaria(d);
    }

    public void finalizarDiaria() {
        DiariaDAO.alterarDiaria(d, 1);
    }

    private ArrayList<TipoDeQuarto> getTiposDeQuarto() {
        return TipoQuartoDAO.listarTipoDeQuarto();
    }

    private ArrayList<ArrayList<Quarto>> getQuartosDisponiveis() {
        ArrayList<ArrayList<Quarto>> q = new ArrayList<>();
        ArrayList<Quarto> quartos = new ArrayList();
        ArrayList<Quarto> aux = new ArrayList<>();
        quartos = QuartoDAO.listarQuartosDisponiveis();
        for (TipoDeQuarto tdq : tdqs) {
            for (Quarto quarto : quartos) {
                if (quarto.getTipo() == tdq.getId()) {
                    aux.add(quarto);
                }
            }
            q.add(aux);
            aux = new ArrayList<>();

        }
        return q;
    }

    public ArrayList<SelectItem> getTdqs() {
        ArrayList<SelectItem> a = new ArrayList<>();
        for (TipoDeQuarto tdq : tdqs) {
            a.add(new SelectItem(tdq, tdq.getNome()));
        }
        return a;
    }

    public void setTdqs(ArrayList<TipoDeQuarto> tdqs) {
        this.tdqs = tdqs;
    }

    public TipoDeQuarto getTipoDeQuarto() {
        return tipoDeQuarto;
    }

    public void setTipoDeQuarto(TipoDeQuarto tipoDeQuarto) {
        this.tipoDeQuarto = tipoDeQuarto;
    }

    public void atualizarQuartosDisponiveis() {
        ArrayList<Quarto> q = new ArrayList<>();

        q = quartosDisponiveis.get(tipoDeQuarto.getId());
        ArrayList<SelectItem> quartos = new ArrayList<>();
        for (Quarto quarto : q) {
            quartos.add(new SelectItem(quarto, quarto.getNumero()));
        }
        this.quartos = quartos;
    }

    public ArrayList<SelectItem> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<SelectItem> quartos) {
        this.quartos = quartos;
    }

    public Float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void atualizarValorDiaria() {
        this.valorDiaria = tipoDeQuarto.getValorBase();
        System.out.println("sdkfmsdplfkmsdlfkm");
    }

    public ArrayList<Diaria> getDiarias() {
        ArrayList<Diaria> a = new ArrayList<>();
        a.add(d);
        this.diarias = a;
        return diarias;
    }

    public ArrayList<Diaria> listarDiarias() {
        return DiariaDAO.listarDiarias();
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    

}
