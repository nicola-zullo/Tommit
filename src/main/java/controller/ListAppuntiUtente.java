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
import java.util.ArrayList;

@WebServlet(name = "listUserAppunti", value = "/listUserAppunti")
public class ListAppuntiUtente extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= ((UtenteBean)request.getSession().getAttribute("utenteLoggato")).getId();
        AppuntiDAO action = new AppuntiDAO();
        ArrayList<AppuntiBean> list = new ArrayList<>();
        list= action.listUserAppunti(id);
        String destPage="visualizzaAppuntiUtente.jsp";
        request.setAttribute("listAppunti", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}