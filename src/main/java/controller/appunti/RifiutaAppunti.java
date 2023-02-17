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

@WebServlet(name="rifiuta-Appunti-servlet", value ="/rifiuta-Appunti-servlet")
public class RifiutaAppunti extends HttpServlet {
    /**
     * Tramite model elimina la richiesta di approvazione AppuntiBean
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //Elimina nel db il Appunti con nome == name(da input nella listAppunti accessibile solo da admin) e setta Stato a True
        AppuntiDAO dao = new AppuntiDAO();
        dao.doRemove(id);

        //Aggiorna il parametro AppuntiList per la jsp con il nuovo db aggiornato tramite listAppunti del dao
        ArrayList<AppuntiBean> AppuntiList;
        AppuntiList = dao.listAppuntiAdmin();
        request.setAttribute("listAppunti", AppuntiList);

        //Reindirizza alla pagina listAppunti con il db gruppistudio aggiornato
        String destPage="VisualizzaAppuntiAdmin.jsp"; //aggiornare con nome pagina lista dei Appunti in sezione admin
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
