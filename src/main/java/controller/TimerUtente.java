package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TimerBean;
import model.TimerDAO;
import model.UtenteBean;
import model.UtenteDAO;

import java.io.IOException;
import java.sql.Time;

@WebServlet(urlPatterns = "/salva-timer")
public class TimerUtente extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("nome");
        int session = Integer.parseInt(request.getParameter("session"));
        int breakTime = Integer.parseInt(request.getParameter("break"));

        TimerBean timerBean = new TimerBean();

        timerBean.setName(name);
        timerBean.setSessionTime(session);
        timerBean.setBreakTime(breakTime);
        int idUtente = ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).getId();
        timerBean.setUtenteId(idUtente);

        TimerDAO timerDAO = new TimerDAO();

        timerDAO.doSave(timerBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

        dispatcher.forward(request,response);

    }

}
