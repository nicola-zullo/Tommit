package model;

public class PayPal implements Pagamento {

    private String emailId;
    private String password;

    public PayPal(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }


    @Override
    public String paga(int importo) {
        FondiDAO dao = new FondiDAO();
        dao.doUpdate(importo);
        return "Grazie per aver donato "+importo+"€ con PayPal";
    }
}