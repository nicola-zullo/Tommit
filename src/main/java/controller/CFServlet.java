package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="cf-servlet", value ="/cf-servlet")
public class CFServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String cf = request.getParameter("cf");
            UtenteDAO dao = new UtenteDAO();

            if (dao.controlloCF(cf)){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("true");
            }else {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("false");
            }

    }

}
