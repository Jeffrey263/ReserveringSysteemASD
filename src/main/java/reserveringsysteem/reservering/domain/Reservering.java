package reserveringsysteem.reservering.domain;

import reserveringsysteem.gebouw.domain.FlexplexId;
import reserveringsysteem.gebruiker.GebruikerId;
import reserveringsysteem.reservering.domain.RapportageTijdbestek;

public class Reservering {
    private ReserveringId id;
    private ReserveringStatusEnum status;
    private FlexplexId flexplek;
    private GebruikerId gebruiker;
    private  ReserveringsMoment moment;

    public Reservering(ReserveringId id,  FlexplexId flexplek, GebruikerId gebruiker, ReserveringsMoment moment) {
        this.id = id;
        this.status = ReserveringStatusEnum.GELDIG;
        this.flexplek = flexplek;
        this.gebruiker = gebruiker;
        this.moment = moment;
    }

    public boolean isBezet(ReserveringsMoment m, FlexplexId f){
        if (moment.getDatum().equals(m.getDatum())) {
            if (moment.getDagdeel().equals(m.getDagdeel())) {
                if(flexplek.getId() == f.getId()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGeboekt(ReserveringStatusEnum s){
        if(s == ReserveringStatusEnum.GELDIG){
            return true;
        }
        return false;
    }

    public int getId() {
        return id.getId();
    }

    public void setId(ReserveringId id) {
        this.id = id;
    }

    public ReserveringStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReserveringStatusEnum status) {
        this.status = status;
    }

    public FlexplexId getFlexplek() {
        return flexplek;
    }

    public void setFlexplek(FlexplexId flexplek) {
        this.flexplek = flexplek;
    }

    public GebruikerId getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(GebruikerId gebruiker) {
        this.gebruiker = gebruiker;
    }

    public ReserveringsMoment getMoment() {
        return moment;
    }

    public void setMoment(ReserveringsMoment moment) {
        this.moment = moment;
    }

    //Codehulp van Jeffrey
    public boolean valtTussen (RapportageTijdbestek tijd)
    {
        if(moment.getDatum().after(tijd.getStart()) && moment.getDatum().before(tijd.getEind()) 
            || moment.getDatum().equals(tijd.getStart()) || moment.getDatum().equals(tijd.getEind()))
        {
            return true;
        }
            else
                return false;
    }
}
