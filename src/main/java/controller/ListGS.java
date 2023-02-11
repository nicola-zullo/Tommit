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
import java.util.ArrayList;

@WebServlet(name = "listGS", value = "/listGS")
public class ListGS extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        list = action.listGSAccessibili();
        String destPage="PaginaGS.jsp";
        request.setAttribute("listGS", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }

}


