package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtentiAppuntiDAO;
import model.UtentiGSDAO;

import java.io.IOException;

@WebServlet(name="salva-appunti", value ="/salva-appunti")
public class SalvaAppunti extends HttpServlet {

    /**
     * Associa Appunti ad un Utente
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
            int id_utente = u.getId();
            int idAppunti = Integer.parseInt(request.getParameter("idAppunti"));//prendere da un hidden param nome grupposStudio

        UtentiAppuntiDAO dao = new UtentiAppuntiDAO();
        dao.doSave(id_utente,idAppunti);

        //aggiungere pagina redirect
        RequestDispatcher dispatcher = request.getRequestDispatcher("SalvataggioAppuntiEffettuato.jsp");
        dispatcher.forward(request,response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}
