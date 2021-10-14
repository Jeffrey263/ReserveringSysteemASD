package reserveringsysteem.reservering.domain;

public class ReserveringId {
    private int id;

    public ReserveringId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReserveringId{" +
                "id=" + id +
                '}';
    }
}
