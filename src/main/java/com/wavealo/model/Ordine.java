package com.wavealo.model;

import java.sql.Date;

public class Ordine {
    private int id;
    private int utenteId;
    private String citta;
    private String CAP;
    private String via;
    private String numeroCivico;
    private Date dataOrdine;

    public Ordine() {}

    public Ordine(int id, int utenteId, String citta, String CAP, String via, String numeroCivico, Date dataOrdine) {
        this.id = id;
        this.utenteId = utenteId;
        this.citta = citta;
        this.CAP = CAP;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.dataOrdine = dataOrdine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
