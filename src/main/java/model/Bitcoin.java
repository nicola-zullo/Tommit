package model;

public class Bitcoin implements Pagamento {

    private String walletAddress;

    public Bitcoin(String walletAddress) {
        this.walletAddress = walletAddress;
    }


    @Override
    public String paga(int importo) {
        FondiDAO dao = new FondiDAO();
        dao.doUpdate(importo);
        return "Grazie per aver donato "+importo+"BTC con Bitcoin";
    }
}
