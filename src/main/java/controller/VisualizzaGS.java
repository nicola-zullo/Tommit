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

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "visualizza-gs", value = "/visualizza-gs")
public class VisualizzaGS extends HttpServlet {

    /**
     * Tramite model fronisce un GruppoStudioBean dato un nome
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        System.out.println(nome);
        GSDAO action = new GSDAO();
        GSBean gs = action.retriveGS(nome);
        System.out.println(gs.getNome()+gs.getLuogo());
        String destPage="PaginaGSsingola.jsp";
        request.setAttribute("gruppo", gs);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}