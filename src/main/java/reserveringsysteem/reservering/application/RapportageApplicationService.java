package reserveringsysteem.reservering.application;

import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.domain.RapportageRepository;
import reserveringsysteem.reservering.domain.RapportageTijdbestek;

public class RapportageApplicationService
{
	private RapportageRepository repository;

    public RapportageApplicationService(RapportageRepository repository) 
    {
        this.repository = repository;
    }

    public boolean createRapportage(RapportageTijdbestek tijdbestek, GebruikerId gebruiker)
    {

        return repository.create(tijdbestek, gebruiker);
    }
}
