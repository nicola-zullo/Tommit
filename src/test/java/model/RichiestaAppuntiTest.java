package model;

import model.dao.AppuntiDAO;
import model.entity.AppuntiBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RichiestaAppuntiTest {

    private AppuntiDAO dao = new AppuntiDAO();

    @Test
    public void TC_1_1_1() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("");
        appuntiBean.setTesto("Napoleone Bonaparte, spesso chiamato per antonomasia anche solo Napoleone (Ajaccio, " +
                "15 agosto 1769[1] – Longwood, Isola di Sant'Elena, 5 maggio 1821), è stato un politico " +
                "e generale francese, fondatore del Primo Impero francese e protagonista della prima fase " +
                "della storia contemporanea europea, detta 'età napoleonica'.");

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
        appuntiBean.setTitolo("Napoleone");
        appuntiBean.setTesto("Napoleone Bonaparte, spesso chiamato per antonomasia anche solo Napoleone " +
                "(Ajaccio, 15 agosto 1769[1] – Longwood, Isola di Sant'Elena, 5 maggio 1821), " +
                "è stato un politico e generale francese, fondatore del Primo Impero francese e protagonista " +
                "della prima fase della storia contemporanea europea, detta 'età napoleonica'.");
        appuntiBean.setMateria("Letteratura");;
        Assertions.assertNull(dao.doSave(appuntiBean));
    }

    @Test
    public void TC_1_1_5() throws Exception{
        AppuntiBean appuntiBean = new AppuntiBean();
        appuntiBean.setTitolo("Napoleone");
        appuntiBean.setTesto("Napoleone Bonaparte, spesso chiamato per antonomasia anche solo Napoleone " +
                        "(Ajaccio, 15 agosto 1769[1] – Longwood, Isola di Sant'Elena, 5 maggio 1821), " +
                        "è stato un politico e generale francese, fondatore del Primo Impero francese e " +
                        "protagonista della prima fase della storia contemporanea europea, detta 'età napoleonica'.");
        appuntiBean.setMateria("Umanistica");
        Assertions.assertNotNull(dao.doSave(appuntiBean));
    }

}

