package br.com.fiap.globalSolution.DTO;

import br.com.fiap.globalSolution.entity.TipoConta;


public class UserRegistroDto
{
    private String nome;
    private String cpf;
    private TipoConta tipoConta;
    private String email;
    private String senha;

    public UserRegistroDto(String nome, String cpf, TipoConta tipoConta, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoConta = tipoConta;
        this.email = email;
        this.senha = senha;
    }

    public UserRegistroDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
