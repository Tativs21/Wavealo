package com.wavealo.model;

import java.sql.Date;

public class Utente {
    private int id;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private Date dataRegistrazione;

    public Utente() {}

    public Utente(int id, String email, String password, String nome, String cognome, Date dataRegistrazione) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataRegistrazione = dataRegistrazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(Date dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }
}
