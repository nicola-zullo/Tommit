package model;

public class UtenteBean {

    private int id;
    private String CF;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String confermaPass;
    private boolean ruolo;

    public UtenteBean() {
        this.ruolo=false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRuolo() {
        return ruolo;
    }

    public void setRuolo(boolean x){
        this.ruolo=x;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfermaPass() {
        return confermaPass;
    }

    public void setConfermaPass(String confermaPass) {
        this.confermaPass = confermaPass;
    }

    public String getCF(){ return CF; }

    public void setCF (String CF){ this.CF = CF;}

    /**
     * Controlla se la lunghezza di una stringa è maggiore di un numero intero
     * @param str
     * @param x
     * @return
     */
    public boolean controlloLunghezzaStringa(String str,int x){
        if (str.length()>x)
            return false;
        return true;
    }

    /**
     * Controlla se il nome e il cognome sono maggiori di 50, se la password è maggiore di 16,se è stata inserita una email e se le passwrd coincidono. In caso contrario restituisce false
     * @param utente
     * @return
     */
    public boolean controlliRegistrazione(UtenteBean utente){
        if(!utente.controlloLunghezzaStringa(utente.getName(),50))
            return false;
        if(!utente.controlloLunghezzaStringa(utente.getSurname(),50))
            return false;
        if(!utente.controlloLunghezzaStringa(utente.getPassword(),16))
            return false;
        if (utente == null)
            return false;
        if (!utente.getPassword().equals(utente.getConfermaPass()))
            return false;
        if (!utente.getEmail().contains("@"))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                "CF=" + CF +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
