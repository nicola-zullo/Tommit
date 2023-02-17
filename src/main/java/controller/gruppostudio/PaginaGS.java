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

@WebServlet(name = "pagina-gs-servlet", value = "/pagina-gs-servlet")

public class PaginaGS extends HttpServlet {

    /**
     * Tramite model fornisce una Gruppo Studio fornito un nome
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        GSDAO action = new GSDAO();
        GSBean gs = new GSBean();
        gs = action.retriveGS(nome);
        String destPage="PaginaGSsingola.jsp";
        request.setAttribute("currentGS", gs);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
