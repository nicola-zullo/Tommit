package model;

import java.sql.*;
import java.util.ArrayList;

public class UtenteDAO {

    /**
     * Dopo aver controllato il corretto inserimento dell'Utente lo salva nel Database
     * @param utente
     * @return
     */
    public UtenteBean doSave(UtenteBean utente) {

        //controlli
        if(!utente.controlliRegistrazione(utente))
            return null;

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (Username, Name, Surname, Email, Password, CF)  VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getName());
            ps.setString(3, utente.getSurname());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            ps.setString(6,utente.getCF());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

            return utente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Rimuove un Utente dal DB
     * @param id primary key
     */
    public void doRemove(int id){
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from user where id ="+id+";");
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Restituisce un Utente data una primary key (ID)
     * @param x primary key
     * @return
     * @throws SQLException
     */
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

    /**
     * Restiuisce un Utente dato username e password
     * @param username
     * @param password
     * @return
     */
    public UtenteBean doCheck(String username, String password) {
        UtenteBean utenteLoggato = new UtenteBean();
        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE Username = '"+username+"' AND Password = '"+password + "'");
            while(rs.next()) {
                utenteLoggato.setId(rs.getInt(1));
                utenteLoggato.setUsername(rs.getString(2));
                utenteLoggato.setName(rs.getString(3));
                utenteLoggato.setSurname(rs.getString(4));
                utenteLoggato.setEmail(rs.getString(5));
                utenteLoggato.setPassword(rs.getString(6));
                utenteLoggato.setCF(rs.getString(7));
                utenteLoggato.setRuolo(rs.getBoolean(8));
            }
            if(utenteLoggato.getUsername()==null) {
                return null;
            }else{
                return utenteLoggato;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Aggiorn ai dati di un utente con dei nuovi
     * @param u
     */
    public void doUpdate(UtenteBean u){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("update user set Username='"+u.getUsername()+"', Name='"+u.getName()+"', Surname='"+u.getSurname()+"', Email='"+u.getEmail()+"', Password='"+u.getPassword()+"', CF='"+u.getCF()+"' where id='"+u.getId()+"'");
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Restituisce una lista di Utenti con Ruolo = 0
     * @return
     */
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

    /**
     * Controlla se l'username è gia presente nel db
     * @param username
     * @return
     */
    public boolean controlloUsername(String username) {

        boolean check;

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Username from user where Username ='" + username + "';");
            if (rs.next()) {
                check=true;
            }else
                check=false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }


    /**
     * Controlla se l'email fornita è presente nel database
     * @param email
     * @return
     */
    public boolean controlloEmail(String email) {

        boolean check;

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Email from user where Email ='" + email + "';");
            if (rs.next()) {
                check=true;
            }else
                check=false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }


    /**
     * Controlla se il CF è gia presente nel database
     * @param cf
     * @return
     */
    public boolean controlloCF(String cf) {

        boolean check;

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CF from user where CF ='" + cf + "';");
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
