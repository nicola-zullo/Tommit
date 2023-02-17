package model.entity.pagamento;

public interface Pagamento {

    /**
     * Interfaccia comune di Pagamento
     * @param importo
     * @return
     */

    public String paga(int importo);

}
