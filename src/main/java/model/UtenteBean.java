package model;

public class UtenteBean {

    private int id;
    private String CF;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean ruolo;

    public UtenteBean() {
        this.ruolo=false;
    }

    public void setRuolo(boolean x){
        this.ruolo=x;
    }

    public boolean getRuolo(){
        return ruolo;
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



    public String getCF(){ return CF;}

        public void setCF (String CF){this.CF = CF;}

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
