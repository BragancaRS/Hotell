package br.com.hotell.model.OB;

public class Hospede extends Pessoa {

    private String profissao;

    private String placaDoCarro;

    private int id;

    public Hospede(String nome, String sobrenome, String cpf, String rg, String sexo,
            String endereco, String telefone, String profissao, String placaDoCarro) {
        super(nome, sobrenome, cpf, rg, sexo, endereco, telefone);
        this.profissao = profissao;
        this.placaDoCarro = placaDoCarro;
        this.id = 0;

    }

    public Hospede() {
        super();
        this.profissao = "";
        this.placaDoCarro = "";
        this.id = 0;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getPlacaDoCarro() {
        return placaDoCarro;
    }

    public void setPlacaDoCarro(String placaDoCarro) {
        this.placaDoCarro = placaDoCarro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
