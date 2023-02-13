package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name="donazione", value ="/donazione")
public class Donazione extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RaccoltaFondi raccoltaFondi = new RaccoltaFondi();

        String ritorno = "Errore nel pagamento";

        if (request.getParameter("metodoPagamento").equalsIgnoreCase("cartadicredito")){
            ritorno = raccoltaFondi.riceviFondi(new CartaDICreditoStrategy(request.getParameter("nome"),request.getParameter("ccNum"),request.getParameter("cvv"),request.getParameter("scadenza")), Integer.parseInt(request.getParameter("amount")));
        }else if (request.getParameter("metodoPagamento").equalsIgnoreCase("paypal")){
            ritorno = raccoltaFondi.riceviFondi(new PayPalStrategy(request.getParameter("email"),request.getParameter("password")), Integer.parseInt(request.getParameter("amount")));
        }else if (request.getParameter("metodoPagamento").equalsIgnoreCase("bitcoin")){
            ritorno = raccoltaFondi.riceviFondi(new BitcoinStrategy(request.getParameter("wallet")), Integer.parseInt(request.getParameter("amount")));
        }
        request.setAttribute("ritornoPagamento",ritorno);
        //Reindirizza alla pagina donazione avvenuta con successo
        String destPage="DonazioneEffettuata.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
    }
}
