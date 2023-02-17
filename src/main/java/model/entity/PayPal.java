package model.entity;

import model.dao.FondiDAO;
import model.entity.Pagamento;

public class PayPal implements Pagamento {

    private String emailId;
    private String password;

    public PayPal(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    /**
     * Metodo implementato da Pagamento
     * @param importo
     * @return ritorna una string di avvenuto oagamento
     */
    @Override
    public String paga(int importo) {
        FondiDAO dao = new FondiDAO();
        dao.doUpdate(importo);
        return "Grazie per aver donato "+importo+"€ con PayPal";
    }
}