package reserveringsysteem.reservering.domain;

import reserveringsysteem.gebruiker.GebruikerId;

public class Rapportage {
    private RapportageId id;
    private RapportageTijdbestek tijdbestek;
    private GebruikerId aanvrager;

    public Rapportage(RapportageId id, RapportageTijdbestek tijdbestek, GebruikerId aanvrager) {
        this.id = id;
        this.tijdbestek = tijdbestek;
        this.aanvrager = aanvrager;
    }

    public RapportageId getId() {
        return id;
    }

    public void setId(RapportageId id) {
        this.id = id;
    }

    public RapportageTijdbestek getTijdbestek() {
        return tijdbestek;
    }

    public void setTijdbestek(RapportageTijdbestek tijdbestek) {
        this.tijdbestek = tijdbestek;
    }

    public GebruikerId getAanvrager() {
        return aanvrager;
    }

    public void setAanvrager(GebruikerId aanvrager) {
        this.aanvrager = aanvrager;
    }
}
