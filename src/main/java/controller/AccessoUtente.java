package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConPool;
import model.UtenteBean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/accesso-utente-servlet")
public class AccessoUtente extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //verifica se l'utente è registrato oppure no
        try (Connection con = ConPool.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE Username = '"+username+"' AND Password = '"+password + "'");
            if(rs.next()){
                if (rs.getBoolean(7)==true){
                    /*Utente Admin*/
                        UtenteBean utenteLoggato = new UtenteBean();
                        utenteLoggato.setId(rs.getInt(1));
                        utenteLoggato.setUsername(rs.getString(2));
                        utenteLoggato.setName(rs.getString(3));
                        utenteLoggato.setSurname(rs.getString(4));
                        utenteLoggato.setEmail(rs.getString(5));
                        utenteLoggato.setPassword(rs.getString(6));
                        utenteLoggato.setRuolo(true);
                        request.getSession().setAttribute("utenteLoggato", utenteLoggato);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaAdmin.jsp");
                        dispatcher.forward(request, response);
                    /*Utente Admin*/
                }else{
                    UtenteBean utenteLoggato = new UtenteBean();
                    utenteLoggato.setId(rs.getInt(1));
                    utenteLoggato.setName(rs.getString(2));
                    utenteLoggato.setSurname(rs.getString(3));
                    utenteLoggato.setEmail(rs.getString(4));
                    utenteLoggato.setPassword(rs.getString(5));
                    request.getSession().setAttribute("utenteLoggato", utenteLoggato);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("PaginaUtente.jsp");
                    dispatcher.forward(request, response);
                }
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
