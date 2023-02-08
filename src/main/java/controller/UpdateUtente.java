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

    @WebServlet(name="update-utente-servlet", value ="/update-utente-servlet")
    public class UpdateUtente extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //prendo i dati utente MODIFICATI
            String name = request.getParameter("nome");
            String surname = request.getParameter("cognome");
            String cf = request.getParameter("cf");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("idUtente"));

            // inizializzo user con i dat di pagina utente MODIFICATI
            UtenteBean user = new UtenteBean();
            user.setId(id);
            user.setName(name);
            user.setSurname(surname);
            user.setCF(cf);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            //salvo nel db i dati MODIFICATI in base a ID (vedi doUpdate in UtenteDAO)
            UtenteDAO dao = new UtenteDAO();
            dao.doUpdate(user);

            //redirect alla PaginaUtente con i dati aggiornati
            RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaUtente.jsp");
            dispatcher.forward(request,response);

        }

}
