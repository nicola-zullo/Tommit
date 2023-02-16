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

/**
 * Tramite model fornisce una lista di Gruppi Studio data una categoria
 */
@WebServlet(name = "listGSCategory", value = "/listGSCategory")
public class ListaGSByCategory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String materia = request.getParameter("category");
        System.out.print(materia);
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        list = action.listGSByMateria(materia,u.getId());
        String destPage="PaginaGS.jsp";
        request.setAttribute("listaGS", list);
        System.out.println("//////////Servlet categoria/////////");
        System.out.println(list.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
