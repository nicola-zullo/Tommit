package model;

import java.sql.*;

public class UtentiAppuntiDAO {

    public void doSave(int id_utente,int id_appunti) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utenti_appunti (id_utenti,id_appunti)  VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setInt(1, id_utente);
            ps.setInt(2, id_appunti);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id_utente,int id_appunti){
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from utenti_appunti where id_utenti ="+id_utente+" AND id_appunti = "+id_appunti);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
