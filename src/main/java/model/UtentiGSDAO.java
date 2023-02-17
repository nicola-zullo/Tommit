package model;

import java.sql.*;

public class UtentiGSDAO {

    /**
     * Salva l'iscrizione di un utente in un gruppostudio
     * @param id_utente primary key utente
     * @param nome_gs primary key gruppo studio
     */
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
            System.out.println(id_utente+"\n"+nome_gs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina escrizione dell'utente dal gruppo studio
     * @param id_utente primary key utente
     * @param nome_gs primary key gruppostudio
     */
    public void doRemove(int id_utente,String nome_gs){
        System.out.println(id_utente+"\n"+nome_gs);
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from utenti_gs where id_utenti ="+id_utente+" AND nome_gs = '"+nome_gs+"'");
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Controlla se un utente è già iscritto al gruppo studio
     * @param id_utente
     * @param nome_gs
     */
    public boolean doCheck(int id_utente, String nome_gs) {
        System.out.println(id_utente+"\n"+nome_gs);
        boolean check=false;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement preparedStmt = con.prepareStatement("select * from utenti_gs where id_utenti =" + id_utente + " AND nome_gs = '" + nome_gs + "'");
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                check =true;
            } else {
                check = false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
