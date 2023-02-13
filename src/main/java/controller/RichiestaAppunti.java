package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AppuntiBean;
import model.AppuntiDAO;
import model.UtenteBean;

import java.io.IOException;

@WebServlet(name="richiesta-creazione-appunti-servlet", value ="/richiesta-creazione-appunti-servlet")
public class RichiestaAppunti extends HttpServlet {

    public void richiesta(HttpServletRequest request, HttpServletResponse response, AppuntiDAO appuntiDAO){
        String titolo = request.getParameter("titolo");
        String materia = request.getParameter("materia");
        String testo = request.getParameter("testo");

        int flag = 0;
        System.out.println(appuntiDAO.isValidTitolo(titolo)+titolo);
        if(!appuntiDAO.isValidTitolo(titolo)) {
            request.setAttribute("errTitolo", "Titolo non valido");
            flag++;
        }
        if(!appuntiDAO.isValidMateria(materia)){
            request.setAttribute("errMateria", "Materia non valida");
            flag++;
        }
        if(!appuntiDAO.isValidTesto(testo)){
            request.setAttribute("errTesto", "Testo non valido");
            flag++;
        }
    }

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
        dao.doSave(appunti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RichiestaAppuntiInviata.jsp");
        dispatcher.forward(request,response);
    }

}