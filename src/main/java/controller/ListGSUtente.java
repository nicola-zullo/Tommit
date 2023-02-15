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

@WebServlet(name = "listUserGS", value = "/listUserGS")
public class ListGSUtente extends HttpServlet {
    /**
     * Tramite model fornisce una lista di Gruppi Studio a cui si fa parte
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= ((UtenteBean)request.getSession().getAttribute("utenteLoggato")).getId();
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        list= action.listUserGS(id);
        String destPage="VisualizzaGSUtente.jsp";
        request.setAttribute("listGS", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}