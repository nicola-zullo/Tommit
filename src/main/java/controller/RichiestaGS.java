package controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GSBean;
import model.GSDAO;

import java.io.IOException;

@WebServlet(name="richiesta-creazione-gs-servlet", value ="/richiesta-creazione-gs-servlet")
public class RichiestaGS extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String materia = request.getParameter("categorie");
        String luogo = request.getParameter("luogo");
        String obiettivo = request.getParameter("obiettivi");
        int id= Integer.parseInt(request.getParameter("id"));
        GSBean gs= new GSBean();
        gs.setNome(nome);
        gs.setMateria(materia);
        gs.setLuogo(luogo);
        gs.setObiettivo(obiettivo);
        gs.setStato(false);
        gs.setIdCreatore(id);
        System.out.print(gs.toString());
        GSDAO dao = new GSDAO();
        dao.doSave(gs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("RichiestaGSInviata.jsp");
        dispatcher.forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}

