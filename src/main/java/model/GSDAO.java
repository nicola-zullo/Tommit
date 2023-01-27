package model;

import java.sql.*;

public class GSDAO {

    public void doSave(GSBean gs) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (Nome,Materia,Luogo,Obiettivo,Stato)  VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, gs.getNome());
            ps.setString(2, gs.getMateria());
            ps.setString(3, gs.getLuogo());
            ps.setString(4, gs.getObiettivo());
            ps.setBoolean(4, gs.getStato());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            String nome = rs.getString(1);
            gs.setNome(nome);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
