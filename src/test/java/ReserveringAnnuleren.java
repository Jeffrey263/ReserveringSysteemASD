import org.junit.jupiter.api.*;
import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.ReserveringRepository;
import reserveringsysteem.reservering.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReserveringAnnuleren {

    static ReserveringRepository rep;
    static ReserveringApplicationService app;
    static ReserveringRESTService rest;

    @BeforeAll
    public static void setUp(){
        rep = new ReserveringRepository();
        app = new ReserveringApplicationService(rep);
        rest = new ReserveringRESTService(app);
    }

    //Annuleer een Reservering. De functie moet true terug geven
    @Test
    @Order(1)
    public void testAnnuleren() throws ParseException{
        // dit blok aan code is alleen nodig tijdens deze unit test

        ReserveringsMoment moment = new ReserveringsMoment(new SimpleDateFormat("dd/MM/yyyy").parse("5/12/2021"), DagdeelEnum.AVOND);
        ReserveringId reserveringId = new ReserveringId(1);
        FlexplexId flexplexId = new FlexplexId(5);
        GebruikerId gebruikerId = new GebruikerId(3);
        Reservering res1 = new Reservering(reserveringId, flexplexId, gebruikerId, moment);
        rep.add(res1);

        Assertions.assertEquals(true, rest.annuleerReservering(1));
    }

    //Annuleer een geannuleerde reservering. De functie moet false terug geven
    @Test
    @Order(2)
    public void testGeannuleerdeAnnuleren() throws ParseException{
        // dit blok aan code is alleen nodig tijdens deze unit test
        ReserveringsMoment moment = new ReserveringsMoment(new SimpleDateFormat("dd/MM/yyyy").parse("5/12/2021"), DagdeelEnum.AVOND);
        ReserveringId reserveringId = new ReserveringId(1);
        FlexplexId flexplexId = new FlexplexId(5);
        GebruikerId gebruikerId = new GebruikerId(3);
        Reservering res1 = new Reservering(reserveringId, flexplexId, gebruikerId, moment);
        res1.setStatus(ReserveringStatusEnum.GEANNULEERD);
        rep.add(res1);

        Assertions.assertEquals(false, rest.annuleerReservering(1));
    }

    //Annuleer een verlopen reservering. De functie moet false terug geven
    @Test
    @Order(3)
    public void testVerlopenAnnuleren() throws ParseException{
        // dit blok aan code is alleen nodig tijdens deze unit test
        ReserveringsMoment moment = new ReserveringsMoment(new SimpleDateFormat("dd/MM/yyyy").parse("5/12/2021"), DagdeelEnum.AVOND);
        ReserveringId reserveringId = new ReserveringId(1);
        FlexplexId flexplexId = new FlexplexId(5);
        GebruikerId gebruikerId = new GebruikerId(3);
        Reservering res1 = new Reservering(reserveringId, flexplexId, gebruikerId, moment);
        ReserveringRepository resList1 = new ReserveringRepository();
        res1.setStatus(ReserveringStatusEnum.VERLOPEN);
        rep.add(res1);

        Assertions.assertEquals(false, rest.annuleerReservering(res1.getId()));
    }
}
