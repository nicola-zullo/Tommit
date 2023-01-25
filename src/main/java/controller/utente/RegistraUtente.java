package controller.utente;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("nome");
        String surname = request.getParameter("cognome");
        String cf = request.getParameter("cf");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteBean u = new UtenteBean();

        u.setName(name);
        u.setSurname(surname);
        u.setEmail(email);
        u.setCF(cf);
        u.setUsername(username);
        u.setPassword(password);

        UtenteDAO utenteDAO = new UtenteDAO();

        utenteDAO.doSave(u);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request,response);

    }

}
