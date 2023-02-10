package model;

public class GSBean {
    private String nome;
    private String materia;
    private String luogo;
    private String obiettivo;
    private boolean stato;

    public int getIdCreatore() { return idCreatore; }

    public void setIdCreatore(int idCreatore) { this.idCreatore = idCreatore;}

    private int idCreatore;

    public boolean getStato() { return stato; }

    public void setStato(boolean stato) { this.stato = stato; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getObiettivo() {
        return obiettivo;
    }

    public void setObiettivo(String obiettivo) {
        this.obiettivo = obiettivo;
    }


}
