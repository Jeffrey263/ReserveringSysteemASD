package reserveringsysteem.reservering.domain;

import reserveringsysteem.gebruiker.GebruikerId;

import java.util.List;

public class Rapportage {
    private RapportageId id;
    private RapportageTijdbestek tijdbestek;
    private GebruikerId aanvrager;
    private List<ReserveringId> reserveringen;

    public Rapportage(RapportageId id, RapportageTijdbestek tijdbestek, GebruikerId aanvrager, List<ReserveringId> reserveringen) {
        this.id = id;
        this.tijdbestek = tijdbestek;
        this.aanvrager = aanvrager;
        this.reserveringen = reserveringen;
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

    public List<ReserveringId> getReserveringen() {
        return reserveringen;
    }

    public void setReserveringen(List<ReserveringId> reserveringen) {
        this.reserveringen = reserveringen;
    }
}
