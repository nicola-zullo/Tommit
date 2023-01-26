package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GSBean;
import model.GSDAO;
import model.UtenteBean;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="richiesta-creazione-gs-servlet", value ="/richiesta-creazione-gs-servlet")
public class RichiestaGS extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String materia = request.getParameter("materia");
        String luogo = request.getParameter("luogo");
        String obiettivo = request.getParameter("obettivi");

        GSBean gs= new GSBean();
        gs.setNome(nome);
        gs.setMateria(materia);
        gs.setLuogo(luogo);
        gs.setObiettivo(obiettivo);
        gs.setStato(false);

        GSDAO dao = new GSDAO();
        dao.doSave(gs);
    }

}

