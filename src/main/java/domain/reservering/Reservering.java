package domain.reservering;

import domain.gebouw.FlexplexId;
import domain.gebruiker.GebruikerId;

public class Reservering {
    private ReserveringId id;
    private ReserveringStatusEnum status;
    private FlexplexId flexplek;
    private GebruikerId gebruiker;
    private  ReserveringsMoment moment;

    public Reservering(ReserveringId id, ReserveringStatusEnum status, FlexplexId flexplek, GebruikerId gebruiker, ReserveringsMoment moment) {
        this.id = id;
        this.status = status;
        this.flexplek = flexplek;
        this.gebruiker = gebruiker;
        this.moment = moment;
    }

    public ReserveringId getId() {
        return id;
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
}
