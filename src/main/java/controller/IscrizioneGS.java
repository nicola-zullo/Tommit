package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtentiGSDAO;

import java.io.IOException;

@WebServlet(name="iscrizione-gs", value ="/iscrizione-gs")
public class IscrizioneGS extends HttpServlet {

    /**
     * Iscrive un Utente in un Gruppo Studio
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
            int id_utente = u.getId();
            String nome_gs = request.getParameter("nome");//prendere da un hidden param nome grupposStudio

        UtentiGSDAO utentiGSDAO = new UtentiGSDAO();

        utentiGSDAO.doSave(id_utente,nome_gs);

        //aggiungere pagina redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("IscrizioneGSAvvenuta.jsp");
        dispatcher.forward(request,response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}
