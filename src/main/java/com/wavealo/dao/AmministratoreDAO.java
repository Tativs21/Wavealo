package com.wavealo.dao;

import com.wavealo.model.Amministratore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AmministratoreDAO {
    public Amministratore loginAdmin(String email, String password) throws Exception{
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM amministratore WHERE email = ? AND password = ?");) {
            Amministratore a = new Amministratore();
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setCognome(rs.getString("cognome"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                return a;
            }
            return null;
        }
    }
}
