package model;

import java.sql.*;

public class UtentiGSDAO {

    public void doSave(int id_utente,String nome_gs) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utenti_gs (id_utenti,nome_gs)  VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setInt(1, id_utente);
            ps.setString(2, nome_gs);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id_utente,String nome_gs){
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from utenti_gs where id_utenti ="+id_utente+"AND nome_gs ="+nome_gs);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
