package controller.gruppostudio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.GSBean;
import model.dao.GSDAO;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listGSAdmin", value = "/listGSAdmin")
public class ListGSAdmin extends HttpServlet {
    /**
     * Tramite model fornisce una lista di Gruppi Studio da approvare
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        list = action.listGS();
        String destPage="VisualizzaGSAdmin.jsp";
        request.setAttribute("listGS", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}