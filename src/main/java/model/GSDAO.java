package model;

import java.sql.*;
import java.util.ArrayList;


public class GSDAO {

    /**
     * Dopo aver controllato i parametri del GSBean lo salva nel Database.
     * @param gsBean
     * @return
     */
    public GSBean doSave(GSBean gsBean) {

        if(!gsBean.controlliRichiesta(gsBean))
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

    /**
     * Controlli di corretto inserimento di un GSBean
     * @param gsBean
     * @return
     */


    /**
     * Rimuove un GSBean dal DataBase
     * @param nome primary key
     */
    public void doRemove(String nome){

        try (Connection con = ConPool.getConnection()){
            PreparedStatement preparedStmt = con.prepareStatement("delete from gruppistudio where Nome = '"+nome+"' ;");
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Restituisce un GS data una stringa
     * @param nome primary key
     * @return
     */
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


    /**
     * Setta il parametro stato del gs selezionato a True
     * @param name primary key
     */
    public void setTrue(String name) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select Stato from gruppistudio where Nome="+name);
            ps.execute("update gruppistudio set Stato="+true+" where Nome='"+name+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //

    /**
     * Restituisce una lista di tutti i GS con Stato = 0. Metodo usato esclusivamenta da Admin
     * @return
     */
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

    /**
     * Restituisce una lista di GS creati da Un Utente tramite id
     * @param id primary key Utente
     * @return
     */
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

    /**
     * Restituisce una lista di tutti i GS Accessibili dall'utente.I gruppi di cui si fa gia l'utente parte non verranno mostrati
     * @param idUtente
     * @return
     */
    public ArrayList<GSBean> listGSAccessibili(int idUtente)
    {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection())
        {
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                    "from gruppistudio\n" +
                    "where gruppistudio.Stato = 1 and (Nome) NOT IN ((SELECT Nome\n" +
                    "                                                 from gruppistudio, utenti_gs\n" +
                    "                                                 where gruppistudio.Nome = utenti_gs.nome_gs AND utenti_gs.id_utenti = "+idUtente+"\n" +
                    "                                                 group by Nome))\n" +
                    "\n");
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

    /**
     * Restituisce una lista di GS data una materia..I gruppi di cui si fa gia l'utente parte non verranno mostrati
     * @param materia
     * @param idUtente
     * @return
     */
    public ArrayList<GSBean> listGSByMateria(String materia,int idUtente) {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                    "from gruppistudio\n" +
                    "where gruppistudio.Stato = 1 AND gruppistudio.Materia = '"+materia+"' and (Nome) NOT IN ((SELECT Nome\n" +
                    "                                                 from gruppistudio, utenti_gs\n" +
                    "                                                 where gruppistudio.Nome = utenti_gs.nome_gs AND utenti_gs.id_utenti ="+idUtente+"\n" +
                    "                                                 group by Nome))\n" +
                    "\n");
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

    /**
     * Restituisce una lista di GS di cui si fa parte
     * @param idUtente
     * @return
     */
    public ArrayList<GSBean> listGSIscritto(int idUtente) {
        ArrayList<GSBean> list = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                    "    from gruppistudio, utenti_gs\n" +
                    "    where gruppistudio.Nome = utenti_gs.nome_gs AND utenti_gs.id_utenti = "+idUtente+"\n" +
                    "    group by Nome");
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

    /**
     * Controlla se è gia presente un GS con il nome fornito
     * @param nome
     * @return
     */
    public boolean controlloNomeGS(String nome) {

        boolean check;

        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Nome from gruppistudio where Nome ='" + nome + "';");
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