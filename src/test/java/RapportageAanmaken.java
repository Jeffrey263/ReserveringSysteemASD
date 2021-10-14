import org.junit.jupiter.api.*;
import reserveringsysteem.reservering.adapters.RapportageRESTService;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.application.RapportageApplicationService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.DagdeelEnum;
import reserveringsysteem.reservering.domain.Rapportage;
import reserveringsysteem.reservering.domain.RapportageRepository;
import reserveringsysteem.reservering.domain.ReserveringRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RapportageAanmaken {

    static ReserveringRepository resRep;
    static ReserveringApplicationService resApp;
    static ReserveringRESTService resRest;

    static RapportageRepository rapRep;
    static RapportageApplicationService rapApp;
    static RapportageRESTService rapRest;


    @BeforeAll
    public static void setUp() throws ParseException {
        resRep = new ReserveringRepository();
        resApp= new ReserveringApplicationService(resRep);
        resRest = new ReserveringRESTService(resApp);

        rapRep = new RapportageRepository(resRep);
        rapApp = new RapportageApplicationService(rapRep);
        rapRest = new RapportageRESTService(rapApp);

        //Voeg reserveringen toe die opgehaald kunnen worden
        resRest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"), DagdeelEnum.MIDDAG,1);
        resRest.createReservering(4, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"), DagdeelEnum.MIDDAG,5);
        resRest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2021"), DagdeelEnum.MIDDAG,3);
        resRest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2021"), DagdeelEnum.MIDDAG,5);
        resRest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2021"), DagdeelEnum.MIDDAG,7);
        resRest.createReservering(4, new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2021"), DagdeelEnum.MIDDAG,5);
        resRest.createReservering(1, new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021"), DagdeelEnum.MIDDAG,2);
        resRest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021"), DagdeelEnum.MIDDAG,3);
        resRest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"), DagdeelEnum.MIDDAG,5);
        resRest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2022"), DagdeelEnum.MIDDAG,1);
        resRest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2022"), DagdeelEnum.MIDDAG,5);
    }

    @Test
    @Order(1)
    public void testRapportageMaken() throws ParseException {
        Assertions.assertEquals(true,rapRest.createRapportage(2,new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"),new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2022")));
        Rapportage r = (Rapportage) rapRep.getById(0);
        Assertions.assertEquals(11, r.getReserveringen().size());
    }

    @Test
    @Order(2)
    public void testRapportageMakenSelectie() throws ParseException {
        Assertions.assertEquals(true,rapRest.createRapportage(2,new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2021"),new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021")));
        Rapportage r = (Rapportage) rapRep.getById(1);
        Assertions.assertEquals(6, r.getReserveringen().size());
    }

    @Test
    @Order(3)
    public void testRapportageMakenBuitenDatum() throws ParseException {
        Assertions.assertEquals(true,rapRest.createRapportage(2,new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"),new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2020")));
        Rapportage r = (Rapportage) rapRep.getById(2);
        Assertions.assertEquals(0, r.getReserveringen().size());
    }

    @Test
    @Order(4)
    public void testRapportageMakenDatumsOmgedraaid() throws ParseException {
        Assertions.assertEquals(false, rapRest.createRapportage(2,new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2022"),new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021")));
    }

    @Test
    @Order(5)
    public void testRapportageMakenDubbeleDatum() throws ParseException {
        Assertions.assertEquals(true, rapRest.createRapportage(2,new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"),new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021")));
        Rapportage r = (Rapportage) rapRep.getById(3);
        Assertions.assertEquals(2, r.getReserveringen().size());
    }
}
