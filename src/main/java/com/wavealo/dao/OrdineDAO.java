package com.wavealo.dao;

import com.wavealo.model.Ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {
    public List<Ordine> getAllOrdini() throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM ordine");
             ResultSet rs = ps.executeQuery()) {
            List<Ordine> ordine = new ArrayList<>();
            while(rs.next()){
                Ordine o = new Ordine();
                o.setId(rs.getInt("id"));
                o.setUtenteId(rs.getInt("utente_id"));
                o.setCitta(rs.getString("citta"));
                o.setCAP(rs.getString("CAP"));
                o.setVia(rs.getString("via"));
                o.setNumeroCivico(rs.getString("numero_civico"));
                o.setDataOrdine(rs.getDate("data_ordine"));
                ordine.add(o);
            }
            return ordine;
        }
    }

    public Ordine getOrdineById(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM ordine WHERE id = ?");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Ordine o = new Ordine();
            if(rs.next()){
                o.setId(rs.getInt("id"));
                o.setUtenteId(rs.getInt("utente_id"));
                o.setCitta(rs.getString("citta"));
                o.setCAP(rs.getString("CAP"));
                o.setVia(rs.getString("via"));
                o.setNumeroCivico(rs.getString("numero_civico"));
                o.setDataOrdine(rs.getDate("data_ordine"));
                return o;
            }
            return null;
        }
    }

    public List<Ordine> getOrdineByUtente(int utenteId) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM ordine WHERE utente_id = ?");) {
            ps.setInt(1, utenteId);
            ResultSet rs = ps.executeQuery();
            List<Ordine> ordini = new ArrayList<>();
            while(rs.next()){
                Ordine o = new Ordine();
                o.setId(rs.getInt("id"));
                o.setUtenteId(rs.getInt("utente_id"));
                o.setCitta(rs.getString("citta"));
                o.setCAP(rs.getString("CAP"));
                o.setVia(rs.getString("via"));
                o.setNumeroCivico(rs.getString("numero_civico"));
                o.setDataOrdine(rs.getDate("data_ordine"));
                ordini.add(o);
            }
            return ordini;
        }
    }

    public void addOrdine(Ordine o) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO ordine (utente_id, citta, CAP, via, numero_civico, data_ordine) VALUES (?, ?, ?, ?, ?, ?);");) {
            ps.setInt(1, o.getUtenteId());
            ps.setString(2, o.getCitta());
            ps.setString(3, o.getCAP());
            ps.setString(4, o.getVia());
            ps.setString(5, o.getNumeroCivico());
            ps.setDate(6, o.getDataOrdine());
            ps.executeUpdate();
        }
    }

    public List<Ordine> getOrdiniByData(Date dataInizio, Date dataFine) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM ordine WHERE data_ordine BETWEEN ? AND ?");) {
            ps.setDate(1, dataInizio);
            ps.setDate(2, dataFine);
            ResultSet rs = ps.executeQuery();
            List<Ordine> ordini = new ArrayList<>();
            while(rs.next()){
                Ordine o = new Ordine();
                o.setId(rs.getInt("id"));
                o.setUtenteId(rs.getInt("utente_id"));
                o.setCitta(rs.getString("citta"));
                o.setCAP(rs.getString("CAP"));
                o.setVia(rs.getString("via"));
                o.setNumeroCivico(rs.getString("numero_civico"));
                o.setDataOrdine(rs.getDate("data_ordine"));
                ordini.add(o);
            }
            return ordini;
        }
    }
}
