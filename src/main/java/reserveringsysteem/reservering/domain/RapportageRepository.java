package reserveringsysteem.reservering.domain;

import reserveringsysteem.Repository;
import reserveringsysteem.gebruiker.GebruikerId;

import java.util.ArrayList;
import java.util.List;

public class RapportageRepository implements Repository {
    private List<Rapportage> rapportages;
    private ReserveringRepository reserveringRepository;

    public RapportageRepository(ReserveringRepository rep) {
        reserveringRepository = rep;
        rapportages = new ArrayList<Rapportage>();
    }

    @Override
    public void add(Object o) {
        rapportages.add((Rapportage) o);
    }

    @Override
    public void remove(Object o) {
        rapportages.remove((Rapportage) o);
    }

    @Override
    public List getAll() {
        return rapportages;
    }

    @Override
    public Object getById(int id) {
        for(Rapportage r : rapportages){
            if(id == r.getId().getId()){
                return r;
            }
        }
        return null;
    }

    public boolean create(GebruikerId gebruiker, RapportageTijdbestek tijd){
        //check of datums goede volgorde hebben:
        if(tijd.getEind().before(tijd.getStart())){
            return false;
        }

        List<ReserveringId> resList = reserveringRepository.getByTijdbestek(tijd);

        int id = 0;
        if (rapportages != null && !rapportages.isEmpty()) {
            id = rapportages.size();
        }

        rapportages.add(new Rapportage(new RapportageId(id),tijd,gebruiker,resList));
        return true;
    }
}
