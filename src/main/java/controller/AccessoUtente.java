package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.UtenteBean;
import model.UtenteDAO;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/accesso-utente-servlet")
public class  AccessoUtente extends HttpServlet {

    /**
     * Implementa la funzionalità di accesso al sito.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UtenteDAO dao = new UtenteDAO();
        UtenteBean user = new UtenteBean();
        user = dao.doCheck(username,password);
        //verifica se l'utente è registrato oppure no
            if(user != null){
                if (user.isRuolo()==true){
                    /*Utente Admin*/
                        request.getSession().setAttribute("utenteLoggato", user);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaAdmin.jsp");
                        dispatcher.forward(request, response);

                }else{
                    /*Utente Studente*/
                    request.getSession().setAttribute("utenteLoggato", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaUtente.jsp");
                    dispatcher.forward(request, response);
                }
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("AccessoNonEffettuato.jsp");
                dispatcher.forward(request, response);
            }

    }

}
