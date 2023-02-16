package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="email-servlet", value ="/email-servlet")
public class EmailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String email = request.getParameter("email");
            UtenteDAO utenteDAO = new UtenteDAO();

            if (utenteDAO.controlloEmail(email)){
                System.out.println("Email:"+email+" gia presente");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("true");
            }else {
                System.out.println("Email:"+email+" non presente");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("false");
            }

    }

}
