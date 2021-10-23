package reserveringsysteem.reservering.application;

import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.domain.ReserveringRepository;
import reserveringsysteem.reservering.domain.ReserveringsMoment;

public class ReserveringApplicationService 
{
    private ReserveringRepository repository;

    public ReserveringApplicationService(ReserveringRepository repository) 
    {
        this.repository = repository;
    }

    public boolean createReservering(FlexplexId flexplek, ReserveringsMoment moment, GebruikerId gebruiker)
    {

        return repository.create(flexplek, moment, gebruiker);
    }
}
