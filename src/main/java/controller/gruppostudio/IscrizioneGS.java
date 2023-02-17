package controller.gruppostudio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.GSDAO;
import model.entity.GSBean;
import model.entity.UtenteBean;
import model.dao.UtentiGSDAO;

import java.io.IOException;

@WebServlet(name="iscrizione-gs", value ="/iscrizione-gs")
public class IscrizioneGS extends HttpServlet {

    /**
     * Iscrive un Utente in un Gruppo Studio
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
        String url ="";
        GSDAO gsDao = new GSDAO();
        UtentiGSDAO utentiGSdao = new UtentiGSDAO();
        GSBean gs = gsDao.retriveGS(nome_gs);
        if(utentiGSdao.doCheck(id_utente,nome_gs)){
            String message="Sei già iscritto";
            request.setAttribute("message", message);
            request.setAttribute("currentGS", gs);
            url="PaginaGSsingola.jsp";
        }else{
            utentiGSdao.doSave(id_utente,nome_gs);
            url="IscrizioneGSAvvenuta.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

}