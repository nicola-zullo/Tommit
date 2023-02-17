package controller.appunti;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.AppuntiBean;
import model.dao.AppuntiDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listAppunti", value = "/listAppunti")
public class ListAppunti extends HttpServlet {

    /**
     * Tramite model fornisce una lista di tutti gli appunti presenti nel database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppuntiDAO action = new AppuntiDAO();
        ArrayList<AppuntiBean> list = new ArrayList<>();
        list= action.listAppuntiAdmin();
        System.out.println(list.toString());
        String destPage="VisualizzaAppuntiAdmin.jsp";
        request.setAttribute("listAppunti", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
