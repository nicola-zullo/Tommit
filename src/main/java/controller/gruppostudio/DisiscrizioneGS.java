package controller.gruppostudio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.GSBean;
import model.dao.GSDAO;
import model.entity.UtenteBean;
import model.dao.UtentiGSDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="disiscrizione-gs", value ="/disiscrizione-gs")
public class DisiscrizioneGS extends HttpServlet {

    /**
     * Elimina un Utente da un Gruppo Studio
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UtenteBean u = (UtenteBean) request.getSession().getAttribute("utenteLoggato");
        int id_utente = u.getId();
        String nome_gs = request.getParameter("nome");//prendere da un hidden param nome grupposStudio

        UtentiGSDAO utentiGSDAO = new UtentiGSDAO();

        utentiGSDAO.doRemove(id_utente,nome_gs);

        //aggiorna la lista
        GSDAO action = new GSDAO();
        ArrayList<GSBean> list = new ArrayList<>();
        list= action.listGSIscritto(id_utente);
        String destPage="VisualizzaGSUtente.jsp";
        request.setAttribute("listGS", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}
