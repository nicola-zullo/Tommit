package model;

import java.sql.*;
import java.util.ArrayList;

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


    public void deleteTimer(TimerBean timer){
        Statement st;
        try (Connection con = ConPool.getConnection()) {
            st= con.createStatement();
            st.executeUpdate("delete from timer where nome like '%"+timer.getName()+"%' and userId like '%"+timer.getUtenteId()+"%' and session like '%"+timer.getSessionTime()+"%' and break like '%"+timer.getBreakTime()+"%'");
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<TimerBean>showAllTimer(String userID)
    {
        ArrayList<TimerBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from timer where `userId` like '%"+userID+"%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                TimerBean timer = new TimerBean();
                timer.setName(rs.getString("nome"));
                timer.setBreakTime((rs.getInt("break")));
                timer.setSessionTime(rs.getInt("session"));
                timer.setUtenteId(rs.getInt("uerId"));
                list.add(timer);
            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
