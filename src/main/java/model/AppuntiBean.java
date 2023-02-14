package model;

public class AppuntiBean {

    int id;
    String titolo;
    String testo;
    String materia;
    int idUtente;//utente che li ha creati
    boolean stato;

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }



    public AppuntiBean() {
    }

    public AppuntiBean(String titolo, String testo, String materia) {
        this.titolo = titolo;
        this.testo = testo;
        this.materia = materia;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    public boolean controlloLunghezzaStringa(String str){
        if (str.length()<=0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AppuntiBean{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", materia='" + materia + '\'' +
                ", idUtente=" + idUtente +
                ", stato=" + stato +
                '}';
    }
}
