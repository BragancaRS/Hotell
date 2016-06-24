package br.com.hotell.model.OB;

import java.io.Serializable;

public class Usuario extends Funcionario implements Serializable{

    private int id;
    private int FuncionarioID;

    private String login;

    private String senha;

    public Usuario() {
        this.id = 0;
        this.login = "";
        this.senha = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autenticar() {
        return true;
    }

    public int getFuncionarioID() {
        return FuncionarioID;
    }

    public void setFuncionarioID(int FuncionarioID) {
        this.FuncionarioID = FuncionarioID;
    }

}
