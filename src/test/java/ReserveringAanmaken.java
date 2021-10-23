import org.junit.jupiter.api.*;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.DagdeelEnum;
import reserveringsysteem.reservering.domain.Reservering;
import reserveringsysteem.reservering.domain.ReserveringRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReserveringAanmaken {

    static ReserveringRepository rep;
    static ReserveringApplicationService app;
    static ReserveringRESTService rest;

    @BeforeAll
    public static void setUp(){
        rep = new ReserveringRepository();
        app = new ReserveringApplicationService(rep);
        rest = new ReserveringRESTService(app);
    }

    //Maak een reservering aan. De functie moet true terug geven
    @Test
    @Order(1)
    public void testAanmaken() throws ParseException {
        Assertions.assertEquals(true, rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2021"), DagdeelEnum.MIDDAG,5));
    }

    //Maak een nieuwe reservering aan, haal deze vervolgens op. De flexplek moet 5 zijn.
    @Test
    @Order(2)
    public void testOphalen() throws ParseException{
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"), DagdeelEnum.MIDDAG,5);
        Reservering r = (Reservering) rep.getById(1);
        Assertions.assertEquals(5,r.getFlexplek().getId());
    }

    //Maak een reservering aan. De functie moet false terug geven, aangezien de plek bezet is
    @Test
    @Order(3)
    public void testAanmakenOpBestaandeDatumEnTijd() throws ParseException {
        Assertions.assertEquals(false, rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2021"), DagdeelEnum.MIDDAG,5));
    }

    //Maak een reservering aan. De functie moet true terug geven, aangezien de datum bestaat maar het moment nog vrij is
    @Test
    @Order(4)
    public void testAanmakenOpBestaandeDatum() throws ParseException {
        Assertions.assertEquals(true, rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2021"), DagdeelEnum.OCHTEND,2));
    }

    //Maak een reservering aan. De functie moet true terug geven, aangezien de datum en moment bestaan, maar dit is een andere tafel
    @Test
    @Order(5)
    public void testAanmakenOpBestaandeDatumEnTijdAnderePlek() throws ParseException {
        Assertions.assertEquals(true, rest.createReservering(3, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2021"), DagdeelEnum.OCHTEND,3));
    }

}
