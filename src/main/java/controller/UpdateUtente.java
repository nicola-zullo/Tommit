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
import java.sql.SQLException;

@WebServlet(name="update-utente-servlet", value ="/update-utente-servlet")
    public class UpdateUtente extends HttpServlet {

    /**
     * Tramite model aggiorna i dati Utente
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //prendo i dati utente MODIFICATI
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String cf = request.getParameter("cf");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("id"));

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
            try {
                user = dao.ricercaId(user.getId());
                System.out.print(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.getSession().setAttribute("utenteLoggato", user);
            //redirect alla PaginaUtente con i dati aggiornati
            RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaUtente.jsp");
            dispatcher.forward(request,response);

        }

}
