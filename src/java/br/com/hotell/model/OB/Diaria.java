package br.com.hotell.model.OB;

public class Diaria {

    private int id;

    private String dataEntrada;
    private String dataFeachamento;

    private Hospede hospede;

    private float valor;

    private Funcionario funcionario;

    private Quarto quarto;

    public Diaria() {
        this.dataEntrada = "";
        this.hospede = new Hospede();
        this.valor = 0;
        this.funcionario = new Funcionario();
        this.quarto = new Quarto();
        this.dataEntrada = "";
        this.dataFeachamento = "";
    }

    public Diaria(String dataEntrada, Hospede hospede, float valor, Funcionario funcionario, Quarto quarto) {
        this.dataEntrada = dataEntrada;
        this.hospede = hospede;
        this.valor = valor;
        this.funcionario = funcionario;
        this.quarto = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataFeachamento() {
        return dataFeachamento;
    }

    public void setDataFeachamento(String dataFeachamento) {
        this.dataFeachamento = dataFeachamento;
    }

}
