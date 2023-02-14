package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RichiestaAppuntiTest {

    private AppuntiDAO dao = new AppuntiDAO();

    @Test
    public void TC_1_1_1() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("");
        appuntiBean.setTesto("hjdankas");
        appuntiBean.setMateria("Scientifico");
        Assertions.assertNull(dao.doSave(appuntiBean));
    }

    @Test
    public void TC_1_1_2() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("Napoleone");
        appuntiBean.setTesto("");
        appuntiBean.setMateria("Umanistica");
        Assertions.assertNull(dao.doSave(appuntiBean));
    }

    @Test
    public void TC_1_1_3() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("");
        appuntiBean.setTesto("");
        appuntiBean.setMateria("Scientifico");
        Assertions.assertNull(dao.doSave(appuntiBean));
    }

    @Test
    public void TC_1_1_4() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("");
        appuntiBean.setTesto("Psicologia");
        appuntiBean.setMateria("baksnksnalknsa");;
        Assertions.assertNull(dao.doSave(appuntiBean));
    }

    @Test
    public void TC_1_1_5() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("Napoleone");
        appuntiBean.setTesto("bdskjnslnls");
        appuntiBean.setMateria("Umanistica");
        Assertions.assertNotNull(dao.doSave(appuntiBean));
    }

}

