package model;

import java.sql.*;
import java.util.ArrayList;

public class GSDAO {

    public void doSave(GSBean gs) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (Nome,Materia,Luogo,Obiettivo,Stato)  VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'utente
            ps.setString(1, gs.getNome());
            ps.setString(2, gs.getMateria());
            ps.setString(3, gs.getLuogo());
            ps.setString(4, gs.getObiettivo());
            ps.setBoolean(4, gs.getStato());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            String nome = rs.getString(1);
            gs.setNome(nome);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Setta il parametro stato del gs selezionato a True
    public void setTrue(String name) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select Stato from gruppistudio where Nome="+name);
            ps.execute("update gruppistudio set Stato="+true+" where Nome='"+name+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Lista ad Admin TUTTI i GS creati dagli Utenti sia approvati che in attesa
    public ArrayList<GSBean> listGS()
    {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from gruppistudio");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                GSBean gs = new GSBean();
                gs.setNome(rs.getString("Nome"));
                gs.setMateria((rs.getString("Materia")));
                gs.setLuogo(rs.getString("Luogo"));
                gs.setObiettivo(rs.getString("obiettivo"));
                gs.setStato(rs.getBoolean("Stato"));
                list.add(gs);
            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}