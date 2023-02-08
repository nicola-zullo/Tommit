package model;

import java.sql.*;
import java.util.ArrayList;

public class UtenteDAO {

    public void doSave(UtenteBean utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (Username,Name, Surname, Email, Password, CF)  VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getName());
            ps.setString(3, utente.getSurname());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            ps.setString(5,utente.getCF());
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
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from user where id ="+id+";");
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UtenteBean ricercaId(int x) throws SQLException{   //funxiona con la listaUtenti già presa dal db

        UtenteBean u = new UtenteBean();

        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from user where id ="+x+";");
            while (rs.next()) {
                u.setId(x);
                u.setUsername(rs.getString(2));
                u.setName(rs.getString(3));
                u.setSurname(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setPassword(rs.getString(6));
                u.setCF(rs.getString(7));
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
            ResultSet rs = stmt.executeQuery("SELECT email from user where email ='" + email + "';");
            if (rs.next()) {
                check=true;
            }else
                check=false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    public void doUpdate(UtenteBean u){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("update user set Username='"+u.getUsername()+"', Name='"+u.getName()+"', Surname='"+u.getSurname()+"', Email='"+u.getEmail()+"', Password='"+u.getPassword()+"', CF='"+u.getCF()+"' where id='"+u.getId()+"'");
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<UtenteBean> listUser()
    {
        ArrayList<UtenteBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {

            PreparedStatement ps = con.prepareStatement("select * from user where role = 0");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                UtenteBean user = new UtenteBean();
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setId(rs.getInt("id"));
                user.setCF(rs.getString("CF"));
                list.add(user);
            }
            System.out.print(list);
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
