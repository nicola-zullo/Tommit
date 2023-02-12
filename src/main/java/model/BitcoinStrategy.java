package model;

public class BitcoinStrategy implements PagamentoStrategy {

    private String walletAddress;

    public BitcoinStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }


    @Override
    public String paga(int importo) {
        return "Grazie per aver pagato "+importo+" con Bitcoin";
    }
}
