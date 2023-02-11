package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AppuntiBean;
import model.AppuntiDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listAppunti", value = "/listAppunti")
public class ListAppunti extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppuntiDAO action = new AppuntiDAO();
        ArrayList<AppuntiBean> list = new ArrayList<>();
        list= action.listAppuntiAdmin();
        String destPage="VisualizzaAppuntiAdmin.jsp";
        request.setAttribute("listAppunti", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
