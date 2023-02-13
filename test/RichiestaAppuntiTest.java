import controller.RichiestaAppunti;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AppuntiDAO;
import org.apache.shale.test.mock.MockHttpServletRequest;
import org.apache.shale.test.mock.MockHttpServletResponse;
import org.apache.shale.test.mock.MockHttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RichiestaAppuntiTest {

    MockHttpServletRequest request;
    MockHttpServletResponse response;
    RichiestaAppunti richiesta;
    AppuntiDAO appuntiDAO;
    MockHttpSession session;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        richiesta = new RichiestaAppunti();
        appuntiDAO = Mockito.mock(AppuntiDAO.class);
        session = new MockHttpSession();
    }

    @Test
    public void TitoloNonInseritoTest() {
        String titolo = ""; //non corretto
        String materia = "Umanistica"; //corretto
        String testo = "wjwabdibsld"; //corretto

        setParametersRequest(titolo, materia, testo);

        Mockito.when(appuntiDAO.isValidTitolo(titolo)).thenReturn(false);
        Mockito.when(appuntiDAO.isValidMateria(materia)).thenReturn(true);
        Mockito.when(appuntiDAO.isValidTesto(testo)).thenReturn(true);
        richiesta.richiesta((HttpServletRequest) request, (HttpServletResponse) response, appuntiDAO);
        assertParametersRequest(titolo, materia, testo);
        assertEquals("Titolo non valido", request.getAttribute("errTitolo"));
    }

    private void assertParametersRequest(String titolo, String materia, String testo) {
        assertEquals(titolo,request.getAttribute("titolo"));
        assertEquals(materia, request.getAttribute("materia"));
        assertEquals(testo, request.getAttribute("testo"));
    }

    private void setParametersRequest(String titolo, String materia, String testo) {
        request.addParameter("titolo", titolo);
        request.addParameter("materia", materia);
        request.addParameter("testo", testo);
    }
}

