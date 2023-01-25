package model;

import java.sql.*;

public class UtenteDAO {

    public void doSave(UtenteBean utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (Username,Name, Surname, Email, Password)  VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getName());
            ps.setString(3, utente.getSurname());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id){
    }

    public UtenteBean ricercaId(int x) throws SQLException{   //funxiona con la listaUtenti già presa dal db

        UtenteBean u = new UtenteBean();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from utenti where id ="+x+";");
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setSurname(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;

    }

    public boolean controlloEmail(String email) {

        boolean check;

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email from utenti where email ='" + email + "';");
            if (rs.next()) {
                check=true;
            }else
                check=false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

}
