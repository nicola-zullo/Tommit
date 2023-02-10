package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtentiGSDAO;

import java.io.IOException;

@WebServlet(name="disiscrizione-gs", value ="/disiscrizione-gs")
public class DisiscrizioneGS extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        int id_utente = u.getId();
        String nome_gs = request.getParameter("nome");//prendere da un hidden param nome grupposStudio

        UtentiGSDAO utentiGSDAO = new UtentiGSDAO();

        utentiGSDAO.doRemove(id_utente,nome_gs);


    }

}
