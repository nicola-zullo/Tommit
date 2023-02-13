package model;

public class PayPalStrategy implements PagamentoStrategy {

    private String emailId;
    private String password;

    public PayPalStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }


    @Override
    public String paga(int importo) {
        return "Grazie per aver pagato "+importo+" con PayPal";
    }
}