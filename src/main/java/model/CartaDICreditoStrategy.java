package model;

public class CartaDICreditoStrategy implements PagamentoStrategy{

    private String nome;
    private String numeroCarta;
    private String cvv;
    private String dataDiScadenza;

    public CartaDICreditoStrategy (String nome, String ccNum, String cvv, String scadenza){
        this.nome=nome;
        this.numeroCarta=ccNum;
        this.cvv=cvv;
        this.dataDiScadenza=scadenza;
    }

    @Override
    public String paga(int importo) {
        return "Grazie per aver pagato "+importo+" con Carta Di Credito";
    }
}
