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

@WebServlet(name="approva-appunti-servlet", value ="/approva-appunti-servlet")
public class ApprovaAppunti extends HttpServlet {

    /**
     * Implementa la funzionalità di approvazione di Appuntin da parte di un Admin
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAppunti = Integer.parseInt(request.getParameter("id"));
        //Trova nel db gli appunti con id == id(da input nella listAppunti accessibile solo da admin) e setta Stato a True
        AppuntiDAO dao = new AppuntiDAO();
        dao.setTrue(idAppunti);

        //Aggiorna il parametro gsList per la jsp con il nuovo db aggiornato tramite listGS del dao
        ArrayList<AppuntiBean> appuntiList;
        appuntiList= dao.listAppuntiAdmin();
        request.setAttribute("listAppunti", appuntiList);

        //Reindirizza alla pagina listGS con il db gruppistudio aggiornato
        String destPage="VisualizzaAppuntiAdmin.jsp"; //aggiornare con nome pagina lista dei gs in sezione admin
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
