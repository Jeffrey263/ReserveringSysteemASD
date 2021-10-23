package reserveringsysteem.reservering.application;

import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.domain.*;

import java.util.Date;
import java.util.List;

public class ReserveringApplicationService {
    private ReserveringRepository repository;

    public ReserveringApplicationService(ReserveringRepository repository) {
        this.repository = repository;
    }

    public boolean createReservering(FlexplexId flexplek, ReserveringsMoment moment, GebruikerId gebruiker){

        return repository.create(flexplek, moment, gebruiker);
    }
    public List<ReserveringId> getAllGeldigeReserveringen(Date start, Date eind){
        return repository.getAllGeldigeReserveringen(start, eind);

    }

}
