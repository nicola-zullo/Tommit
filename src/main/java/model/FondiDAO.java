package model;

import java.sql.*;

public class FondiDAO {

    /**
     * Restituisce l'ammontare della cifra presente nel database tramite id. Id settato di dafault a 1.
     * @return
     */
    private int ricercaTot() {

        int totaleDB = 0;

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT totale from donazione where id = 1");
            while (rs.next()) {
                totaleDB = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totaleDB;

    }

    /**
     * Eseguito dopo un pagamento somma l'mporto indicato alla cifra nel databse
     * @param importoDonato
     */
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
