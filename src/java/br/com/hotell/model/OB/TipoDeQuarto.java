package br.com.hotell.model.OB;

public class TipoDeQuarto {

    private int id;

    private String descricao;

    private float valorBase;

    private String nome;

    public TipoDeQuarto(String descricao, float valorBase, String nome) {
        this.id = 0;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.nome = nome;
    }

    public TipoDeQuarto() {
        this.id = 0;
        this.descricao = "";
        this.valorBase = 0.0f;
        this.nome = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
