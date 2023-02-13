package model;

public class Fondi {

    //utilizza il modello facade per gestire i pagamenti

    private CartaDICredito carta;
    private PayPal paypal;
    private Bitcoin bitcoin;

    public Fondi() {
    }

    public String pagaCarta(String nome, String ccNum, String cvv, String scadenza,int importo){
        carta = new CartaDICredito(nome, ccNum, cvv, scadenza);
        return carta.paga(importo);
    }

    public String pagaPayPal(String email,String password,int importo){
        paypal = new PayPal(email,password);
        return paypal.paga(importo);
    }

    public String pagaBitcoin(String wallet,int importo){
        bitcoin = new Bitcoin(wallet);
        return bitcoin.paga(importo);
    }

}
