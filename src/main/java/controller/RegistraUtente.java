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

            utenteDAO.doSave(u);


        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

        dispatcher.forward(request,response);

    }

}
