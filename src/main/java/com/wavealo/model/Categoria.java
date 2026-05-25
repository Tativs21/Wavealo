package com.wavealo.model;

public class Categoria {
    private int id;
    private String nome;
    private boolean attivo;

    public Categoria() {}

    public Categoria(int id, String nome, boolean attivo) {
        this.id = id;
        this.nome = nome;
        this.attivo = attivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
}
