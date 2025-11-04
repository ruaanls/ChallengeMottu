package br.com.fiap.globalSolution.entity;

public enum TipoConta {

    COMUM("Comum"),
    ADM("ADMINISTRADOR");

    private String tipo;

    TipoConta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


}
