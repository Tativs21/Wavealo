package com.wavealo.dao;

import com.wavealo.model.DettagliOrdine;
import com.wavealo.model.Ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class DettagliOrdineDAO {
    public List<DettagliOrdine> getAllDettagliOrdine() throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM dettagliordine;");
             ResultSet rs = ps.executeQuery()) {
            List<DettagliOrdine> dettagliOrdini = new ArrayList<>();
            while(rs.next()){
                DettagliOrdine dordine = new DettagliOrdine();
                dordine.setId(rs.getInt("id"));
                dordine.setOrdineId(rs.getInt("ordine_id"));
                dordine.setProdottoId(rs.getInt("prodotto_id"));
                dordine.setQuantita(rs.getInt("quantita"));
                dordine.setPrezzo(rs.getDouble("prezzo"));
                dettagliOrdini.add(dordine);
            }
            return dettagliOrdini;
        }
    }

    public DettagliOrdine getDettagliOrdineById(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM dettagliordine WHERE id = ?;");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            DettagliOrdine dordine = new DettagliOrdine();
            if (rs.next()) {
                dordine.setId(rs.getInt("id"));
                dordine.setOrdineId(rs.getInt("ordine_id"));
                dordine.setProdottoId(rs.getInt("prodotto_id"));
                dordine.setQuantita(rs.getInt("quantita"));
                dordine.setPrezzo(rs.getDouble("prezzo"));
                return dordine;
            }
            return null;
        }
    }

    public List<DettagliOrdine> getDettagliOrdineByOrdineId(int ordineId) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM dettagliordine WHERE ordine_id = ?;");) {
            ps.setInt(1, ordineId);
            ResultSet rs = ps.executeQuery();
            List<DettagliOrdine> dettagliOrdini = new ArrayList<>();
            while (rs.next()) {
                DettagliOrdine dordine = new DettagliOrdine();
                dordine.setId(rs.getInt("id"));
                dordine.setOrdineId(rs.getInt("ordine_id"));
                dordine.setProdottoId(rs.getInt("prodotto_id"));
                dordine.setQuantita(rs.getInt("quantita"));
                dordine.setPrezzo(rs.getDouble("prezzo"));
                dettagliOrdini.add(dordine);
            }
            return dettagliOrdini;
        }
    }

    public void addDettagliOrdine(DettagliOrdine dordine) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO dettagliordine (ordine_id, prodotto_id, quantita, prezzo) VALUES (?, ?, ?, ?);");) {
            ps.setInt(1, dordine.getOrdineId());
            ps.setInt(2, dordine.getProdottoId());
            ps.setInt(3, dordine.getQuantita());
            ps.setDouble(4, dordine.getPrezzo());
            ps.executeUpdate();
        }
    }
}