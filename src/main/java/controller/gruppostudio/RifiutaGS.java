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

@WebServlet(name="rifiuta-gs-servlet", value ="/rifiuta-gs-servlet")
public class RifiutaGS extends HttpServlet {

    /**
     * Tramite model elimina la richiesta di approvazione Gruppo Studio
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        //Elimina nel db il GS con nome == name(da input nella listGS accessibile solo da admin) e setta Stato a True
        GSDAO dao = new GSDAO();
        dao.doRemove(name);

        //Aggiorna il parametro gsList per la jsp con il nuovo db aggiornato tramite listGS del dao
        ArrayList<GSBean> gsList;
        gsList = dao.listGS();
        request.setAttribute("listGS", gsList);

        //Reindirizza alla pagina listGS con il db gruppistudio aggiornato
        String destPage="VisualizzaGSAdmin.jsp"; //aggiornare con nome pagina lista dei gs in sezione admin
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
