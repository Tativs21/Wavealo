package com.wavealo.dao;

import com.wavealo.model.Amministratore;
import com.wavealo.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtenteDAO {
    public Utente loginUser(String email, String password) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email = ? AND password = ?");) {
            Utente u = new Utente();
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setDataRegistrazione(rs.getDate("data_registrazione"));
                return u;
            }
            return null;
        }
    }

    public void signupUser(Utente u) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO utente (email, password, nome, cognome, data_registrazione) VALUES (?, ?, ?, ?, ?);");) {
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getNome());
            ps.setString(4, u.getCognome());
            ps.setDate(5, u.getDataRegistrazione());
            ps.executeUpdate();
        }
    }

    public Utente getUtenteById(int id) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE id = ?");) {
            ps.setInt(1, id);
            Utente u = new Utente();
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setDataRegistrazione(rs.getDate("data_registrazione"));
                return u;
            }
            return null;
        }
    }

    public Utente getUtenteByEmail(String email) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email = ?");) {
            ps.setString(1, email);
            Utente u = new Utente();
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setNome(rs.getString("nome"));
                u.setCognome(rs.getString("cognome"));
                u.setDataRegistrazione(rs.getDate("data_registrazione"));
                return u;
            }
            return null;
        }
    }
}
