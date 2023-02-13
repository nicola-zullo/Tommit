package model;

import java.sql.*;

public class FondiDAO {

    private int ricercaTot() {

        int totaleDB = 0;

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT totale from donazione where id = 1"); //id sta ad indicare un tipo di donazione
            while (rs.next()) {
                totaleDB = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totaleDB;

    }

    public void doUpdate(int importoDonato) {

        int totaleDB = ricercaTot();
        int importoAggiornato = totaleDB + importoDonato;

        try(Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("UPDATE donazione SET totale ="+importoAggiornato+" where id = 1");
            ps.executeUpdate();
            ps.close();

            } catch (SQLException e) {
            System.out.println("Update error");
            e.printStackTrace();;
        }
    }

}
