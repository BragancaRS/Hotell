package br.com.hotell.exec;

import br.com.hotell.model.DAO.FuncionarioDAO;
import br.com.hotell.model.OB.Funcionario;

/**
 *
 * @author root
 */
public class Principal {

    public static void main(String[] args) {

        Funcionario f = new Funcionario();
        f.setId(1);

        Funcionario f1 = FuncionarioDAO.consultarFuncionario(f);
        System.out.println(f1.getNome());
        System.out.println(f1.getPerfil());

        f1.setPerfil(3);
        
        FuncionarioDAO.alterarFuncionario(f1);
        
        f = FuncionarioDAO.consultarFuncionario(f);
        
        System.out.println(f.getNome());
        System.out.println(f.getPerfil());


    }

}
