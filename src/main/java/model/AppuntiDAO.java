package model;

import java.sql.*;

public class AppuntiDAO {

    public void doSave(AppuntiBean appuntiBean) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO appunti (titolo,testo,materia,creatore)  VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, appuntiBean.getTitolo());
            ps.setString(2, appuntiBean.getTesto());
            ps.setString(3, appuntiBean.getMateria());
            ps.setString(4, appuntiBean.getIdUtente());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
