package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RichiestaGSTest {

    private GSDAO dao = new GSDAO();


    @Test
    public void TC_1_2_1() throws Exception{
        GSBean gsBean = new GSBean();
        gsBean.setNome("PG-19/01/2023");
        gsBean.setMateria("informatica");
        gsBean.setLuogo("unisa");
        gsBean.setObbiettivi("");
        Assertions.assertNull(dao.doSave(gsBean));
    }

    @Test
    public void TC_1_2_2() throws Exception{
        GSBean gsBean = new GSBean();
        gsBean.setNome("PG-19/01/2023");
        gsBean.setMateria("");
        gsBean.setLuogo("unisa");
        gsBean.setObbiettivi("superare programmazione 1");
        Assertions.assertNull(dao.doSave(gsBean));
    }

    @Test
    public void TC_1_2_3() throws Exception{
        GSBean gsBean = new GSBean();
        gsBean.setNome("PG-19/01/2023");
        gsBean.setMateria("informatica");
        gsBean.setLuogo("unisa");
        gsBean.setObbiettivi("");
        Assertions.assertNull(dao.doSave(gsBean));
    }

    @Test
    public void TC_1_2_4() throws Exception{
        GSBean gsBean = new GSBean();
        gsBean.setNome("");
        gsBean.setMateria("informatica");
        gsBean.setLuogo("unisa");
        gsBean.setObbiettivi("superare programmazione 1");
        Assertions.assertNull(dao.doSave(gsBean));
    }

    @Test
    public void TC_1_2_5() throws Exception{
        GSBean gsBean = new GSBean();
        gsBean.setNome("PG-19/01/2023");
        gsBean.setMateria("informatica");
        gsBean.setLuogo("unisa");
        gsBean.setObbiettivi("superare programmazione 1");
        Assertions.assertNull(dao.doSave(gsBean));
    }

