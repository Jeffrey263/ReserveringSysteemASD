package reserveringsysteem.reservering.adapters;

import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.application.RapportageApplicationService;
import reserveringsysteem.reservering.domain.RapportageTijdbestek;

import java.util.Date;

public class RapportageRESTService 
{
    private RapportageApplicationService rapportageApplication;

    public RapportageRESTService(RapportageApplicationService rapportageApplication) 
    {
        this.rapportageApplication = rapportageApplication;
    }

    public boolean createRapportage(Date start, Date eind, int gebruiker)
    {

        RapportageTijdbestek tijdbestek = new RapportageTijdbestek(start, eind);
        GebruikerId gebruikerId = new GebruikerId(gebruiker);

        return rapportageApplication.createRapportage(tijdbestek, gebruikerId);
    }
}