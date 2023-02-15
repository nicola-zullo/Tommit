package model;

import java.sql.*;
import java.util.ArrayList;


public class GSDAO {

    public GSBean doSave(GSBean gsBean) {

        if(!controlliRichiesta(gsBean))
            return null;

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO gruppistudio (Nome, Materia, Luogo, Obiettivo, Stato, idCreatore)  VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i valori dell'appuntiBean

            ps.setString(1, gsBean.getNome());
            ps.setString(2, gsBean.getMateria());
            ps.setString(3, gsBean.getLuogo());
            ps.setString(4, gsBean.getObiettivo());
            ps.setBoolean(5, gsBean.getStato());
            ps.setInt(6,gsBean.getIdCreatore());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            System.out.print(gsBean.toString());
            return gsBean;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean controlliRichiesta(GSBean gsBean) {

        if (gsBean.getNome() == "" || gsBean.getNome() == null)
            return false;
        if (gsBean.getObiettivo() == "" || gsBean.getObiettivo() == null)
            return false;
        if (gsBean.getLuogo() == "" || gsBean.getLuogo() == null)
            return false;
        if (!(gsBean.getMateria().equalsIgnoreCase("umanistica") || gsBean.getMateria().equalsIgnoreCase("scientifico") || gsBean.getMateria().equalsIgnoreCase("artistica") || gsBean.getMateria().equalsIgnoreCase("informatica") || gsBean.getMateria().equalsIgnoreCase("lingue") || gsBean.getMateria().equalsIgnoreCase("sanitario")))
            return false;


        return true;
    }


    public void doRemove(String nome){

        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from gruppistudio where Nome = '"+nome+"' ;");
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GSBean retriveGS(String nome){

        GSBean gs = new GSBean();
        System.out.println("nome passato retrive: "+ nome);
        try(Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from gruppistudio where Nome ='"+nome+"';");
            while (rs.next()) {
                gs.setNome(rs.getString(1));
                gs.setMateria(rs.getString(2));
                gs.setLuogo(rs.getString(3));
                gs.setObiettivo(rs.getString(4));
                gs.setStato(rs.getBoolean(5));
                gs.setIdCreatore(rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gs;

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
            PreparedStatement ps = con.prepareStatement("select * from gruppistudio where Stato = 0");
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

    public ArrayList<GSBean> listUserGS(int id)
    {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from gruppistudio where idCreatore='"+id+"' and Stato='1'");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                GSBean gs = new GSBean();
                gs.setNome(rs.getString("Nome"));
                gs.setMateria((rs.getString("Materia")));
                gs.setLuogo(rs.getString("Luogo"));
                gs.setObiettivo(rs.getString("obiettivo"));
                gs.setStato(rs.getBoolean("Stato"));
                gs.setIdCreatore(rs.getInt("idCreatore"));
                list.add(gs);
            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<GSBean> listGSAccessibili()
    {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from gruppistudio where Stato = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                GSBean gs = new GSBean();
                gs.setNome(rs.getString("Nome"));
                gs.setMateria((rs.getString("Materia")));
                gs.setLuogo(rs.getString("Luogo"));
                gs.setObiettivo(rs.getString("obiettivo"));
                gs.setStato(rs.getBoolean("Stato"));
                gs.setIdCreatore(rs.getInt("idCreatore"));
                list.add(gs);
            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<GSBean> listGSByMateria(String materia) {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from gruppistudio where Stato ='1' and Materia='" + materia + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GSBean gs = new GSBean();
              gs.setNome(rs.getString("Nome"));
              gs.setMateria(rs.getString("Materia"));
              gs.setLuogo(rs.getString("Luogo"));
              gs.setObiettivo(rs.getString("Obiettivo"));
              gs.setIdCreatore(rs.getInt("idCreatore"));
              gs.setStato(rs.getBoolean("stato"));
                list.add(gs);
            }
            System.out.print(list);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}