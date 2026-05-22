package com.wavealo.model;

import java.sql.Date;

public class Prodotto {
    private int id;
    private String nome;
    private double prezzo;
    private int quantita;
    private Date dataInserimento;
    private String descrizione;
    private String marca;
    private String immagine;
    private boolean attivo;
    private int categoriaId;


    public Prodotto() {}
    public Prodotto(int id, String nome, double prezzo, int quantita, Date dataInserimento, String descrizione, String marca, String immagine, boolean attivo, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.dataInserimento = dataInserimento;
        this.descrizione = descrizione;
        this.marca = marca;
        this.immagine = immagine;
        this.attivo = attivo;
        this.categoriaId = categoriaId;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public double getPrezzo(){
        return this.prezzo;
    }

    public int getQuantita(){
        return this.quantita;
    }

    public Date getDataInserimento(){
        return this.dataInserimento;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getImmagine(){
        return this.immagine;
    }

    public boolean isAttivo(){
        return this.attivo;
    }

    public int getCategoriaId(){
        return this.categoriaId;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
