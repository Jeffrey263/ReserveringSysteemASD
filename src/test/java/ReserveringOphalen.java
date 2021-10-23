import org.junit.jupiter.api.BeforeAll;
import reserveringsysteem.reservering.adapters.ReserveringRESTService;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.DagdeelEnum;
import reserveringsysteem.reservering.domain.ReserveringRepository;

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

        //Voeg reserveringen toe die opgehaald kunnen worden
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"), DagdeelEnum.MIDDAG,1);
        rest.createReservering(4, new SimpleDateFormat("dd/MM/yyyy").parse("01/12/2021"), DagdeelEnum.MIDDAG,5);
        rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2021"), DagdeelEnum.MIDDAG,3);
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2021"), DagdeelEnum.MIDDAG,5);
        rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2021"), DagdeelEnum.MIDDAG,7);
        rest.createReservering(4, new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2021"), DagdeelEnum.MIDDAG,5);
        rest.createReservering(1, new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021"), DagdeelEnum.MIDDAG,2);
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2021"), DagdeelEnum.MIDDAG,3);
        rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021"), DagdeelEnum.MIDDAG,5);
        rest.createReservering(2, new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2022"), DagdeelEnum.MIDDAG,1);
        rest.createReservering(5, new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2022"), DagdeelEnum.MIDDAG,5);
    }
}
