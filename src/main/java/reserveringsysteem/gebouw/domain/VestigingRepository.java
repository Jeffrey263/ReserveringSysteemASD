package reserveringsysteem.gebouw.domain;

import reserveringsysteem.Repository;

import java.util.ArrayList;
import java.util.List;

public class VestigingRepository implements Repository {
    private List<Vestiging> vestigingen;

    public VestigingRepository() {
        vestigingen = new ArrayList<Vestiging>();
    }

    @Override
    public void add(Object o) {
        vestigingen.add((Vestiging) o);
    }

    @Override
    public void remove(Object o) {
        vestigingen.remove((Vestiging) o);
    }

    @Override
    public List<Vestiging> getAll() {
        return vestigingen;
    }

    @Override
    public Object getById(int id) {
        for(Vestiging v : vestigingen){
            if(id == v.getId().getId()){
                return v;
            }
        }
        return null;
    }
}
