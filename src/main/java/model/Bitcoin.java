package model;

public class Bitcoin implements Pagamento {

    /**
     * Indrizzo di provenienza dei BTC
     */
    private String walletAddress;

    public Bitcoin(String walletAddress) {
        this.walletAddress = walletAddress;
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
        return "Grazie per aver donato "+importo+"BTC con Bitcoin";
    }
}
