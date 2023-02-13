package model;

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

    @Override
    public String paga(int importo) {
        FondiDAO dao = new FondiDAO();
        dao.doUpdate(importo);
        return "Grazie per aver donato "+importo+"€ con Carta Di Credito";
    }
}
