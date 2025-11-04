package br.com.fiap.globalSolution.DTO;

public class MotoEvent
{
    private String nomeMoto;
    private String placa;
    private String horario;
    private String corredorColuna;
    private String acao;
    private String email;
    private String nome;


    public MotoEvent(String nomeMoto, String placa, String horario, String corredorColuna, String acao, String email, String nome) {
        this.nomeMoto = nomeMoto;
        this.placa = placa;
        this.horario = horario;
        this.corredorColuna = corredorColuna;
        this.acao = acao;
        this.email = email;
        this.nome = nome;
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

    public MotoEvent() {
    }

    public String getNomeMoto() {
        return nomeMoto;
    }

    public void setNomeMoto(String nomeMoto) {
        this.nomeMoto = nomeMoto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCorredorColuna() {
        return corredorColuna;
    }

    public void setCorredorColuna(String corredorColuna) {
        this.corredorColuna = corredorColuna;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
