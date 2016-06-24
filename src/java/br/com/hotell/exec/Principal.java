package br.com.hotell.exec;

import br.com.hotell.model.DAO.DiariaDAO;
import br.com.hotell.model.OB.Diaria;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Principal {

    public static void main(String[] args) {

        ArrayList<Diaria> d = new ArrayList<>();
        d = DiariaDAO.listarDiarias();
        for (Diaria diaria : d) {
            
        }

    }

}
