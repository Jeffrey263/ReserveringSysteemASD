package reserveringsysteem.reservering.domain;

import reserveringsysteem.Repository;
import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;

import java.util.ArrayList;
import java.util.Date;
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
        for (Reservering r : reserveringen) {
            if (id == r.getId()) {
                return r;
            }
        }
        return null;
    }

    public boolean create(FlexplexId flexplek, ReserveringsMoment moment, GebruikerId gebruiker) {
        for (Reservering r : reserveringen) {
            if (r.isBezet(moment, flexplek)) {
                return false;
            }
        }

        int id = 0;
        if (reserveringen != null && !reserveringen.isEmpty()) {
            id = reserveringen.size();
        }
        ReserveringId reserveringId = new ReserveringId(id);
        Reservering nieuweReservering = new Reservering(reserveringId, flexplek, gebruiker, moment);
        add(nieuweReservering);

        return true;
    }

    //Codehulp van Jeffrey
    public List<ReserveringId> getByTijdbestek(RapportageTijdbestek tijd)
    {
        List<ReserveringId> resList = new ArrayList<ReserveringId>();

        for (Reservering r : reserveringen)
        {
            if(r.valtTussen(tijd))
            {
                resList.add(new ReserveringId(r.getId()));
            }
        }
        return resList;
    }

    public boolean annuleer(ReserveringId id){
        for (Reservering r : reserveringen) {
            if (r.getId() == id.getId()) {
                if (r.isGeboekt(r.getStatus())) {
                    r.setStatus(ReserveringStatusEnum.GEANNULEERD);
                    return true;
                }
            }
        }
        return false;
    }

    public List<ReserveringId> getAllGeldigeReserveringen(Date start, Date eind) {
        List<ReserveringId> resList = new ArrayList<ReserveringId>();
            for (Reservering r : reserveringen) {
                if (r.getStatus() == ReserveringStatusEnum.GELDIG && ((r.getMoment().getDatum().after(start) && r.getMoment().getDatum().before(eind)) || r.getMoment().getDatum().equals(start) || r.getMoment().getDatum().equals(eind))){
                    resList.add( new ReserveringId(r.getId()));
                }
            }
        return resList;
    }
}
