package domain.reservering;

import domain.Repository;
import domain.gebouw.Flexplek;

import java.util.ArrayList;
import java.util.List;

public class ReserveringRepository implements Repository {
    private List<Reservering> reserveringen;

    public ReserveringRepository() {
        reserveringen = new ArrayList<Reservering>();
    }

    @Override
    public void add(Object o) {
        reserveringen.add((Reservering) o);
    }

    @Override
    public void remove(Object o) {
        reserveringen.remove((Reservering) o);
    }

    @Override
    public List getAll() {
        return reserveringen;
    }

    @Override
    public Object getById(int id) {
        for(Reservering r : reserveringen){
            if(id == r.getId().getId()){
                return r;
            }
        }
        return null;
    }
}
