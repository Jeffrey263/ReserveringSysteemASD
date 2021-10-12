package domain.gebouw;

import java.util.ArrayList;
import java.util.List;

public class Vestiging {
    private VestigingId id;
    private VestigingAdres adres;
    private String telefoonNummer;
    private List<FlexplexId> flexplekken;

    public Vestiging(VestigingId id, VestigingAdres adres, String telefoonNummer) {
        flexplekken = new ArrayList<FlexplexId>();
        this.id = id;
        this.adres = adres;
        this.telefoonNummer = telefoonNummer;
    }

    public VestigingId getId() {
        return id;
    }

    public void setId(VestigingId id) {
        this.id = id;
    }

    public VestigingAdres getAdres() {
        return adres;
    }

    public void setAdres(VestigingAdres adres) {
        this.adres = adres;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public List<FlexplexId> getFlexPlekken() {
        return flexplekken;
    }

    public void setFlexplekken(List<FlexplexId> flexplekken) {
        this.flexplekken = flexplekken;
    }

    public void addFlexplek(FlexplexId flexplek){
        this.flexplekken.add(flexplek);
    }

    public void removeFlexplek(FlexplexId flexplek){
        for (FlexplexId f : flexplekken){
            if (f.getId() == flexplek.getId()){
                this.flexplekken.remove(f);
            }
        }
    }

    @Override
    public String toString() {
        return "\nVestiging{" +
                "id=" + id +
                ", adres=" + adres +
                ", telefoonNummer='" + telefoonNummer + '\'' +
                ", flexplekken=" + flexplekken +
                '}';
    }
}
