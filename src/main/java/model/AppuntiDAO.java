package model;

import java.sql.*;
import java.util.ArrayList;

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
            ps.setInt(4, appuntiBean.getIdUtente());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id){
        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from appunti where id ="+id+";");
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Setta il parametro stato degli appunti selezionati a True
    public void setTrue(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select stato from appunti where id="+id);
            ps.execute("update appunti set stato="+true+" where id='"+id+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<AppuntiBean> listAppunti()
    {
        ArrayList<AppuntiBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from appunti");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                AppuntiBean appuntiBean = new AppuntiBean();
                appuntiBean.setId(rs.getInt("id"));
                appuntiBean.setTitolo(rs.getString("titolo"));
                appuntiBean.setTesto(rs.getString("testo"));
                appuntiBean.setMateria(rs.getString("materia"));
                appuntiBean.setIdUtente(rs.getInt("creatore"));
                appuntiBean.setStato(rs.getBoolean("stato"));
                list.add(appuntiBean);

            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AppuntiBean> listUserAppunti(int id)
    {
        ArrayList<AppuntiBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("select * from appunti where creatore='"+id+"' and stato='1'");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                AppuntiBean gs = new AppuntiBean();
                gs.setId(rs.getInt("id"));
                gs.setMateria((rs.getString("materia")));
                gs.setTitolo(rs.getString("titolo"));
                gs.setTesto(rs.getString("testo"));
                gs.setStato(rs.getBoolean("stato"));
                gs.setIdUtente(rs.getInt("creatore"));
                list.add(gs);
            }
            return list;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
