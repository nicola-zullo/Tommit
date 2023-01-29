package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AppuntiBean;
import model.AppuntiDAO;
import model.GSBean;
import model.GSDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="approva-appunti-servlet", value ="/approva-appunti-servlet")
public class ApprovaAppunti extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAppunti = Integer.parseInt(request.getParameter("idAppunti"));
        //Trova nel db gli appunti con id == id(da input nella listAppunti accessibile solo da admin) e setta Stato a True
        AppuntiDAO dao = new AppuntiDAO();
        dao.setTrue(idAppunti);

        //Aggiorna il parametro gsList per la jsp con il nuovo db aggiornato tramite listGS del dao
        ArrayList<AppuntiBean> appuntiList;
        appuntiList= dao.listAppunti();
        request.setAttribute("appuntiList", appuntiList);

        //Reindirizza alla pagina listGS con il db gruppistudio aggiornato
        String destPage="listApunti.jsp"; //aggiornare con nome pagina lista dei gs in sezione admin
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
