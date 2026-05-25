package com.wavealo.dao;

import com.wavealo.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public List<Categoria> getAllCategorie() throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria WHERE attivo=true");
             ResultSet rs = ps.executeQuery()) {
            List<Categoria> categorie = new ArrayList<>();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setAttivo(rs.getBoolean("attivo"));
                categorie.add(c);
            }
            return categorie;
        }
    }

    public Categoria getCategoriaById(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria WHERE id = ?");) {
            Categoria c = new Categoria();
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setAttivo(rs.getBoolean("attivo"));
                return c;
            }
            return null;
        }
    }

    public Categoria getCategoriaByNome(String nome) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria WHERE nome = ?");) {
            Categoria c = new Categoria();
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setAttivo(rs.getBoolean("attivo"));
                return c;
            }
            return null;
        }
    }

    public void addCategoria(Categoria c) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO categoria (nome, attivo) VALUES (?, ?);");) {
            ps.setString(1, c.getNome());
            ps.setBoolean(2, c.isAttivo());
            ps.executeUpdate();
        }
    }

    public void updateCategoria(Categoria c) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE categoria SET nome = ?, attivo = ? WHERE id = ?;");) {
            ps.setString(1, c.getNome());
            ps.setBoolean(2, c.isAttivo());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
        }
    }

    public void deleteCategoria(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE categoria SET attivo = false WHERE id = ?");) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
