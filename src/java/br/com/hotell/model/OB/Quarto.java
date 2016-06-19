package br.com.hotell.model.OB;

public class Quarto {

    private int id;

    private String numero;

    private int tipo;

    public Quarto() {
        super();
    }

    public Quarto(String numero, int tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
