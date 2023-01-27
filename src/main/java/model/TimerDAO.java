package model;

import java.sql.*;

public class TimerDAO {

    public void doSave(TimerBean timer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO timer (nome,break,session,userId)  VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, timer.getName());
            ps.setInt(2, timer.getBreakTime());
            ps.setInt(3, timer.getSessionTime());
            ps.setInt(4, timer.getUtenteId());
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
