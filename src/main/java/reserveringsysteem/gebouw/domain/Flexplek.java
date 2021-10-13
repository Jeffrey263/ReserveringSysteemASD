package reserveringsysteem.gebouw.domain;

public class Flexplek {
    private FlexplexId id;
    private String verdieping;
    private int nummer;
    private FlexplekEigenschappen eigenschappen;

    public Flexplek(FlexplexId id, String verdieping, int nummer, FlexplekEigenschappen eigenschappen) {
        this.id = id;
        this.verdieping = verdieping;
        this.nummer = nummer;
        this.eigenschappen = eigenschappen;
    }

    public FlexplexId getId() {
        return id;
    }

    public void setId(FlexplexId id) {
        this.id = id;
    }

    public String getVerdieping() {
        return verdieping;
    }

    public void setVerdieping(String verdieping) {
        this.verdieping = verdieping;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public FlexplekEigenschappen getEigenschappen() {
        return eigenschappen;
    }

    public void setEigenschappen(FlexplekEigenschappen eigenschappen) {
        this.eigenschappen = eigenschappen;
    }
}
