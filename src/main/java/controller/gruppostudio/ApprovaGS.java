package controller.gruppostudio;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.GSBean;
import model.dao.GSDAO;
import model.dao.UtentiGSDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="approva-gs-servlet", value ="/approva-gs-servlet")
public class ApprovaGS extends HttpServlet {

    /**
     * Implementa la funzionalità di approvazione di Gruppi Studio da parte di un Admin
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        //Trova nel db il GS con nome == name(da input nella listGS accessibile solo da admin) e setta Stato a True
        GSDAO dao = new GSDAO();
        dao.setTrue(name);

        GSBean gsBean = new GSBean();
        gsBean = dao.retriveGS(name);

        UtentiGSDAO gsdao = new UtentiGSDAO();
        gsdao.doSave(gsBean.getIdCreatore(),gsBean.getNome());

        //Aggiorna il parametro gsList per la jsp con il nuovo db aggiornato tramite listGS del dao
        ArrayList<GSBean> gsList;
        gsList= dao.listGS();
        request.setAttribute("listGS", gsList);

        //Reindirizza alla pagina listGS con il db gruppistudio aggiornato
        String destPage="VisualizzaGSAdmin.jsp"; //aggiornare con nome pagina lista dei gs in sezione admin
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
