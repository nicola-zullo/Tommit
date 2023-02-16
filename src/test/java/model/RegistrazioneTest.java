package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrazioneTest {

    private UtenteDAO dao = new UtenteDAO();

    @Test
    public void TC_1_3_1() throws Exception{
        UtenteBean utente = new UtenteBean();
        utente.setName("Giuseppeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        utente.setSurname("Rossi");
        utente.setCF("GSPRSS96F349W");
        utente.setUsername("giuseppeR");
        utente.setEmail("giuseppeR@gmail.com");
        utente.setPassword("rossiP96!");
        utente.setConfermaPass("rossiP96!");

        Assertions.assertNull(dao.doSave(utente));
    }

    @Test
    public void TC_1_3_2() throws Exception{
        UtenteBean utente = new UtenteBean();
        utente.setName("Giuseppe");
        utente.setSurname("Rossiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        utente.setCF("GSPRSS96F349W");
        utente.setUsername("giuseppeR");
        utente.setEmail("giuseppeR@gmail.com");
        utente.setPassword("rossiP96!123456789123456");
        utente.setConfermaPass("rossiP96!");

        Assertions.assertNull(dao.doSave(utente));
    }

    @Test
    public void TC_1_3_3() throws Exception{
        UtenteBean utente = new UtenteBean();
        utente.setName("Giuseppe");
        utente.setSurname("Rossi");
        utente.setCF("GSPRSS96F349W");
        utente.setUsername("giuseppeR");
        utente.setEmail("giuseppeR@gmail.com");
        utente.setPassword("rossiP96!");
        utente.setConfermaPass("rossiP96!12345");

        Assertions.assertNull(dao.doSave(utente));
    }

    @Test
    public void TC_1_3_4() throws Exception{
        UtenteBean utente = new UtenteBean();
        utente.setName("Giuseppe");
        utente.setSurname("Rossi");
        utente.setCF("GSPRSS96F349W");
        utente.setUsername("giuseppeR");
        utente.setEmail("giuseppeRgmail.com");
        utente.setPassword("rossiP96!");
        utente.setConfermaPass("rossiP96!");

        Assertions.assertNull(dao.doSave(utente));
    }

    @Test
    public void TC_1_3_5() throws Exception{
        UtenteBean utente = new UtenteBean();
        utente.setName("Giuseppe");
        utente.setSurname("Rossi");
        utente.setCF("GSPRSS96F349W");
        utente.setUsername("giuseppeR");
        utente.setEmail("giuseppeR@gmail.com");
        utente.setPassword("rossiP96!");
        utente.setConfermaPass("rossiP96!");

        Assertions.assertNotNull(dao.doSave(utente));
    }

}
