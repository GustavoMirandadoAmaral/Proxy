package org.example;

public class Gerente {

    private String nome;
    private boolean administrador;

    public Gerente(String nome, boolean administrador) {
        this.nome = nome;
        this.administrador = administrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }
}
