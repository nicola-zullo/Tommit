package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTest {

    private UtenteDAO dao = new UtenteDAO();

    @Test
    public void TC_1_4_1() throws Exception{
        UtenteBean u = new UtenteBean();
        String email = "TEST_1_4_1_UN_Sbagliato";
        String password ="Test_PW_Corretta";
        Assertions.assertNull(dao.doCheck(email,password));
    }
    @Test
    public void TC_1_4_2() throws Exception{
        UtenteBean u = new UtenteBean();
        String email = "TEST_1_4_1_UN_Corretto";
        String password ="Test_PW_Sbagliata";
        Assertions.assertNull(dao.doCheck(email,password));
    }

    @Test
    public void TC_1_4_3() throws Exception{
        UtenteBean u = new UtenteBean();
        String email = "TEST_1_4_1_UN_Corretto";
        String password ="Test_PW_Corretta";
        Assertions.assertNotNull(dao.doCheck(email,password));
    }
}
