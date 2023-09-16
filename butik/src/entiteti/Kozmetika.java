package entiteti;

public class Kozmetika extends Proizvod{

    private String vrsta;
    private boolean organska;

    public Kozmetika(String naziv, double cena, int kolicina, String vrsta, boolean organska) {
        super(naziv, cena, kolicina);
        this.vrsta = vrsta;
        this.organska = organska;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public boolean isOrganska() {
        return organska;
    }

    public void setOrganska(boolean organska) {
        this.organska = organska;
    }

    @Override
    public String toString() {
        return "Naziv: " + super.getNaziv() +
                ", Cena: " + super.getCena() +
                ", Kolicina: " + super.getKolicina() +
                ", Vrsta: " + vrsta +
                ", Organska: " + organska;
    }
}
