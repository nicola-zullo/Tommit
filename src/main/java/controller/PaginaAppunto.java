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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "pagina-appunto-servlet", value = "/pagina-appunto-servlet")

public class PaginaAppunto extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AppuntiDAO action = new AppuntiDAO();
        AppuntiBean appunto = new AppuntiBean();
        try {
            appunto = action.ricercaId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String destPage="PaginaAppuntoSingola.jsp";
        request.setAttribute("currentAppunto", appunto);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
