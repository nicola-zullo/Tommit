package controller.appunti;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.AppuntiBean;
import model.dao.AppuntiDAO;
import model.entity.UtenteBean;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listAppuntiCategory", value = "/listAppuntiCategory")

public class ListaAppuntiByCategory extends HttpServlet {

    /**
     * Tramite model fornisce una lista di appunti data una materia
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String materia = request.getParameter("category");
        System.out.print(materia);
        AppuntiDAO action = new AppuntiDAO();
        ArrayList<AppuntiBean> list = new ArrayList<>();
        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        int userId = u.getId();
        list= action.listAppuntiByMateria(materia,userId);
        String destPage="PaginaAppuntiCategoria.jsp";
        request.setAttribute("listAppunti", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
