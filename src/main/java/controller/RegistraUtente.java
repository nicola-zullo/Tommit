package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteBean;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="registrazione-utente-servlet", value ="/registrazione-utente-servlet")
public class RegistraUtente extends HttpServlet {

    /**
     * Tramite model processa la richiesta di Registrazione di un Utente
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String cf = request.getParameter("cf");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String confPassword = request.getParameter("confPassword");

            UtenteBean u = new UtenteBean();
            u.setName(name);
            u.setSurname(surname);
            u.setCF(cf);
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(password);
            u.setConfermaPass(confPassword);

            UtenteDAO utenteDAO = new UtenteDAO();

            u = utenteDAO.doSave(u);

        if (u == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrazioneNonEffettuata.jsp");
            dispatcher.forward(request, response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrazioneEffettuata.jsp");
            dispatcher.forward(request, response);
        }
    }

}
