import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.DagdeelEnum;
import reserveringsysteem.reservering.domain.Reservering;
import reserveringsysteem.reservering.domain.ReserveringRepository;
import reserveringsysteem.reservering.domain.ReserveringStatusEnum;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReserveringOphalen {
    static ReserveringRepository rep;
    static ReserveringApplicationService app;
    static ReserveringRESTService rest;

    @BeforeAll
    public static void setUp() throws ParseException {
        rep = new ReserveringRepository();
        app = new ReserveringApplicationService(rep);
        rest = new ReserveringRESTService(app);

        //geldige reservering
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2022"), DagdeelEnum.MIDDAG, 2);
    }


    //lege lijst met reserveringen want verleden == geen geldige reserveringen
    @Test
    @Order(1)
    public void testOphalen1() throws ParseException {
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2020"), DagdeelEnum.MIDDAG, 3);
        Reservering r = (Reservering) rep.getById(1);
        r.setStatus(ReserveringStatusEnum.VERLOPEN);
        Assertions.assertEquals(0, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021")).size());
    }

    //geannuleerde reservering == lege lijst
    @Test
    @Order(2)
    public void testOphalen2() throws ParseException {
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"), DagdeelEnum.MIDDAG, 1);
        Reservering r = (Reservering) rep.getById(1);
        r.setStatus(ReserveringStatusEnum.GEANNULEERD);
        System.out.println(rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("02/12/2021")));
        Assertions.assertEquals(0, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("02/12/2021")).size());

    }


    //testresultaat is een list met 1 id door 1 geldige reservering binnen de gespecificeerde datums
    @Test
    @Order(3)
    public void testOphalen3() throws ParseException {
        Assertions.assertEquals(1, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("02/12/2022")).size());

    }

    //testresultaat is een list met 1 id van een geldige reservering op de gespecificeerde start datum
    @Test
    @Order(4)
    public void testOphalen4() throws ParseException {
        Assertions.assertEquals(1, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("02/12/2022")).size());
    }


    //testresultaat is een list met 1 id van een geldige reservering op de gespecificeerde eind datum
    @Test
    @Order(5)
    public void testOphalen5() throws ParseException {
        Assertions.assertEquals(1, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2022")).size());
    }


    //testresultaat is 0 omdat eind datum voor begin datum ligt
    @Test
    @Order(6)
    public void testOphalen6() throws ParseException {
        Assertions.assertEquals(0, rest.getAllGeldigeReserveringen(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021")).size());
    }


}
