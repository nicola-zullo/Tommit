package model;

public class RaccoltaFondi {

    int fondiRicevuti;

    public RaccoltaFondi() {

        this.fondiRicevuti = 0;
    }

    public int getFondiRicevuti() {
        return fondiRicevuti;
    }

    public void setFondiRicevuti(
            int fondiRicevuti) {
        this.fondiRicevuti = fondiRicevuti;
    }

    public String riceviFondi(Pagamento paymenthMethod, int amount){
        setFondiRicevuti(amount);
        return paymenthMethod.paga(amount);
    }

}
