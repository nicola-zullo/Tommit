package model;

public class GSBean {
    private String nome;
    private String materia;
    private String luogo;
    private String obiettivo;
    private boolean stato;
    private int idCreatore;


    public int getIdCreatore() { return idCreatore; }

    public void setIdCreatore(int idCreatore) { this.idCreatore = idCreatore;}

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

    public boolean controlliRichiesta(GSBean gsBean) {

        if (gsBean.getNome() == "" || gsBean.getNome() == null)
            return false;
        if (gsBean.getObiettivo() == "" || gsBean.getObiettivo() == null)
            return false;
        if (gsBean.getLuogo() == "" || gsBean.getLuogo() == null)
            return false;
        if (!(gsBean.getMateria().equalsIgnoreCase("umanistica") || gsBean.getMateria().equalsIgnoreCase("scientifico") || gsBean.getMateria().equalsIgnoreCase("artistica") || gsBean.getMateria().equalsIgnoreCase("informatica") || gsBean.getMateria().equalsIgnoreCase("lingue") || gsBean.getMateria().equalsIgnoreCase("sanitario")))
            return false;


        return true;
    }

    @Override
    public String toString() {
        return "GSBean{" +
                "nome='" + nome + '\'' +
                ", materia='" + materia + '\'' +
                ", luogo='" + luogo + '\'' +
                ", obiettivo='" + obiettivo + '\'' +
                ", stato=" + stato +
                ", idCreatore=" + idCreatore +
                '}';
    }
}
