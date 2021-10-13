package reserveringsysteem.gebouw.domain;

import reserveringsysteem.Repository;

import java.util.ArrayList;
import java.util.List;

public class FlexplekRepository implements Repository {
    List<Flexplek> flexplekken;

    public FlexplekRepository() {
        flexplekken = new ArrayList<Flexplek>();
    }

    @Override
    public void add(Object o) {
        flexplekken.add(((Flexplek) o));
    }

    @Override
    public void remove(Object o) {
        flexplekken.remove(((Flexplek) o));
    }

    @Override
    public List getAll() {
        return flexplekken;
    }

    @Override
    public Object getById(int id) {
        for(Flexplek f : flexplekken){
            if(id == f.getId().getId()){
                return f;
            }
        }
        return null;
    }
}
