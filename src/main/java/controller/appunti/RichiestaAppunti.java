package controller.appunti;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.AppuntiBean;
import model.dao.AppuntiDAO;
import model.entity.UtenteBean;

import java.io.IOException;

@WebServlet(name="richiesta-creazione-appunti-servlet", value ="/richiesta-creazione-appunti-servlet")
public class RichiestaAppunti extends HttpServlet {


    /**
     * Processa la richiesta di approvazione per la pubblicazione di AppuntiBean
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String materia = request.getParameter("categorie");
        String testo = request.getParameter("testo");
        int idCreatore= ((UtenteBean)request.getSession().getAttribute("utenteLoggato")).getId();
        AppuntiBean appunti= new AppuntiBean();
        appunti.setMateria(materia);
        appunti.setTesto(testo);
        appunti.setIdUtente(idCreatore);
        appunti.setStato(false);
        appunti.setTitolo(nome);
        AppuntiDAO dao = new AppuntiDAO();
        appunti = dao.doSave(appunti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RichiestaAppuntiInviata.jsp");
        dispatcher.forward(request,response);
    }

}