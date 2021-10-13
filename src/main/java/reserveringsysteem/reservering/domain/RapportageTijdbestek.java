package reserveringsysteem.reservering.domain;

import java.util.Date;

public class RapportageTijdbestek {
    private Date start;
    private  Date eind;

    public RapportageTijdbestek(Date start, Date eind) {
        this.start = start;
        this.eind = eind;
    }

    public Date getStart() {
        return start;
    }

    public Date getEind() {
        return eind;
    }
}
