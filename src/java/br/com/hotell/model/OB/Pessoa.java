package br.com.hotell.model.OB;

import javax.validation.constraints.NotNull;

public class Pessoa {

    private int id;

    @NotNull(message = "Campo Nome obrigatório")
    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    private String rg;

    private String sexo;

    private String estadoCivil;

    private String nacionalidade;

    private String telefone;

    private String dataDeCadastro;

    private String endereco;

    public Pessoa(String nome, String sobrenome, String cpf, String rg, String sexo, String endereco, String telefone) {
        this.id = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
    }

    public Pessoa() {
        this.id = 0;
        this.nome = "";
        this.cpf = "";
        this.rg = "";
        this.sexo = "";
        this.telefone = "";
        this.sobrenome = "";
        this.endereco = "";
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPessoaId() {
        return id;
    }

    public void setPessoaId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

}
