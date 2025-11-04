package br.com.fiap.globalSolution.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserLoginDto
{

    private String cpf;
    private String senha;

    public UserLoginDto(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public UserLoginDto() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
