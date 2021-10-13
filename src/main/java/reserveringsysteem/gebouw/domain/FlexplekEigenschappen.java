package reserveringsysteem.gebouw.domain;

public class FlexplekEigenschappen {
    private FormaatEnum formaat;
    private boolean pc;
    private boolean dockingStation;
    private boolean mediaApparatuur;

    public FlexplekEigenschappen(FormaatEnum formaat, boolean pc, boolean dockingStation, boolean mediaApparatuur) {
        this.formaat = formaat;
        this.pc = pc;
        this.dockingStation = dockingStation;
        this.mediaApparatuur = mediaApparatuur;
    }

    public FormaatEnum getFormaat() {
        return formaat;
    }

    public boolean isPc() {
        return pc;
    }

    public boolean isDockingStation() {
        return dockingStation;
    }

    public boolean isMediaApparatuur() {
        return mediaApparatuur;
    }
}
