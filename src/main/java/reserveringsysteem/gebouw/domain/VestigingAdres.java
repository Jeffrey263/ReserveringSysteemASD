package reserveringsysteem.gebouw.domain;

public class VestigingAdres {
    private String straatnaam;
    private String postcode;
    private String land;
    private int huisnummer;
    private String toevoeging;

    public VestigingAdres(String straatnaam, String postcode, String land, int huisnummer, String toevoeging) {
        this.straatnaam = straatnaam;
        this.postcode = postcode;
        this.land = land;
        this.huisnummer = huisnummer;
        this.toevoeging = toevoeging;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getLand() {
        return land;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }
}
