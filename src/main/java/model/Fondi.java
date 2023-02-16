package model;

public class Fondi {

    /**
     * Classe che tramite il pattern Facade gestisce i vari metodo di pagamento
     */

    private CartaDICredito carta;
    private PayPal paypal;
    private Bitcoin bitcoin;

    public Fondi() {
    }

    /**
     * Tramite pattern facade gestisce pagamento con Carta di credito
     * @param nome
     * @param ccNum
     * @param cvv
     * @param scadenza
     * @param importo
     * @return
     */
    public String pagaCarta(String nome, String ccNum, String cvv, String scadenza,int importo){
        carta = new CartaDICredito(nome, ccNum, cvv, scadenza);
        return carta.paga(importo);
    }

    /**
     * Tramite pattern facade gestisce pagamento con Carta di PayPal
     * @param email
     * @param password
     * @param importo
     * @return
     */
    public String pagaPayPal(String email,String password,int importo){
        paypal = new PayPal(email,password);
        return paypal.paga(importo);
    }

    /**
     * Tramite pattern facade gestisce pagamento con Bitcoin
     * @param wallet
     * @param importo
     * @return
     */
    public String pagaBitcoin(String wallet,int importo){
        bitcoin = new Bitcoin(wallet);
        return bitcoin.paga(importo);
    }

}
