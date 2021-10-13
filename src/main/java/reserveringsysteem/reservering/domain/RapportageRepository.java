package reserveringsysteem.reservering.domain;

import reserveringsysteem.Repository;

import java.util.ArrayList;
import java.util.List;

public class RapportageRepository implements Repository {
    private List<Rapportage> rapportages;

    public RapportageRepository() {
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
}
