package reserveringsysteem.reservering.domain;

import java.util.Date;

public class ReserveringsMoment {
    private Date datum;
    private DagdeelEnum dagdeel;

    public ReserveringsMoment(Date datum, DagdeelEnum dagdeel) {
        this.datum = datum;
        this.dagdeel = dagdeel;
    }

    public Date getDatum() {
        return datum;
    }

    public DagdeelEnum getDagdeel() {
        return dagdeel;
    }
}
