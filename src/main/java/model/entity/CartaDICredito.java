package model.entity;

import model.dao.FondiDAO;
import model.entity.pagamento.Pagamento;

public class CartaDICredito implements Pagamento {

    private String nome;
    private String numeroCarta;
    private String cvv;
    private String dataDiScadenza;

    public CartaDICredito(String nome, String ccNum, String cvv, String scadenza){
        this.nome=nome;
        this.numeroCarta=ccNum;
        this.cvv=cvv;
        this.dataDiScadenza=scadenza;
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
        return "Grazie per aver donato "+importo+"€ con Carta Di Credito";
    }
}
