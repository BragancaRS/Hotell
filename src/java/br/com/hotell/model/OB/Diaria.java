package br.com.hotell.model.OB;

public class Diaria {

    private int id;

    private String data;

    private Hospede hospede;

    private float valor;

    private Funcionario funcionario;

    public Diaria() {
        this.data = "";
        this.hospede = new Hospede();
        this.valor = 0;
        this.funcionario = new Funcionario();
    }

    public Diaria(String data, Hospede hospede, float valor, Funcionario funcionario) {
        this.data = data;
        this.hospede = hospede;
        this.valor = valor;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
