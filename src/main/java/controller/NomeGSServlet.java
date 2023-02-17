package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GSDAO;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name="nome-gs-servlet", value ="/nome-gs-servlet")
public class NomeGSServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String username = request.getParameter("nome");
            GSDAO dao = new GSDAO();

            if (dao.controlloNomeGS(username)){
                System.out.println("Username:"+username+" gia presente");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("true");
            }else {
                System.out.println("Username:"+username+" non presente");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("false");
            }

    }

}
