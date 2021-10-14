package reserveringsysteem.reservering.adapters;

import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.application.RapportageApplicationService;
import reserveringsysteem.reservering.domain.RapportageTijdbestek;

import java.util.Date;

public class RapportageRESTService {
    private RapportageApplicationService rapportageApplication;

    public RapportageRESTService(RapportageApplicationService rapportageApplication) {
        this.rapportageApplication = rapportageApplication;
    }

    //Geen echte REST functie, maar illustreerd hoe de service zou werken.
    public boolean createRapportage(int gebruikerId, Date startDatum, Date eindDatum){
        return rapportageApplication.createRapportage(new GebruikerId(gebruikerId), new RapportageTijdbestek(startDatum, eindDatum));
    }
}
