package com.wavealo.dao;

import com.wavealo.model.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {
    public List<Prodotto> getAllProdotti() throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Prodotto WHERE attivo=true");
             ResultSet rs = ps.executeQuery()) {
            List<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                p.setQuantita(rs.getInt("quantita"));
                p.setDataInserimento(rs.getDate("data_inserimento"));
                p.setDescrizione(rs.getString("descrizione"));
                p.setMarca(rs.getString("marca"));
                p.setImmagine(rs.getString("immagine"));
                p.setAttivo(rs.getBoolean("attivo"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                prodotti.add(p);
            }
            return prodotti;
        }
    }

    public Prodotto getProdottoById(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Prodotto WHERE id = ?");) {
            Prodotto p = new Prodotto();
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                p.setQuantita(rs.getInt("quantita"));
                p.setDataInserimento(rs.getDate("data_inserimento"));
                p.setDescrizione(rs.getString("descrizione"));
                p.setMarca(rs.getString("marca"));
                p.setImmagine(rs.getString("immagine"));
                p.setAttivo(rs.getBoolean("attivo"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                return p;
            }
            return null;
        }
    }

    public List<Prodotto> getProdottiByCategoriaId(int categoriaId) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Prodotto WHERE categoria_id = ?");) {
            ps.setInt(1, categoriaId);
            ResultSet rs = ps.executeQuery();
            List<Prodotto> prodotti = new ArrayList<>();
            while(rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                p.setQuantita(rs.getInt("quantita"));
                p.setDataInserimento(rs.getDate("data_inserimento"));
                p.setDescrizione(rs.getString("descrizione"));
                p.setMarca(rs.getString("marca"));
                p.setImmagine(rs.getString("immagine"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                p.setAttivo(rs.getBoolean("attivo"));
                prodotti.add(p);
            }
            return prodotti;
        }
    }

    public void addProdotto(Prodotto p) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO prodotto (nome, prezzo, quantita, data_inserimento, descrizione, marca, immagine, attivo, categoria_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPrezzo());
            ps.setInt(3, p.getQuantita());
            ps.setDate(4, p.getDataInserimento());
            ps.setString(5, p.getDescrizione());
            ps.setString(6, p.getMarca());
            ps.setString(7, p.getImmagine());
            ps.setBoolean(8, p.isAttivo());
            ps.setInt(9, p.getCategoriaId());
            ps.executeUpdate();
        }
    }

    public void updateProdotto(Prodotto p) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE prodotto SET nome = ?, prezzo = ?, quantita = ?, data_inserimento = ?, descrizione = ?, marca = ?, immagine = ?, attivo = ?, categoria_id = ? WHERE id = ?");) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPrezzo());
            ps.setInt(3, p.getQuantita());
            ps.setDate(4, p.getDataInserimento());
            ps.setString(5, p.getDescrizione());
            ps.setString(6, p.getMarca());
            ps.setString(7, p.getImmagine());
            ps.setBoolean(8, p.isAttivo());
            ps.setInt(9, p.getCategoriaId());
            ps.setInt(10, p.getId());
            ps.executeUpdate();
        }
    }

    public void deleteProdotto(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE prodotto SET attivo = false WHERE id = ?");) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
