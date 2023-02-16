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

@WebServlet(name = "list-GS", value = "/list-GS")
public class ListGS extends HttpServlet {

    /**
     * Tramite model fornisce una lista di Gruppi Studio
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        list = action.listGSAccessibili(u.getId());
        System.out.print(list.toString());
        String destPage="PaginaGS.jsp";
        request.setAttribute("listaGS", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }

}


