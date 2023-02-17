package controller.appunti;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.AppuntiDAO;
import model.dao.UtentiAppuntiDAO;
import model.entity.AppuntiBean;
import model.entity.UtenteBean;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="elimina-appunti-utente", value ="/elimina-appunti-utente")
public class EliminaAppuntiUtente extends HttpServlet {

    /**
     * Elimina un Appunto dalla lista degli appunti salvati di un utente
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        int id_utente = u.getId();
        int id_appunti = Integer.parseInt(request.getParameter("idAppunti"));//prendere un param id Appunti

        UtentiAppuntiDAO dao = new UtentiAppuntiDAO();

        dao.doRemove(id_utente,id_appunti);

        //aggiorna la lista
        AppuntiDAO action = new AppuntiDAO();
        ArrayList<AppuntiBean> list = new ArrayList<>();
        list= action.listAppuntiSalvati(id_utente);
        String destPage="visualizzaAppuntiUtente.jsp";
        request.setAttribute("listAppunti", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}
