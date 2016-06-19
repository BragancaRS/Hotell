package br.com.hotell.exec;

import br.com.hotell.model.DAO.DiariaDAO;
import br.com.hotell.model.OB.Diaria;
import br.com.hotell.model.OB.Funcionario;
import br.com.hotell.model.OB.Hospede;

/**
 *
 * @author root
 */
public class Principal {

    public static void main(String[] args) {

        Diaria d = new Diaria();
        
        d.setQuarto(2);
        Funcionario f = new Funcionario();
        f.setId(1);
        
        Hospede h = new Hospede();
        h.setId(1);
        d.setFuncionario(f);
        d.setHospede(h);
        DiariaDAO.incluirDiaria(d);


    }

}
