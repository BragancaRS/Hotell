package br.com.hotell.model.OB;

public class Funcionario extends Pessoa {

    private int id;

    private float salario;

    private boolean ativo;

    public Funcionario( float salario, boolean ativo, int perfil, String nome, String sobrenome, String cpf, String rg, String sexo, String endereco, String telefone) {
        super(nome, sobrenome, cpf, rg, sexo, endereco, telefone);
        this.salario = salario;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public Funcionario() {
        super();
        this.ativo = false;
        this.id = 0;
        this.perfil = 0;
        this.salario = 0.0f;
    }
    
    
    private int perfil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    
}
