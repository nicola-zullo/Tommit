package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtenteDAO;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listUser", value = "/listUser")
public class ListUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDAO action = new UtenteDAO();
        ArrayList<UtenteBean> userList = new ArrayList<>();
        userList= action.listUser();
        String destPage="visualizzaUtenti.jsp";
        request.setAttribute("listaUtenti", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}