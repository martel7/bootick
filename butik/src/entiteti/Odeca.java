package entiteti;

public class Odeca extends Proizvod{

    private String boja;
    private String proizvodjac;

    public Odeca(String naziv, double cena, int kolicina, String boja, String proizvodjac) {
        super(naziv, cena, kolicina);
        this.boja = boja;
        this.proizvodjac = proizvodjac;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    @Override
    public String toString() {
        return "Naziv: " + super.getNaziv() +
                ", Cena: " + super.getCena() +
                ", Kolicina: " + super.getKolicina() +
                ", Boja: " + boja +
                ", Proizvodjac: " + proizvodjac;
    }
}
