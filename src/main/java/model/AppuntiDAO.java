package model;

import java.sql.*;
import java.util.ArrayList;

public class AppuntiDAO {

    public void doSave(AppuntiBean appuntiBean) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO appunti (testo, materia, creatore, stato, titolo)  VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            //associamo i "?" a i  valori dell'appuntiBean
            ps.setString(1, appuntiBean.getTesto());
            ps.setString(2, appuntiBean.getMateria());
            ps.setInt(3, appuntiBean.getIdUtente());
            ps.setBoolean(4, appuntiBean.isStato());
            ps.setString(5, appuntiBean.getTitolo());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            appuntiBean.setId(id);
            System.out.print(appuntiBean.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doRemove(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement preparedStmt = con.prepareStatement("delete from appunti where id =" + id + ";");
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Setta il parametro stato degli appunti selezionati a True
    public void setTrue(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select stato from appunti where id=" + id);
            ps.execute("update appunti set stato=" + true + " where id='" + id + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<AppuntiBean> listAppuntiAdmin() {
        ArrayList<AppuntiBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from appunti");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AppuntiBean> listUserAppunti(int id) {
        ArrayList<AppuntiBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from appunti where creatore='" + id + "' and stato='1'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AppuntiBean> listAppuntiByMateria(String materia) {
        ArrayList<AppuntiBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from appunti where stato ='1' and materia='" + materia + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppuntiBean appuntiBean = new AppuntiBean();
                appuntiBean.setId(rs.getInt("id"));
                appuntiBean.setTitolo(rs.getString("titolo"));
                appuntiBean.setTesto(rs.getString("testo"));
                appuntiBean.setMateria(rs.getString("materia"));
                appuntiBean.setIdUtente(rs.getInt("creatore"));
                appuntiBean.setStato(rs.getBoolean("stato"));
                list.add(appuntiBean);
            }
            System.out.print(list);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AppuntiBean ricercaId(int x) throws SQLException {   //funxiona con la listaUtenti già presa dal db

        AppuntiBean a = new AppuntiBean();

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *" +
                    "from appunti where id =" + x + ";");
            while (rs.next()) {
                a.setId(x);
                a.setTesto(rs.getString(2));
                a.setMateria(rs.getString(3));
                a.setIdUtente(rs.getInt(4));
                a.setStato(rs.getBoolean(5));
                a.setTitolo(rs.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;

    }
}