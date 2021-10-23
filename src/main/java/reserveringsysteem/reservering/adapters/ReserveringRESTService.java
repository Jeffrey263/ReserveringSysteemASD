package reserveringsysteem.reservering.adapters;

import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.application.ReserveringApplicationService;
import reserveringsysteem.reservering.domain.DagdeelEnum;
import reserveringsysteem.reservering.domain.ReserveringsMoment;
import reserveringsysteem.reservering.domain.ReserveringId;

import java.util.Date;

public class ReserveringRESTService {
    private ReserveringApplicationService reserveringApplication;

    public ReserveringRESTService(ReserveringApplicationService reserveringApplication) {
        this.reserveringApplication = reserveringApplication;
    }

    //Geen echte REST functie, maar illustreerd hoe de service zou werken.
    public boolean createReservering(int flexplek, Date datum, DagdeelEnum dagdeel, int gebruiker){

        FlexplexId flexplekId = new FlexplexId(flexplek);
        ReserveringsMoment moment = new ReserveringsMoment(datum, dagdeel);
        GebruikerId gebruikerId = new GebruikerId(gebruiker);

        return reserveringApplication.createReservering(flexplekId, moment, gebruikerId);
    }

    public  boolean annuleerReservering(int reservering){

        ReserveringId reserveringId = new ReserveringId(reservering);

        return reserveringApplication.annuleerReservering(reserveringId);
    }

}
