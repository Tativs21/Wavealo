package com.wavealo.model;

public class DettagliOrdine {
    private int id;
    private int ordineId;
    private int prodottoId;
    private int quantita;
    private double prezzo;

    public DettagliOrdine() {}

    public DettagliOrdine(int id, int ordineId, int quantita, int prodottoId, double prezzo) {
        this.id = id;
        this.ordineId = ordineId;
        this.quantita = quantita;
        this.prodottoId = prodottoId;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
